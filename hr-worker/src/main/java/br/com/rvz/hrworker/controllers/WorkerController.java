package br.com.rvz.hrworker.controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.rvz.hrworker.entities.Worker;
import br.com.rvz.hrworker.repositories.WorkerRepository;

@RestController
@RequestMapping("workers/")
public class WorkerController {
	
	private static final Logger log = LoggerFactory.getLogger(WorkerController.class);
	
	@Autowired
	private Environment env;
	
	private final WorkerRepository workerRepository;

	public WorkerController(WorkerRepository workerRepository) {
		this.workerRepository = workerRepository;
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Iterable<Worker> getAllWorkers() {
		return this.workerRepository.findAll();
	}
	
	@GetMapping("/{id}/")
	@ResponseStatus(HttpStatus.OK)
	public Worker findWorkerById(@PathVariable(name = "id") Long id) {
		log.info( "PORT = " + env.getProperty("local.server.port"));
		Optional<Worker> optionalWorker = workerRepository.findById(id);
		
		if (optionalWorker.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Trabalhador não encontrado com ID " + id);
		}
		
		return optionalWorker.get();
	}
}
