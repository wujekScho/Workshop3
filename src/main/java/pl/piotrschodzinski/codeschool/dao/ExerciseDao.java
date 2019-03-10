package pl.piotrschodzinski.codeschool.dao;

import pl.piotrschodzinski.codeschool.model.Exercise;

import java.sql.*;
import java.util.ArrayList;

public class ExerciseDao {
    private final static String INSERT_EXERCISE = "INSERT INTO exercise (title, description) VALUES (?,?)";
    private final static String UPDATE_EXERCISE = "UPDATE exercise SET title=?, description=? WHERE id=?";
    private final static String DELETE_EXERCISE = "DELETE FROM exercise WHERE id=?";
    private final static String GET_EXERCISE_BY_ID = "SELECT* FROM exercise WHERE id=?";
    private final static String GET_ALL_EXERCISES = "SELECT* FROM exercise ORDER BY id ASC";

    public static Exercise createExercise(Connection connection, Exercise exercise) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(INSERT_EXERCISE, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, exercise.getTitle());
        statement.setString(2, exercise.getDescription());
        statement.executeUpdate();
        ResultSet resultSet = statement.getGeneratedKeys();
        if (resultSet.next()) {
            exercise.setId(resultSet.getInt(1));
            return exercise;
        }
        return null;
    }

    public static void updateExercise(Connection connection, Exercise exercise, int exerciseId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(UPDATE_EXERCISE);
        statement.setString(1, exercise.getTitle());
        statement.setString(2, exercise.getDescription());
        statement.setInt(3, exerciseId);
        statement.executeUpdate();
    }

    public static void deleteExercise(Connection connection, int exerciseId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(DELETE_EXERCISE);
        statement.setInt(1, exerciseId);
        statement.executeUpdate();
    }

    public static Exercise getExerciseById(Connection connection, int exerciseId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(GET_EXERCISE_BY_ID);
        statement.setInt(1, exerciseId);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            Exercise exercise = loadSingleExercise(resultSet);
            return exercise;
        }
        return null;
    }

    public static ArrayList<Exercise> getAllExercises(Connection connection) throws SQLException {
        ArrayList<Exercise> exercises = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(GET_ALL_EXERCISES);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            exercises.add(loadSingleExercise(resultSet));
        }
        return exercises;
    }

    private static Exercise loadSingleExercise(ResultSet resultSet) throws SQLException {
        Exercise exercise = new Exercise();
        exercise.setTitle(resultSet.getString("title"));
        exercise.setDescription(resultSet.getString("description"));
        exercise.setId(resultSet.getInt("id"));
        return exercise;
    }
}
