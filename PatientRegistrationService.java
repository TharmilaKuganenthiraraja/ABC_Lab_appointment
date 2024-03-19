package service;

import ABC_Lab_appointment.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PatientRepository;
@Service
public class PatientRegistrationService {
    @Autowired
    private PatientRepository patientRepository;

    public Patient registerPatient(Patient patient) {
        // Additional validation and logic can be added here
        return patientRepository.save(patient);
    }
}
