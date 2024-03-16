package ABC_Lab_appointment;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String telephone;
    private String email;
    private LocalDate dob;
    private String city;
    private String bloodGroup;
    private String password;



    @ManyToOne
    private Doctor doctor;

    @ManyToOne
    private LabTechnician labTechnician;

    // Constructors, getters, and setters

    public Patient() {
    }

    // Example constructor without id (let the database generate it)
    public Patient(String firstName, String lastName, String telephone,String email, LocalDate dob, String city, String bloodGroup, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
        this.email = email;
        this.dob = dob;
        this.city = city;
        this.bloodGroup = bloodGroup;
        this.password = password;


    }
    public Long getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    // Getters and setters
}
