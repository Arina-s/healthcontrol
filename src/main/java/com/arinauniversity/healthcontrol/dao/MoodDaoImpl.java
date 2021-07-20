package com.arinauniversity.healthcontrol.dao;

import com.arinauniversity.healthcontrol.model.Mood;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MoodDaoImpl implements MoodDao {

    private final Connection connection;

    @SneakyThrows
    @Override
    public List<Mood> getAllMoods() {
        List<Mood> moodList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM moods")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Mood mood = new Mood();
                mood.setId(resultSet.getInt("id"));
                mood.setDate(resultSet.getString("date"));
                mood.setEstimation(resultSet.getInt("estimation"));
                moodList.add(mood);
            }
        }
        return moodList;
    }

    @SneakyThrows
    @Override
    public void saveMood(Mood mood) {
        String query = "INSERT INTO moods (date, estimation) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, mood.getDate());
            preparedStatement.setInt(2, mood.getEstimation());
            preparedStatement.executeUpdate();
        }
    }

    @SneakyThrows
    @Override
    public Mood getMoodById(int id) {
        Mood mood = new Mood();
        String query = "SELECT * FROM moods WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            mood.setId(id);
            mood.setDate(resultSet.getString("date"));
            mood.setEstimation(resultSet.getInt("estimation"));
        }
        return mood;
    }

    @SneakyThrows
    @Override
    public void deleteMoodById(int id) {
        String query = "DELETE FROM moods WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }

    @SneakyThrows
    @Override
    public void editMood(Mood mood) {
        String query = "UPDATE moods SET date = ?, estimation = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, mood.getDate());
            preparedStatement.setInt(2, mood.getEstimation());
            preparedStatement.setInt(3, mood.getId());
            preparedStatement.executeUpdate();
        }
    }

    @SneakyThrows
    @Override
    public void addEstimation(int value) {
        String query = "UPDATE moods SET estimation = estimation + ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, value);
            preparedStatement.executeUpdate();
        }
    }

}
