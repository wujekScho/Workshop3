package pl.piotrschodzinski.codeschool.controller;

import pl.piotrschodzinski.codeschool.dao.GroupDao;
import pl.piotrschodzinski.codeschool.dao.UserDao;
import pl.piotrschodzinski.codeschool.model.User;
import pl.piotrschodzinski.codeschool.model.UserGroup;
import pl.piotrschodzinski.codeschool.util.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/GetGroupUsers")
public class GetGroupUsers extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Connection connection = DbUtil.getConn();
            int groupId = Integer.parseInt(request.getParameter("id"));
            ArrayList<User> groupUsers = UserDao.getGroupUsers(connection, groupId);
            UserGroup group = GroupDao.getGroupById(connection, groupId);
            request.setAttribute("users", groupUsers);
            request.setAttribute("group", group);
            getServletContext().getRequestDispatcher("/group_users.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
