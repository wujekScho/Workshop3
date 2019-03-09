package pl.piotrschodzinski.codeschool.dao;

import pl.piotrschodzinski.codeschool.model.User;

import java.sql.*;
import java.util.ArrayList;

public class UserDao {
    private final static String INSERT_USER = "INSERT INTO users (username,email,password,user_group_id) VALUES (?,?,?,?)";
    private final static String UPDATE_USER = "UPDATE users SET username=?,email=?,password=?,user_group_id=? WHERE id=?";
    private final static String DELATE_USER = "DELETE FROM users WHERE id=?";
    private final static String GET_USER_BY_ID = "SELECT* FROM users WHERE id=?;";
    private final static String GET_USERS_BY_GROUP_ID = "SELECT* FROM users WHERE user_group_id=?;";
    private final static String GET_ALL_USERS = "SELECT* FROM users ORDER BY id ASC;";

    public static User createUser(Connection connection, User user) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(INSERT_USER, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, user.getUsername());
        statement.setString(2, user.getEmail());
        statement.setString(3, user.getPassword());
        statement.setInt(4, user.getUserGroupId());
        statement.executeUpdate();
        ResultSet resultSet = statement.getGeneratedKeys();
        if (resultSet.next()) {
            user.setId(resultSet.getInt(1));
            return user;
        }
        return null;
    }

    public static User getUserById(Connection connection, int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(GET_USER_BY_ID);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return loadSingleUser(resultSet);
        }
        return null;
    }

    public static ArrayList<User> getGroupUsers(Connection connection, int groupId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(GET_USERS_BY_GROUP_ID);
        statement.setInt(1, groupId);
        ResultSet resultSet = statement.executeQuery();
        ArrayList<User> groupUsers = new ArrayList<>();
        while (resultSet.next()) {
            groupUsers.add(loadSingleUser(resultSet));
        }
        return groupUsers;
    }

    private static User loadSingleUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setUsername(resultSet.getString("username"));
        user.setEmail(resultSet.getString("email"));
        user.setUserGroupId(resultSet.getInt("user_group_id"));
        user.setPassword(resultSet.getString("password"));
        return user;
    }
}
