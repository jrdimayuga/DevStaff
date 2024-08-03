package com.devstaff.entity;

import lombok.Data;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@Table(name = "FARM_FIELD")
public class FarmField {

    @Id
    @GeneratedValue(generator = "generator_farmField_seq", strategy = SEQUENCE)
    @SequenceGenerator(
            name = "generator_farmField_seq",
            sequenceName = "FARM_FIELD_SEQ",
            allocationSize = 1
    )
    @Column(name = "ID", precision = 22, nullable = false)
    private int id;

    @Column(name = "CODE", length = 50)
    private String code;

    @Column(name = "NAME", length = 100)
    private String farmName;

    @Column(name = "LOCATION", length = 100)
    private String location;

    @Column(name = "TOTAL_AREA", columnDefinition = "number(23,2)")
    private double totalArea;
}
