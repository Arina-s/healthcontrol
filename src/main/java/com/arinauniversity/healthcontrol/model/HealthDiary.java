package com.arinauniversity.healthcontrol.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HealthDiary {

    @Value("1")
    private int id;
    private Headache headache;

    @Autowired
    public HealthDiary(Headache headache) {
        this.headache = headache;
    }

    @Override
    public String toString() {
        return "HealthDiary{" +
                "id=" + id +
                ", headache=" + headache +
                '}';
    }

}
