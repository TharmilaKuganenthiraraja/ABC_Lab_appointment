package controller;

import ABC_Lab_appointment.*;
import ch.qos.logback.core.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import service.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admins")
public class AdminController {
    private final AdminService adminService;
    private final DoctorService doctorService; // Declare DoctorService
    private final LabTechnicianService labTechnicianService; // Declare LabTechnicianService
    private final PatientService patientService;
    private final AppointmentService appointmentService;
    private final PaymentService paymentService;

    @Autowired
    public AdminController(AdminService adminService, DoctorService doctorService, LabTechnicianService labTechnicianService,
                           PatientService patientService, AppointmentService appointmentService, PaymentService paymentService) {

        this.adminService = adminService;
        this.doctorService = doctorService; // Inject DoctorService
        this.labTechnicianService = labTechnicianService; //Inject LabTechnicianService
        this.patientService =  patientService;
        this.appointmentService = appointmentService;
        this.paymentService = paymentService;
    }
    @PostMapping("/register")
    public Admin registerAdmin(@RequestBody Admin admin) {
        return adminService.registerAdmin(admin);
    }

    // Doctor-related endpoints
/*
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/dashboard")
    public String adminDashboard(Model model) {
        List<Doctor> doctors = doctorService.getAllDoctors();
        model.addAttribute("doctors", doctors);
        return "admin";
    }
    */

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/doctors/{id}")
    public Doctor getDoctorById(@PathVariable Long id) {
        return doctorService.getDoctorById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/doctors")
    public Doctor saveDoctor(@RequestBody Doctor doctor) {
        return doctorService.saveDoctor(doctor);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/doctors/{id}")
    public void deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
    }

    // Lab Technician-related endpoints
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/lab-technicians")
    public List<LabTechnician> getAllLabTechnicians() {
        return labTechnicianService.getAllLabTechnicians();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/lab-technicians/{id}")
    public LabTechnician getLabTechnicianById(@PathVariable Long id) {
        return labTechnicianService.getLabTechnicianById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/lab-technicians")
    public LabTechnician saveLabTechnician(@RequestBody LabTechnician labTechnician) {
        return labTechnicianService.saveLabTechnician(labTechnician);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/lab-technicians/{id}")
    public void deleteLabTechnician(@PathVariable Long id) {
        labTechnicianService.deleteLabTechnician(id);
    }

    // Patient-related endpoints
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/patients")
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/patients/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return patientService.getPatientById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/patients/{id}")
    public void deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
    }

    // Appointment-related endpoints

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/appointments")
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/appointments/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable Long id) {
        Optional<Appointment> optionalAppointment = appointmentService.getAppointmentById(id);

        return optionalAppointment
                .map(appointment -> new ResponseEntity<>(appointment, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/appointments/{id}")
    public void deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/appointments/cancel/{id}")
    public void cancelAppointment(@PathVariable Long id) {
        appointmentService.cancelAppointment(id);
    }

    // Payment-related endpoints

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/payments")
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/payments/{id}")
    public Optional<Payment> getPaymentById(@PathVariable Long id) {
        return paymentService.getPaymentById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/payments/{id}")
    public void deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
    }
}


