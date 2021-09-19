package br.com.rvz.hrpayroll.services;

import br.com.rvz.hrpayroll.entities.Payment;
import br.com.rvz.hrpayroll.entities.Worker;
import br.com.rvz.hrpayroll.feignclients.WorkerFeignClient;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final WorkerFeignClient workerFeignClient;

    public PaymentService(WorkerFeignClient workerFeignClient) {
        this.workerFeignClient = workerFeignClient;
    }

    public Payment getPayment(Long workerId, Integer days) {
        Worker worker = workerFeignClient.findWorkerById(workerId);
        Payment payment = new Payment();
        payment.setName(worker.getName());
        payment.setDailyincome(worker.getDailyIncome());
        payment.setDays(days);

        return payment;
    }
}
