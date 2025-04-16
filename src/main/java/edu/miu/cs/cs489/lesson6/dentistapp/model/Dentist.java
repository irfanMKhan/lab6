package edu.miu.cs.cs489.lesson6.dentistapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Dentist {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String specialization;

    public Dentist() {
    }

    public Dentist(Long id, String firstName, String lastName, String specialization) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialization = specialization;
    }
}
