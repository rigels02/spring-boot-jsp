package springbootjsp.dao;

import org.springframework.data.repository.CrudRepository;

import springbootjsp.model.TTasks;

public interface ITasksRepository extends CrudRepository<TTasks, Integer>{

}
