package service;

import ABC_Lab_appointment.LabTechnician;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.LabTechnicianRepository;

import java.util.List;

@Service
public class LabTechnicianService {
    private final LabTechnicianRepository labTechnicianRepository;

    @Autowired
    public LabTechnicianService(LabTechnicianRepository labTechnicianRepository) {
        this.labTechnicianRepository = labTechnicianRepository;
    }

    public List<LabTechnician> getAllLabTechnicians() {
        return labTechnicianRepository.findAll();
    }

    public LabTechnician getLabTechnicianById(Long id) {
        return labTechnicianRepository.findById(id).orElse(null);
    }

    public LabTechnician saveLabTechnician(LabTechnician labTechnician) {
        return labTechnicianRepository.save(labTechnician);
    }

    public void deleteLabTechnician(Long id) {
        labTechnicianRepository.deleteById(id);
    }
}
