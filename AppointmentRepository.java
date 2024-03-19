package repository;

import ABC_Lab_appointment.Appointment;
import ABC_Lab_appointment.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
    List<Appointment> findByPatient(Patient patient);
}
