package com.arinauniversity.healthcontrol.service;

import com.arinauniversity.healthcontrol.model.Mood;

import java.util.List;

public interface MoodService {

    List<Mood> getAllMoods();

    void saveMood(Mood mood);

    Mood getMoodById(int id);

    void deleteMoodById(int id);

    void editMood(Mood mood);

    void addRandomMood(boolean future);

    void addEstimation(int value);

    int[] getIdList();
}
