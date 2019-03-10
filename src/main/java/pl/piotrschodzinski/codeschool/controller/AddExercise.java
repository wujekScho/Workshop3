package pl.piotrschodzinski.codeschool.controller;

import pl.piotrschodzinski.codeschool.dao.ExerciseDao;
import pl.piotrschodzinski.codeschool.model.Exercise;
import pl.piotrschodzinski.codeschool.util.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/AddExercise")
public class AddExercise extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("name");
        String description = request.getParameter("description");
        Exercise exercise = new Exercise(title, description);
        try {
            Connection connection = DbUtil.getConn();
            ExerciseDao.createExercise(connection, exercise);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        response.sendRedirect("ExerciseManagement");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/add_exercise.jsp").forward(request, response);
    }
}
