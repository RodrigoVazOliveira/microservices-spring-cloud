package br.com.rvz.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.rvz.hrpayroll.entities.Payment;
import br.com.rvz.hrpayroll.entities.Worker;

@Service
public class PaymentService {
	
	@Value("${hr-worker.host}")
	private String hrWorkerHost;
	
	private RestTemplate restTemplate;
	
	public PaymentService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public Payment getPayment(Long workerId, Integer days) {
		Map<String, String> uriVarable = new HashMap<>();
		uriVarable.put("id", workerId.toString());
		
		Worker worker = restTemplate.getForObject(hrWorkerHost + "/workers/{id}/",
				Worker.class, uriVarable);
		
		Payment payment = new Payment();
		payment.setName(worker.getName());
		payment.setDailyincome(worker.getDailyIncome());
		payment.setDays(days);
		
		return payment;
	}
}
