package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private EmailService emailService;

    public void sendPaymentConfirmationEmail(String recipientEmail, double amount) {
        // Implementation to send an email

        System.out.println("Sending payment confirmation email to: " + recipientEmail);
        System.out.println("Amount: " + amount);
        // Add logic to send an actual email
    }
}
