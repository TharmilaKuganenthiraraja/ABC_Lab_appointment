package ABC_Lab_appointment;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String specialization;
    // Add more fields as needed

    @OneToMany(mappedBy = "doctor")
    private List<Patient> patients;

    // Constructors, getters, and setters
    public Doctor() {
    }


    public Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }
    // Getters and setters
}
