package pl.piotrschodzinski.codeschool.dao;

import pl.piotrschodzinski.codeschool.model.Solution;

import java.sql.*;
import java.util.ArrayList;

public class SolutionDao {
    private final static String INSERT_SOLUTION = "INSERT INTO solution (created, updated, description, exercise_id, users_id) VALUES (?,?,?,?,?)";
    private final static String UPDATE_SOLUTION = "UPDATE solution SET updated=? ,description=?,exercise_id=?,users_id=? WHERE id=?";
    private final static String DELATE_SOLUTION = "DELETE FROM solution WHERE id=?";
    private final static String GET_SOLUTION_BY_ID = "SELECT* FROM solution WHERE id=?";
    private final static String GET_ALL_SOLUTIONS = "SELECT* FROM solution";
    private final static String GET_ALL_SOLUTIONS_LIMIT = "SELECT* FROM solution ORDER BY created DESC LIMIT ?";

    public static Solution createSolution(Connection connection, Solution solution) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO solution (created, updated, description, exercise_id, users_id) VALUES (?,?,?,?,?)",
                PreparedStatement.RETURN_GENERATED_KEYS);
        statement.setTimestamp(1, Timestamp.valueOf(solution.getCreated()));
        if (solution.getUpdated() != null) {
            statement.setTimestamp(2, Timestamp.valueOf(solution.getUpdated()));
        } else {
            statement.setTimestamp(2, null);
        }
        statement.setString(3, solution.getDescription());
        statement.setInt(4, solution.getExerciseId());
        statement.setLong(5, solution.getExerciseId());
        statement.executeUpdate();
        ResultSet resultSet = statement.getGeneratedKeys();
        if (resultSet.next()) {
            solution.setId(resultSet.getInt(1));
            return solution;
        }
        return null;
    }

    public static ArrayList<Solution> getAllSolutions(Connection connection) throws SQLException {
        ArrayList<Solution> solutions = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(GET_ALL_SOLUTIONS);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Solution solution = new Solution();
            solution.setId(resultSet.getInt("id"));
            solution.setCreated(resultSet.getTimestamp("created").toLocalDateTime());
            if (resultSet.getTimestamp("updated") != null) {
                solution.setUpdated(resultSet.getTimestamp("updated").toLocalDateTime());
            } else {
                solution.setUpdated(null);
            }
            solution.setDescription(resultSet.getString("description"));
            solution.setExerciseId(resultSet.getInt("exercise_id"));
            solution.setUserId(resultSet.getInt("users_id"));
            solutions.add(solution);
        }
        return solutions;
    }

    public static ArrayList<Solution> getAllSolutions(Connection connection, int limit) throws SQLException {
        ArrayList<Solution> solutions = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(GET_ALL_SOLUTIONS_LIMIT);
        statement.setInt(1, limit);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Solution solution = new Solution();
            solution.setId(resultSet.getInt("id"));
            solution.setCreated(resultSet.getTimestamp("created").toLocalDateTime());
            if (resultSet.getTimestamp("updated") != null) {
                solution.setUpdated(resultSet.getTimestamp("updated").toLocalDateTime());
            } else {
                solution.setUpdated(null);
            }
            solution.setDescription(resultSet.getString("description"));
            solution.setExerciseId(resultSet.getInt("exercise_id"));
            solution.setUserId(resultSet.getInt("users_id"));
            solutions.add(solution);
        }
        return solutions;
    }
}
