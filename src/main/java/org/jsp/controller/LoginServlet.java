package org.jsp.controller;

import java.io.IOException;

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

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

	    String email = request.getParameter("email");
	    String password = request.getParameter("password");

	    HttpSession session = request.getSession();

	    
	    if (email.contains("@learning.com")) {
	    		//USER LOGIN
	        UserDao userDao=new UserDao();
	        UserDetails user = userDao.findByEmail(email);

	        if (user == null) {
	            request.setAttribute("emailError", "User email not found");
	            request.getRequestDispatcher("login.jsp").forward(request, response);
	            return;
	        }

	        if (!user.getPassword().equals(password)) {
	            request.setAttribute("passwordError", "Incorrect password");
	            request.getRequestDispatcher("login.jsp").forward(request, response);
	            return;
	        }

	        // Success
	        
	        session.setAttribute("user", user);
	        response.sendRedirect("userHome.jsp");

	    } else {
	        // STUDENT LOGIN
	    		StudentDao studentDao=new StudentDao();
	        StudentDetails student = studentDao.findByEmail(email);

	        if (student == null) {
	            request.setAttribute("emailError", "Student email not found");
	            request.getRequestDispatcher("login.jsp").forward(request, response);
	            return;
	        }

	        if (!student.getPassword().equals(password)) {
	            request.setAttribute("passwordError", "Incorrect password");
	            request.getRequestDispatcher("login.jsp").forward(request, response);
	            return;
	        }

	        // Success
	        session.setAttribute("student", student);
	        response.sendRedirect("studentHome.jsp");
	    }
	}


}
