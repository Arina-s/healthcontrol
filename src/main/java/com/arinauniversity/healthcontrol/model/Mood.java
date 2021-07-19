package com.arinauniversity.healthcontrol.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Mood {

    private int id;
    private String date;
    private int estimation;

}
