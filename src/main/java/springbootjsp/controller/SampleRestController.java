package springbootjsp.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import springbootjsp.model.TTasks;
import springbootjsp.services.TaskService;

@RestController
public class SampleRestController {

	@Autowired
	private TaskService tasksService;
	
	@GetMapping(path="/hello")
	public String hello(){
		return "Hello from Spring!";
	}
	
	@GetMapping(path="/all-tasks")
	public String allTasks(){
		
		return tasksService.findAll().toString();
	}
	@GetMapping(path="/tasks")
	public List<TTasks> allTasksJson(){
		
		return tasksService.findAll();
	}
	@PostMapping(path="/tasks")
	public ResponseEntity<TTasks> saveTask(@RequestBody TTasks task){
		System.out.println("saveTask:"+task.toString());
		TTasks saved = tasksService.save(task);
		return new ResponseEntity<>(saved, HttpStatus.CREATED);
	}
	@DeleteMapping(path="/tasks/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
		
		TTasks result = tasksService.findById(id);
		if(result==null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		tasksService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
        
        @GetMapping(path="/tasks/{id}")
	public ResponseEntity<TTasks> get(@PathVariable("id") int id){
		
		TTasks result = tasksService.findById(id);
		if(result==null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
	
}
