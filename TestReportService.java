package service;

import ABC_Lab_appointment.Patient;
import ABC_Lab_appointment.TestReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.TestReportRepository;

import java.util.List;
@Service
public class TestReportService {

    @Autowired
    private TestReportRepository testReportRepository;
    public List<TestReport> getTestReportsByPatient(Patient patient) {
        return testReportRepository.findByPatient(patient);
    }

    public TestReport getTestReportById(Long testReportId) {
        return testReportRepository.findById(testReportId).orElse(null);
    }

    public void deleteTestReport(Long testReportId) {
        testReportRepository.deleteById(testReportId);
    }
}
