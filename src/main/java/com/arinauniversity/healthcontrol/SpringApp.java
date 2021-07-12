package com.arinauniversity.healthcontrol;

import com.arinauniversity.healthcontrol.model.Headache;
import com.arinauniversity.healthcontrol.model.HealthDiary;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApp {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        Headache headache = context.getBean("headache", Headache.class);
        System.out.println(headache);

        HealthDiary healthDiary = context.getBean("healthDiary", HealthDiary.class);
        System.out.println(healthDiary);
    }

}
