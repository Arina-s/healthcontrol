package com.arinauniversity.healthcontrol.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HealthDiary {

    @Value("1")
    private int id;
    private Headache headache;

}
