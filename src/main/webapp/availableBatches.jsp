<%@page import="java.util.List"%>
<%@page import="org.jsp.dao.BatchDao"%>
<%@page import="org.jsp.dto.BatchDetails"%>
<%@page import="org.jsp.dto.StudentDetails"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Available Batches</title>
<link rel="stylesheet" href="css/batches.css">
</head>
<body>

<%
    StudentDetails student = (StudentDetails) session.getAttribute("student");
    if (student == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    BatchDao batchDao = new BatchDao();
    List<BatchDetails> availableBatches =
        batchDao.getAvailableBatchesForStudent(student.getId());
%>

<div class="header">
    <h2>Available Batches</h2>
    <a href="studentHome.jsp" class="back-btn">Back</a>
</div>

<%
    if (availableBatches == null || availableBatches.isEmpty()) {
%>
    <h3 class="empty">No Available Batches</h3>
<%
    } else {
%>
<div class="batch-container">
<%
        for (BatchDetails batch : availableBatches) {
%>
    <div class="batch-card">
        <p><strong>Batch ID:</strong> <%= batch.getBid() %></p>
        <p><strong>Subject:</strong> <%= batch.getSubjectName() %></p>
        <a href="viewBatch?message=availableBatches&id=<%= batch.getBid() %>" class="view-btn">View More</a>
    </div>
<%
        }
%>
</div>
<%
    }
%>

</body>
</html>
