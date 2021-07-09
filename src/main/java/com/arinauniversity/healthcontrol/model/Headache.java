package com.arinauniversity.healthcontrol.model;


public class Headache {

    private int id;
    private String date;
    private int power;
    //in hours
    private int duration;

    public Headache() {
    }

    public Headache(int id, String date, int power, int duration) {
        this.id = id;
        this.date = date;
        this.power = power;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Headache{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", power=" + power +
                ", duration=" + duration +
                '}';
    }

}
