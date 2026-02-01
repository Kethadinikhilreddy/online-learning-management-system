package org.jsp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsp.dao.StudentDao;
import org.jsp.dto.StudentDetails;

@WebServlet("/viewStudent")
public class ViewStudentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        String idParam = request.getParameter("id");
        if (idParam == null) {
            response.sendRedirect("displayAllStudents.jsp");
            return;
        }
        
        int id = Integer.parseInt(idParam);
        StudentDao dao = new StudentDao();
        StudentDetails student = dao.findStudentWithBatches(id); // load batches

        request.setAttribute("student", student);
        request.getRequestDispatcher("viewStudent.jsp").forward(request, response);
    }
    

}
