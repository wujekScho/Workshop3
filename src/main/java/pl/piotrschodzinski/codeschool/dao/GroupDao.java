package pl.piotrschodzinski.codeschool.dao;

import pl.piotrschodzinski.codeschool.model.UserGroup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GroupDao {
    private final static String GET_ALL_GROUPS = "SELECT* FROM user_group ORDER BY id";
    private final static String GET_GROUP_BY_ID = "SELECT* FROM user_group WHERE id=?";

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
