package pl.piotrschodzinski.codeschool.dao;

import pl.piotrschodzinski.codeschool.model.User;

import java.sql.*;

public class UserDao {
    private final static String INSERT_USER = "INSERT INTO users (username,email,password,user_group_id) VALUES (?,?,?,?)";
    private final static String UPDATE_USER = "UPDATE users SET username=?,email=?,password=?,user_group_id=? WHERE id=?";
    private final static String DELATE_USER = "DELETE FROM users WHERE id=?";
    private final static String GET_USER_BY_ID = "SELECT* FROM users WHERE id=?;";
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
            String username = resultSet.getString("username");
            int userGroupId = resultSet.getInt("user_group_id");
            String password = resultSet.getString("password");
            String email = resultSet.getString("email");
            User user = new User(username, email, userGroupId, password);
            user.setId(id);
            return user;
        }
        return null;
    }
}
