package edu.miu.cs.cs489.lesson6.citylibraryapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Appointment {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Dentist dentist;

    @ManyToOne
    private Surgery surgery;

    private String dateTime;

    public Appointment() {
    }

    public Appointment(Long id, Patient patient, Dentist dentist, Surgery surgery, String dateTime) {
        this.id = id;
        this.patient = patient;
        this.dentist = dentist;
        this.surgery = surgery;
        this.dateTime = dateTime;
    }
}
