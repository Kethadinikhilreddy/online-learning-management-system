package org.jsp.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jsp.dao.StudentDao;
import org.jsp.dao.UserDao;
import org.jsp.dto.StudentDetails;
import org.jsp.dto.UserDetails;

@WebServlet("/update")
public class Update extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String message = request.getParameter("message");

        if ("Student".equals(message)) {

            StudentDao studentDao = new StudentDao();

            int id = Integer.parseInt(request.getParameter("id"));
            StudentDetails studentDetails = studentDao.findById(id);

            if (studentDetails == null) {
                response.sendRedirect("updateStudent.jsp?id=" + id + "&error=Student Not Found");
                return;
            }

            studentDetails.setName(request.getParameter("name"));
            studentDetails.setEmail(request.getParameter("email"));
            studentDetails.setPassword(request.getParameter("password"));
            studentDetails.setGender(request.getParameter("gender"));
            studentDetails.setAddress(request.getParameter("address"));
            studentDetails.setMobileNumber(
                    Long.parseLong(request.getParameter("mobilenumber"))
            );

            String dob = request.getParameter("dob");
            if (dob != null && !dob.isEmpty()) {
                studentDetails.setDateOfBirth(LocalDate.parse(dob));
            }

            StudentDetails updatedStudent = studentDao.updateStudent(studentDetails);

            if (updatedStudent != null) {
                session.setAttribute("student", updatedStudent);
                response.sendRedirect("studentProfile.jsp");
            } else {
                response.sendRedirect("updateStudent.jsp?id=" + id + "&error=Update Failed");
            }

        } 
        else if ("User".equals(message)) {

            UserDao userDao = new UserDao();

            int id = Integer.parseInt(request.getParameter("id"));
            UserDetails userDetails = userDao.findById(id);

            if (userDetails == null) {
                response.sendRedirect("updateUser.jsp?id=" + id + "&error=User Not Found");
                return;
            }

            userDetails.setName(request.getParameter("name"));
            userDetails.setEmail(request.getParameter("email"));
            userDetails.setPassword(request.getParameter("password"));
            userDetails.setMobileNumber(
                    Long.parseLong(request.getParameter("mobilenumber"))
            );

            UserDetails updatedUser = userDao.updateUser(userDetails);

            if (updatedUser != null) {
                session.setAttribute("user", updatedUser);
                response.sendRedirect("userProfile.jsp");
            } else {
                response.sendRedirect("updateUser.jsp?id=" + id + "&error=Update Failed");
            }

        } 
        else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid Update Request");
        }
    }
}
