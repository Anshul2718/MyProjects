package com.example.understandingmapping.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Laptop {

    @Id
    private Long id;
    private String name;
    private String brand;

//    @ManyToOne
//    private Student student;

}
