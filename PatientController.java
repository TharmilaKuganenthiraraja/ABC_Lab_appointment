package controller;

import ABC_Lab_appointment.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.*;

import java.util.List;

@RestController
@RequestMapping("/api/patient")
public class PatientController {
    @Autowired
    private final PatientService patientService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private TestReportService testReportService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return patientService.getPatientById(id);
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerPatient(@RequestBody Patient patient) {
        if (patient == null) {
            return ResponseEntity.badRequest().body("Patient data is required");
        }
        patientService.savePatient(patient);
        return ResponseEntity.ok("Patient registered successfully");
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
    }

    // Endpoint to retrieve patient dashboard information
    @GetMapping("/dashboard/{patientId}")
    public PatientDashboardDTO getPatientDashboard(@PathVariable Long patientId) {
        // Retrieve patient information, appointments, and test reports
        Patient patient = patientService.getPatientById(patientId);
        List<Appointment> appointments = appointmentService.getAppointmentsByPatient(patient);
        List<TestReport> testReports = testReportService.getTestReportsByPatient(patient);

        // Create and return a DTO containing necessary information
        return new PatientDashboardDTO(patient, appointments, testReports);
    }
    // Endpoint to add a new appointment
    @PostMapping("/appointments")
    public Appointment addAppointment(@RequestBody AppointmentDTO appointmentDTO) {

        // Save the appointment
        return appointmentService.addAppointment(appointmentDTO);
    }
    // Endpoint to delete an appointment
    @DeleteMapping("/appointments/{appointmentId}")
    public void deleteAppointment(@PathVariable Long appointmentId) {
        appointmentService.deleteAppointment(appointmentId);
    }

    // Endpoint to view a test report
    @GetMapping("/test-reports/{testReportId}")
    public TestReport viewTestReport(@PathVariable Long testReportId) {
        return testReportService.getTestReportById(testReportId);
    }

    // Endpoint to delete a test report
    @DeleteMapping("/test-reports/{testReportId}")
    public void deleteTestReport(@PathVariable Long testReportId) {
        testReportService.deleteTestReport(testReportId);
    }

    // Endpoint to initiate payment and send email
    @PostMapping("/pay")
    public void initiatePayment(@RequestParam Long patientId, @RequestParam double amount) {
        // Perform payment processing logic
        paymentService.processPayment(patientId, amount);

        // Send payment confirmation email
        Patient patient = patientService.getPatientById(patientId);
        emailService.sendPaymentConfirmationEmail(patient.getEmail(), amount);
    }
}
