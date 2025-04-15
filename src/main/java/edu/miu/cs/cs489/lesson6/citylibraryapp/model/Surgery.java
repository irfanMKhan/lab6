package edu.miu.cs.cs489.lesson6.citylibraryapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Surgery {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToOne
    private Address address;

    public Surgery() {
    }

    public Surgery(Long id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
}
