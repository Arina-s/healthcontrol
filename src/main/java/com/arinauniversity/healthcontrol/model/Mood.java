package com.arinauniversity.healthcontrol.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mood {

    private int id;
    private String date;

    @Min(value = 1, message = "Minimum value: 1")
    @Max(value = 5, message = "Maximum value: 5")
    private int estimation;

}
