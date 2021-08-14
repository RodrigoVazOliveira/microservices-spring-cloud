package br.com.rvz.hrworker.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.rvz.hrworker.entities.Worker;

public interface WorkerRepository extends CrudRepository<Worker, Long> {

}
