<%@page import="org.jsp.dto.StudentDetails"%>
<%@page import="java.util.List"%>
<%@page import="org.jsp.dao.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Students</title>
<link rel="stylesheet" href="css/batches.css">
</head>
<body>
<div class="header">
    <h2>All Students</h2>
    <a href="userHome.jsp" class="back-btn">Back</a>
</div>

<%

	StudentDao studentDao=new StudentDao();

	List<StudentDetails> students=studentDao.getAllStudents();

	if (students == null || students.isEmpty()) {
%>
        <h3 class="empty">No Batches To Display</h3>
<%
        return;
    }
	
	
%>

<div class="batch-container">
<%
    for (StudentDetails s : students) {
%>
    <div class="student-card">
    <p><strong>ID:</strong> <%= s.getId() %></p>
    <p><strong>Name:</strong> <%= s.getName() %></p>
    <div class="card-buttons">
        <a href="viewStudent?id=<%= s.getId() %>" class="view-btn">View More</a>
        <a href="delete?message=Student&redirect=user&id=<%= s.getId() %>" class="delete-btn"
           onclick="return confirm('Are you sure you want to delete this student?');">
           Delete
        </a>
    </div>
</div>

<%
    }
%>

</div>
</body>
</html>