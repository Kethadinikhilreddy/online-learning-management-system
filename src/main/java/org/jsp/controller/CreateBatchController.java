package org.jsp.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsp.dao.BatchDao;
import org.jsp.dto.BatchDetails;

@WebServlet("/createBatch")
public class CreateBatchController extends HttpServlet {

    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("createBatch.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String trainerName = request.getParameter("trainername");
        String subjectName = request.getParameter("subjectname");
        String status = request.getParameter("status");
        String dateStr = request.getParameter("batchdate");
        String timeStr = request.getParameter("batchtiming");

        if (trainerName == null || subjectName == null || status == null ||
            dateStr == null || timeStr == null ||
            trainerName.isEmpty() || subjectName.isEmpty()) {

            response.sendRedirect("createBatch.jsp?error=InvalidInput");
            return;
        }

        BatchDetails batch = new BatchDetails();
        batch.setTrainerName(trainerName);
        batch.setSubjectName(subjectName);
        batch.setStatus(status);
        batch.setBatchDate(LocalDate.parse(dateStr));
        batch.setBatchTiming(LocalTime.parse(timeStr));
        batch.setStudents(new ArrayList<>());

        BatchDao batchDao = new BatchDao();
        BatchDetails savedBatch = batchDao.saveBatch(batch);

        if (savedBatch != null) {
            response.sendRedirect("displayAllBatches.jsp");
        } else {
            response.sendRedirect("createBatch.jsp?error=SaveFailed");
        }
    }
}
