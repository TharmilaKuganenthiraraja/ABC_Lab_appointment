package ABC_Lab_appointment;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String passwordHash; // Store password hashes instead of plain text passwords
    private String name;


    // Constructors, getters, and setters

    public Admin () {
    }
    public Admin(String username, String passwordHash, String name ) {
        this.username = username;
        this.passwordHash = passwordHash;
        this.name = name;

    }
    // Getters and setters
}
