package br.com.rvz.hrworker.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.rvz.hrworker.entities.Worker;
import br.com.rvz.hrworker.repositories.WorkerRepository;

@RestController
@RequestMapping("workers/")
public class WorkerController {
	
	private final WorkerRepository workerRepository;

	public WorkerController(WorkerRepository workerRepository) {
		this.workerRepository = workerRepository;
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Iterable<Worker> getAllWorkers() {
		return this.workerRepository.findAll();
	}
}
