package br.com.rvz.hrpayroll.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.rvz.hrpayroll.entities.Worker;

@Component
@FeignClient(name = "hr-worker", path = "/workers/")
public interface WorkerFeignClient  {
	
	@GetMapping("/{id}/")
	@ResponseStatus(HttpStatus.OK)
	Worker findWorkerById(@PathVariable(name = "id") Long id);
}
