package org.jsp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsp.dao.BatchDao;
import org.jsp.dao.StudentDao;
import org.jsp.dto.BatchDetails;
import org.jsp.dto.StudentDetails;

@WebServlet("/addStudent")
public class AddStudent extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String bidStr = request.getParameter("bid");
        String sidStr = request.getParameter("sid");

        if (bidStr == null || sidStr == null || bidStr.isEmpty() || sidStr.isEmpty()) {
        	request.setAttribute("msg", "Batch ID and Student ID are required");
        	request.getRequestDispatcher("addStudent.jsp").forward(request, response);
            return;
        }

        int bid;
        int sid;

        try {
            bid = Integer.parseInt(bidStr);
            sid = Integer.parseInt(sidStr);
        } catch (NumberFormatException e) {
        	request.setAttribute("msg", "Invalid ID format");
        	request.getRequestDispatcher("addStudent.jsp").forward(request, response);
            return;
        }

        BatchDao batchDao = new BatchDao();
        StudentDao studentDao = new StudentDao();

        BatchDetails batchDetails = batchDao.findById(bid);
        StudentDetails studentDetails = studentDao.findById(sid);

        if (batchDetails == null || studentDetails == null) {
            request.setAttribute("msg", "Batch or Student not found");
        	request.getRequestDispatcher("addStudent.jsp").forward(request, response);
            return;
        }

        boolean added = batchDao.addStudentToBatch(batchDetails, studentDetails);

        if (added) {
        	request.setAttribute("msg", "Student added successfully");
        	request.getRequestDispatcher("result.jsp").forward(request, response);

        } else {
        	request.setAttribute("msg", "Failed to add student to batch");
        	request.getRequestDispatcher("result.jsp").forward(request, response);
        }
    }
}
