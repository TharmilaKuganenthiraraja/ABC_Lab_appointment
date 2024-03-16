package ABC_Lab_appointment;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class LabTechnician {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String expertise;

    @OneToMany(mappedBy = "labTechnician")
    private List<Patient> patients;

    // Constructors, getters, and setters

    public LabTechnician() {
    }

    public LabTechnician(String name, String expertise) {
        this.name = name;
        this.expertise = expertise;
    }
    // Getters and setters
}
