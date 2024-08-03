package com.devstaff.entity;

import lombok.Data;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;
@Data
@Entity
@Table(name = "CROPS")
public class Crops {
    @Id
    @GeneratedValue(generator = "generator_crops_seq", strategy = SEQUENCE)
    @SequenceGenerator(
            name = "generator_crops_seq",
            sequenceName = "CROPS_SEQ",
            allocationSize = 1
    )
    @Column(name = "ID", precision = 22, nullable = false)
    private int id;

    @Column(name = "CODE", length = 50)
    private String code;

    @Column(name = "NAME", length = 100)
    private String name;

    @Column(name = "TYPE", length = 100)
    private String type;
}
