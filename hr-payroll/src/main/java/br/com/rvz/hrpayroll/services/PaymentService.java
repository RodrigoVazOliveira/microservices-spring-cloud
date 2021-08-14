package br.com.rvz.hrpayroll.services;

import org.springframework.stereotype.Service;

import br.com.rvz.hrpayroll.entities.Payment;

@Service
public class PaymentService {
	
	public Payment getPayment(Long workerId, Integer days) {
		Payment payment = new Payment();
		payment.setName("Bob");
		payment.setDailyincome(200.00);
		payment.setDays(days);
		
		return payment;
	}
}
