package com.arinauniversity.healthcontrol.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DoctorVisit {

    private int id;
    private int day;
    private int month;
    private int year;
    private String doctorsSpecialization;
    private String doctorsName;
    private String time;
    private String description;

}
