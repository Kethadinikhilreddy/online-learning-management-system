package org.jsp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsp.dao.BatchDao;
import org.jsp.dao.StudentDao;
import org.jsp.dao.UserDao;

@WebServlet("/delete")
public class DeleteAccount extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message=request.getParameter("message");
		String redirect=request.getParameter("redirect");
		int id=Integer.parseInt(request.getParameter("id"));
		
		if("User".equals(message)) {
			UserDao userDao=new UserDao();
			boolean deleteUser = userDao.deleteUser(id);
			if(deleteUser) {
				response.sendRedirect("login.jsp");
			}
			else {
				response.getWriter().println("<script>alert('Unable to Delete User. Try again later.'); window.location='userProfile.jsp';</script>");
			}
		}
		else if("Student".equals(message)) {
			StudentDao studentDao=new StudentDao();
			boolean deleteStudent = studentDao.deleteStudent(id);
			if(deleteStudent) {
				if("user".equals(redirect)) {
					response.sendRedirect("displayAllStudents.jsp");
				}else {
					response.sendRedirect("login.jsp");
				}
			}
			else {
				response.getWriter().println("<script>alert('Unable to Delete Student. Try again later.'); window.location='studentProfile.jsp';</script>");
			}
		}
		else if("Batch".equals(message)) {
			BatchDao batchDao=new BatchDao();
			boolean deleteBatch = batchDao.deleteBatch(id);
			if(deleteBatch) {
				response.sendRedirect("displayAllBatches.jsp");
			}
			else {
				response.getWriter().println("<script>alert('Unable to Delete Batch. Try again later.'); window.location='viewAllBatches.jsp';</script>");
			}
		}
	}

}
