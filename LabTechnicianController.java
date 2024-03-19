package controller;

import ABC_Lab_appointment.LabTechnician;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.LabTechnicianService;

import java.util.List;

@RestController
@RequestMapping("/api/lab-technicians")
public class LabTechnicianController {
    private final LabTechnicianService labTechnicianService;

    @Autowired
    public LabTechnicianController(LabTechnicianService labTechnicianService) {
        this.labTechnicianService = labTechnicianService;
    }

    @GetMapping
    public List<LabTechnician> getAllLabTechnicians() {
        return labTechnicianService.getAllLabTechnicians();
    }

    @GetMapping("/{id}")
    public LabTechnician getLabTechnicianById(@PathVariable Long id) {
        return labTechnicianService.getLabTechnicianById(id);
    }

    @PostMapping
    public LabTechnician saveLabTechnician(@RequestBody LabTechnician labTechnician) {
        return labTechnicianService.saveLabTechnician(labTechnician);
    }

    @DeleteMapping("/{id}")
    public void deleteLabTechnician(@PathVariable Long id) {
        labTechnicianService.deleteLabTechnician(id);
    }
}
