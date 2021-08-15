package br.com.rvz.hrpayroll.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.rvz.hrpayroll.entities.Payment;
import br.com.rvz.hrpayroll.services.PaymentService;

@RestController
@RequestMapping("/payments/")
public class PaymentController {

	private final PaymentService paymentService;

	public PaymentController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	@GetMapping(value = "/{workerId}/days/{days}/")
	@ResponseStatus(HttpStatus.OK)
	public Payment getPayment(@PathVariable(name = "workerId") Long workerId, @PathVariable(name = "days") Integer days) {
		return paymentService.getPayment(workerId, days);
	}
}
