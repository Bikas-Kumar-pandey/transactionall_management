package com.transactional.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Passenger")
public class PassengerInfo {
    @Id
    @GeneratedValue()
    private Long pid;
    private String name;
    private String email;
    private String source;
    private String destination;
    private double fare;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-mm-yyyy") //i want to pass string as input for date instead of Date
    private Date travelDate;

}
