package repository;

import ABC_Lab_appointment.Patient;
import ABC_Lab_appointment.TestReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestReportRepository extends JpaRepository<TestReport,Long> {
    List<TestReport> findByPatient(Patient patient);
}
