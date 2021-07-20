package com.arinauniversity.healthcontrol.dao;

import com.arinauniversity.healthcontrol.model.Mood;

import java.util.List;

public interface MoodDao {

    List<Mood> getAllMoods();

    Mood getNewMood();

    void saveMood(Mood mood);

    Mood getMoodById(int id);

    void deleteMoodById(int id);

    void editMood(Mood mood);

    void addEstimation(int value);

}
