package pl.piotrschodzinski.codeschool.dao;

import pl.piotrschodzinski.codeschool.model.UserGroup;

import java.sql.*;
import java.util.ArrayList;

public class GroupDao {
    private final static String INSERT_GROUP = "INSERT INTO user_group (name) VALUES (?)";
    private final static String UPDATE_GROUP = "UPDATE user_group SET name=? WHERE id=?";
    private final static String GET_ALL_GROUPS = "SELECT* FROM user_group ORDER BY id";
    private final static String GET_GROUP_BY_ID = "SELECT* FROM user_group WHERE id=?";
    private final static String DELETE_GROUP = "DELETE FROM user_group WHERE id=?";

    public static UserGroup createGroup(Connection connection, UserGroup group) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(INSERT_GROUP, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, group.getName());
        statement.executeUpdate();
        ResultSet resultSet = statement.getGeneratedKeys();
        if (resultSet.next()) {
            group.setId(resultSet.getInt(1));
            return group;
        }
        return null;
    }

    public static void updateGroup(Connection connection, UserGroup group, int groupId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(UPDATE_GROUP);
        statement.setString(1, group.getName());
        statement.setInt(2, groupId);
        statement.executeUpdate();
    }

    public static void deleteGroup(Connection connection, int groupId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(DELETE_GROUP);
        statement.setInt(1, groupId);
        statement.executeUpdate();
    }

    public static ArrayList<UserGroup> getAllGroups(Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(GET_ALL_GROUPS);
        ResultSet resultSet = statement.executeQuery();
        ArrayList<UserGroup> groups = new ArrayList<>();
        while (resultSet.next()) {
            groups.add(loadSingleGroup(resultSet));
        }
        return groups;
    }

    private static UserGroup loadSingleGroup(ResultSet resultSet) throws SQLException {
        UserGroup group = new UserGroup();
        group.setId(resultSet.getInt("id"));
        group.setName(resultSet.getString("name"));
        return group;
    }

    public static UserGroup getGroupById(Connection connection, int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(GET_GROUP_BY_ID);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return loadSingleGroup(resultSet);
        }
        return null;
    }
}
