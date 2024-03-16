package ABC_Lab_appointment;

import java.util.List;

public class PatientDashboardDTO {
    private Patient patient;
    private List<Appointment> appointments;
    private List<TestReport> testReports;

    public PatientDashboardDTO(Patient patient, List<Appointment> appointments, List<TestReport> testReports) {
    }
}
