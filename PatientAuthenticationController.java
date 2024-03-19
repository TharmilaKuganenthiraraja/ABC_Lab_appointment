package controller;

import ABC_Lab_appointment.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.PatientAuthenticationService;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class PatientAuthenticationController {
    @Autowired
    private PatientAuthenticationService patientAuthenticationService;

    @PostMapping("/login")
    public ResponseEntity<String> authenticatePatient(@RequestParam String email, @RequestParam String password) {
        Optional<Patient> authenticatedPatient = patientAuthenticationService.authenticatePatient(email, password);

        if (authenticatedPatient.isPresent()) {
            // Return the patient ID or a token for future requests
            return ResponseEntity.ok("Patient authenticated successfully. Patient ID: " + authenticatedPatient.get().getId());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
}
