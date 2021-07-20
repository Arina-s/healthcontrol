package com.arinauniversity.healthcontrol.dao;

import com.arinauniversity.healthcontrol.model.Mood;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class MoodDaoImpl implements MoodDao {

    private static int count = 3;

    private List<Mood> moods = new ArrayList<>(Arrays.asList(
            new Mood(1, "2.05.20", 5),
            new Mood(2, "26.03.20", 2),
            new Mood(3, "17.07.20", 4)
    ));

    @Override
    public List<Mood> getAllMoods() {
        return moods;
    }

    @Override
    public Mood getNewMood() {
        Mood mood = new Mood();
        mood.setId(++count);
        return mood;
    }

    @Override
    public void saveMood(Mood mood) {
        moods.add(mood);
    }

    @Override
    public Mood getMoodById(int id) {
        Mood mood = moods.stream()
                .filter(obj -> obj.getId() == id)
                .findFirst()
                .orElse(null);
        return mood;
    }

    @Override
    public void deleteMoodById(int id) {
        moods.removeIf(mood -> mood.getId() == id);
    }

    @Override
    public void editMood(Mood mood) {
        moods.removeIf(obj -> obj.getId() == mood.getId());
        moods.add(mood);
    }

    @Override
    public void addEstimation(int value) {
        moods.forEach(mood -> {
            if (mood.getEstimation() + value <= 5) {
                int estimation = mood.getEstimation();
                mood.setEstimation(estimation + value);
            }
        });
    }

}
