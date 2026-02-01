package org.jsp.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsp.dao.StudentDao;
import org.jsp.dao.UserDao;
import org.jsp.dto.StudentDetails;
import org.jsp.dto.UserDetails;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String message=request.getParameter("message");
		
		if(message.equals("User")) {
			
			UserDao dao = new UserDao();
			UserDetails user = new UserDetails();
			
			user.setName(request.getParameter("name"));
			user.setEmail(request.getParameter("email"));
			user.setPassword(request.getParameter("password"));
			user.setMobileNumber(Long.parseLong(request.getParameter("mobilenumber")));

			UserDetails savedUser = dao.saveUser(user);
			if(savedUser != null){
			    response.sendRedirect("login.jsp");
			} else {
			    request.setAttribute("error", "Email Already Exists.");
			    request.getRequestDispatcher("userSignup.jsp").forward(request, response);
			}

		}
		else if(message.equals("Student")) {
			
			StudentDao dao = new StudentDao();
			StudentDetails student = new StudentDetails();

			student.setName(request.getParameter("name"));
			student.setEmail(request.getParameter("email"));
			student.setPassword(request.getParameter("password"));
			student.setMobileNumber(Long.parseLong(request.getParameter("mobilenumber")));
			student.setGender(request.getParameter("gender"));
			student.setAddress(request.getParameter("address"));

			String dobStr = request.getParameter("dob"); 
			if (dobStr != null && !dobStr.isEmpty()) {
			    student.setDateOfBirth(LocalDate.parse(dobStr));
			}

			student.setBatches(new ArrayList<>());

		
			StudentDetails savedStudent = dao.saveStudent(student);

			if (savedStudent != null) {
			    response.sendRedirect("login.jsp");
			} else {
			    request.setAttribute("error", "Email Already Exists.");
			    request.getRequestDispatcher("studentSignup.jsp").forward(request, response);
			}

		}
		
		
		
		
		
		
		
		
		
	}

}
