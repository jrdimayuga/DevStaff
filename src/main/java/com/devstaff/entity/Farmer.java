package com.devstaff.entity;

import lombok.Data;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@Table(name = "FARMER")
public class Farmer {

    @Id
    @GeneratedValue(generator = "generator_farmer_seq", strategy = SEQUENCE)
    @SequenceGenerator(
            name = "generator_farmer_seq",
            sequenceName = "FARMER_SEQ",
            allocationSize = 1
    )
    @Column(name = "ID", precision = 22, nullable = false)
    private int id;

    @Column(name = "FARMER_CODE", length = 50)
    private String farmerCode;

    @Column(name = "LAST_NAME", length = 100)
    private String lastName;

    @Column(name = "FIRST_NAME", length = 100)
    private String firstName;
}
