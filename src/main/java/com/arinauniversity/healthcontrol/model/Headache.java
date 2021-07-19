package com.arinauniversity.healthcontrol.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Headache {

    private int id;
    private String date;
    private int power;
    //in hours
    private int duration;
    private Tablet tablet;

}
