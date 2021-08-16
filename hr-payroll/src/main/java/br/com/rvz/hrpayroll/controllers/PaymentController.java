package br.com.rvz.hrpayroll.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rvz.hrpayroll.entities.Payment;
import br.com.rvz.hrpayroll.services.PaymentService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/payments/")
public class PaymentController {

	private final PaymentService paymentService;

	public PaymentController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}
	
	@CircuitBreaker(name = "hr-worker", fallbackMethod = "getPaymentsAlternative")
	@GetMapping(value = "/{workerId}/days/{days}/")
	public ResponseEntity<Payment> getPayment(@PathVariable(name = "workerId") Long workerId, @PathVariable(name = "days") Integer days) {
		return ResponseEntity.ok(paymentService.getPayment(workerId, days));
	}
	
	public ResponseEntity<Payment> getPaymentsAlternative(Long workerId, Integer days, RuntimeException ex) {
		Payment payment = new Payment();
		payment.setName("NoName");
		payment.setDailyincome(1.0);
		payment.setDays(1);
		
		return ResponseEntity.ok(payment);	
	}
}
