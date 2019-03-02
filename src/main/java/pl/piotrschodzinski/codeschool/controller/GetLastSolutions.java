package pl.piotrschodzinski.codeschool.controller;

import pl.piotrschodzinski.codeschool.dao.SolutionDao;
import pl.piotrschodzinski.codeschool.model.Solution;
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

@WebServlet("/home")
public class GetLastSolutions extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int limit = Integer.parseInt(getServletContext().getInitParameter("number-solutions"));
        try {
            Connection connection = DbUtil.getConn();
            ArrayList<Solution> lastSolutions = SolutionDao.getAllSolutions(connection, limit);
            request.setAttribute("solutions", lastSolutions);
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
