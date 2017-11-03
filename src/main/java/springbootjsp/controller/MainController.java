package springbootjsp.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import springbootjsp.model.TTasks;

import springbootjsp.services.TaskService;

@Controller
public class MainController {

	@Autowired
	private TaskService tasksService;
	
        @Value("${server.contextPath}") 
        private String contextRoot;
        
	@RequestMapping(path="/",method=RequestMethod.GET)
	public String home(){
		return "index";
	}
        
        
        
        @RequestMapping(path="/webtasks",method=RequestMethod.GET)
	public String tasks(
                Model taskList){
            
            List<TTasks> result = tasksService.findAll();
            taskList.addAttribute("taskList", result);
		return "list-tasks";
	}
        
        
        @RequestMapping(path="/webtasks/do", method=RequestMethod.GET)
        public String taskById(@RequestParam(name="id") int id, 
                @RequestParam(name="action") String action,
                Model model){
        
            if(action.contentEquals("searchById")){
                TTasks result = tasksService.findById(id);
                model.addAttribute("task", result);
                model.addAttribute("action", action);
                
            }else if(action.contentEquals("remove")){
               tasksService.delete(id);
               List<TTasks> result = tasksService.findAll();
                model.addAttribute("message", "The selected task deleted");
                model.addAttribute("taskList", result);
               return "list-tasks";
            }
            return "new-task";
        }
        
        @RequestMapping(path="/webtasks/new-task",method=RequestMethod.GET)
        public String newTask(){
         return "new-task";
        }
        
        @RequestMapping(path="/webtasks",method = RequestMethod.POST)
        public String postTask(
                @RequestParam(name = "name") String name,
                @RequestParam(name = "createdate") String create_date,
                @RequestParam(name = "descriptor") String descriptor,
                @RequestParam(name = "completed") String completed,
                @RequestParam(name = "idTask") String id,
                Model model
                ){
            
            String message=null;
            SimpleDateFormat df= new SimpleDateFormat("dd-MM-yyyy HH:mm");
            Date cdate;
            boolean tcompleted=false;
            try {
                cdate = df.parse(create_date);
            } catch (ParseException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                message= "Wrong Date format!";
                model.addAttribute("message", message);
                return "new-task";
            }
            tcompleted= (completed.contentEquals("1"));
            if(id==null || id.isEmpty()){
            TTasks ntask = new TTasks(name, descriptor, cdate, tcompleted);
            TTasks result = tasksService.save(ntask);
            message=(result.getId()>0)?"New task saved":"New task NOT saved";
            
            }else{
               TTasks ntask = new TTasks(name, descriptor, cdate, tcompleted);
               ntask.setId(Integer.parseInt(id));
            TTasks result = tasksService.save(ntask);
             message=(result.getId()>0)?"Task Updated":"Task NOT updated";
            }
            List<TTasks> tlist = tasksService.findAll();
            model.addAttribute("message", message);
            model.addAttribute("taskList",tlist);
            return "list-tasks";
        }
}
