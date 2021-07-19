package com.arinauniversity.healthcontrol.service;

import com.arinauniversity.healthcontrol.dao.MoodDao;
import com.arinauniversity.healthcontrol.model.Mood;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class MoodServiceImpl implements MoodService {

    private final MoodDao moodDao;

    @Override
    public List<Mood> getAllMoods() {
        List<Mood> moods = moodDao.getAllMoods();
        moods.sort(Comparator.comparingInt(Mood::getId));
        return moods;
    }

    @Override
    public Mood getNewMood() {
        return moodDao.getNewMood();
    }

    @Override
    public void saveMood(Mood mood) {
        moodDao.saveMood(mood);
    }

    @Override
    public Mood getMoodById(int id) {
        return moodDao.getMoodById(id);
    }

    @Override
    public void deleteMoodById(int id) {
        moodDao.deleteMoodById(id);
    }

    @Override
    public void editMood(Mood mood) {
        moodDao.editMood(mood);
    }

    @Override
    public void addRandomMood(boolean future) {
        Mood mood = moodDao.getNewMood();
        int day = new Random().nextInt(31);
        int month = new Random().nextInt(12);
        int year = new Random().nextInt(11) + 2010;
        if (future) {
            year += 10;
        }
        int estimation = 1 + new Random().nextInt(5);
        mood.setDate(String.format("%s.%s.%s", day, month, year));
        mood.setEstimation(estimation);
        moodDao.saveMood(mood);
    }

    @Override
    public void addEstimation(int value) {
        moodDao.addEstimation(value);
    }

}
