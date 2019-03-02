package pl.piotrschodzinski.codeschool.controller;

import pl.piotrschodzinski.codeschool.dao.UserDao;
import pl.piotrschodzinski.codeschool.model.User;
import pl.piotrschodzinski.codeschool.util.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/createUser")
public class CreateUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User("Piotr", "mail@wp.pl", 1, "hasło");
        try {
            Connection connection = DbUtil.getConn();
            UserDao.createUser(connection, user);
            User user1 = UserDao.getUserById(connection, 17);
            response.getWriter().append(String.format("Name: %s, email: %s, group id: %d.",
                    user1.getUsername(), user1.getEmail(), user1.getUserGroupId()));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
