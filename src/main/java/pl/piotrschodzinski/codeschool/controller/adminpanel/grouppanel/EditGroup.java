package pl.piotrschodzinski.codeschool.controller.adminpanel.grouppanel;

import pl.piotrschodzinski.codeschool.dao.GroupDao;
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

@WebServlet("/EditGroup")
public class EditGroup extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int groupId = Integer.parseInt(request.getParameter("id"));
        String groupName = request.getParameter("name");
        UserGroup group = new UserGroup(groupName);
        try {
            Connection connection = DbUtil.getConn();
            GroupDao.updateGroup(connection, group, groupId);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        response.sendRedirect("GroupManagement");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int groupId = Integer.parseInt(request.getParameter("id"));
        try {
            Connection connection = DbUtil.getConn();
            request.setAttribute("group", GroupDao.getGroupById(connection, groupId));
            request.setAttribute("id", groupId);
            getServletContext().getRequestDispatcher("/edit_group.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
