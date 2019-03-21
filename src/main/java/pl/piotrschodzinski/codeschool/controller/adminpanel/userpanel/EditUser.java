package pl.piotrschodzinski.codeschool.controller.adminpanel.userpanel;

import pl.piotrschodzinski.codeschool.dao.GroupDao;
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

@WebServlet("/EditUser")
public class EditUser extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("id"));
        String userName = request.getParameter("name");
        String email = request.getParameter("email");
        int groupId = Integer.parseInt(request.getParameter("groupId"));
        String pass = request.getParameter("password");
        User user = new User(userName, email, groupId, pass);
        try {
            Connection connection = DbUtil.getConn();
            UserDao.updateUser(connection, user, userId);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        response.sendRedirect("UserManagement");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("id"));
        try {
            Connection connection = DbUtil.getConn();
            request.setAttribute("groups", GroupDao.getAllGroups(connection));
            request.setAttribute("user", UserDao.getUserById(connection, userId));
            request.setAttribute("id", userId);
            getServletContext().getRequestDispatcher("/edit_user.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
