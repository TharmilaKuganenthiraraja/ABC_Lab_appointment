package repository;

import ABC_Lab_appointment.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findByEmail(String email);

    Optional<Patient> findByEmailAndPassword(String email, String password);
    @Query("SELECT P FROM Patient p WHERE p.email = :email AND p.password = :password")
    Optional<Patient>findCustomByEmailAndPassword(@Param("email") String email, @Param("password")String password);
}
