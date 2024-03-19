package controller;

import ABC_Lab_appointment.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.PatientRegistrationService;

@RestController
@RequestMapping("/api/patients")
public class PatientRegistrationController {
    @Autowired
    private PatientRegistrationService patientRegistrationService;

    @PostMapping("/register")
    public ResponseEntity<Patient> registerPatient(@RequestBody Patient patient) {
        Patient registeredPatient = patientRegistrationService.registerPatient(patient);
        return ResponseEntity.ok(registeredPatient);
    }
}
