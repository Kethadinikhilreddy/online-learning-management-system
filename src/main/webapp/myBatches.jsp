<%@page import="org.jsp.dao.StudentDao"%>
<%@ page import="org.jsp.dto.BatchDetails" %>
<%@ page import="java.util.List" %>
<%@ page import="org.jsp.dto.StudentDetails" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Batches</title>
<link rel="stylesheet" href="css/batches.css">
</head>

<body>

<%
    StudentDetails student = (StudentDetails) session.getAttribute("student");
    if (student == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    
%>

<div class="header">
    <h2>My Batches</h2>
    <a href="studentHome.jsp" class="back-btn">Back</a>
</div>

<%
	StudentDao studentDao=new StudentDao();
	StudentDetails details= studentDao.findStudentWithBatches(student.getId());
	List<BatchDetails> batches = (List<BatchDetails>)details.getBatches();
    if (batches == null || batches.isEmpty()) {
%>
        <h3 class="empty">No Batches To Display</h3>
<%
        return;
    }
%>

<div class="batch-container">
<%
    for (BatchDetails b : batches) {
%>
    <div class="batch-card">
        <p><strong>Batch ID:</strong> <%= b.getBid() %></p>
        <p><strong>Subject:</strong> <%= b.getSubjectName() %></p>
        <a href="viewBatch?message=myBatches&id=<%= b.getBid() %>" class="view-btn">View More</a>
    </div>
<%
    }
%>
</div>

</body>
</html>
