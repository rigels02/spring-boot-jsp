package springbootjsp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springbootjsp.dao.ITasksRepository;
import springbootjsp.model.TTasks;

@Service
@Transactional
public class TaskService {

	private final ITasksRepository repo;

	public TaskService(ITasksRepository repo) {
		
		this.repo = repo;
	}
	public List<TTasks>	findAll(){
		List<TTasks> tasks = new ArrayList<>();
		
		for (TTasks tTask : repo.findAll()) {
			tasks.add(tTask);
		}
		return tasks;
	}
	public TTasks save(TTasks task){
		return repo.save(task);
		
	}
	public void delete(Integer id){
		repo.delete(id);
	}
	public TTasks findById(Integer id){
		
		return repo.findOne(id);
	}
	
}
