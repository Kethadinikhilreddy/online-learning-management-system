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

@WebServlet("/viewBatch")
public class ViewBatchServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
    	String message=request.getParameter("message");
        String idParam = request.getParameter("id");
        if (idParam == null) {
            response.sendRedirect("displayAllBatches.jsp");
            return;
        }
        
        int id = Integer.parseInt(idParam);
        BatchDao dao = new BatchDao();
        BatchDetails batch = dao.findBatchWithStudents(id); 

        request.setAttribute("message",message);
        request.setAttribute("batch", batch);
        request.getRequestDispatcher("viewBatch.jsp").forward(request, response);
    }
    

}
