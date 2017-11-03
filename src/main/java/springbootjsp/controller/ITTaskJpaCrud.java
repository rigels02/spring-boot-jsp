package springbootjsp.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import springbootjsp.model.TTasks;

public interface ITTaskJpaCrud extends JpaRepository<TTasks, Integer> {

}
