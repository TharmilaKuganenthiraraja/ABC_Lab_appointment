package service;

import ABC_Lab_appointment.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PaymentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;
    @Autowired
    public PaymentService(PaymentRepository paymentRepository){
        this.paymentRepository = paymentRepository;
    }
    public void processPayment(Long patientId, double amount) {
        // Perform payment processing logic
        Payment payment = new Payment();
        // Set payment details
        paymentRepository.save(payment);
    }
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Optional<Payment> getPaymentById(Long id) {
        return paymentRepository.findById(id);
    }

    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }
}
