package com.devstaff.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.SEQUENCE;
import static javax.persistence.TemporalType.DATE;

@Data
@Entity
@Table(name = "PLANTED")
public class Planted {

    @Id
    @GeneratedValue(generator = "generator_planted_seq", strategy = SEQUENCE)
    @SequenceGenerator(
            name = "generator_planted_seq",
            sequenceName = "PLANTED_SEQ",
            allocationSize = 1
    )
    @Column(name = "ID", precision = 22, nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "FARMER_ID", foreignKey = @ForeignKey(name = "HAR_FARMER_FK"))
    private Farmer farmer;

    @ManyToOne
    @JoinColumn(name = "CROPS_ID", foreignKey = @ForeignKey(name = "HAR_CROPS_FK"))
    private Crops crops;

    @ManyToOne
    @JoinColumn(name = "FARM_FIELD_ID", foreignKey = @ForeignKey(name = "HAR_FARM_FIELD_FK"))
    private FarmField farmField;

    @Column(name = "TOTAL_EXPECTED_WEIGHT", columnDefinition = "number(23,2)")
    private double totalExpectedWeight;

    @Column(name = "TOTAL_AREA_PLANTED", columnDefinition = "number(23,2)")
    private double totalAreaPlanted;

    @Column(name = "SEASON", length = 50)
    private String season;

    @Temporal(value = DATE)
    @Column(name = "PLANTED_DATE")
    private Date plantedDate;
}
