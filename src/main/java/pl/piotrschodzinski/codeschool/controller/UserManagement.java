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
import java.util.ArrayList;

@WebServlet("/UserManagement")
public class UserManagement extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Connection connection = DbUtil.getConn();
            ArrayList<User> users = UserDao.getAllUsers(connection);
            request.setAttribute("users", users);
            getServletContext().getRequestDispatcher("/user_management.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
