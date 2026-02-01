package org.jsp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jsp.dao.StudentDao;
import org.jsp.dto.StudentDetails;

@WebServlet("/myBatches")
public class MyBatchesController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        StudentDetails student = (StudentDetails) session.getAttribute("student");

        if (student == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        StudentDao dao = new StudentDao();

        // Fetch student WITH batches
        
        StudentDetails studentWithBatches =
                dao.findStudentWithBatches(student.getId());

        request.setAttribute("batches", studentWithBatches.getBatches());
        request.getRequestDispatcher("myBatches.jsp").forward(request, response);
    }
}
