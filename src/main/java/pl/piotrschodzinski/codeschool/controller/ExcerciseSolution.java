package pl.piotrschodzinski.codeschool.controller;

import pl.piotrschodzinski.codeschool.dao.SolutionDao;
import pl.piotrschodzinski.codeschool.util.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/ExcerciseSolution")
public class ExcerciseSolution extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            Connection connection = DbUtil.getConn();
            String description = SolutionDao.getSolutionById(connection, id).getDescription();
            request.setAttribute("description", description);
            getServletContext().getRequestDispatcher("/solution_details.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
