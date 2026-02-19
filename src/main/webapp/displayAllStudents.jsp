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
<style type="text/css">

.card-buttons {
    display: flex;
    gap: 10px; /* space between buttons */
}

.card-buttons a,
.card-buttons button {
    text-decoration: none;
    padding: 6px 12px;
    border-radius: 4px;
    border: none;
    cursor: pointer;
    font-size: 14px;
}

.view-btn {
    background-color: #4CAF50;
    color: white;
}

.delete-btn {
    background-color: #f44336;
    color: white;
}

</style>
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
        <h3 class="empty">No Students To Display</h3>
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

    <form action="delete" method="post" onsubmit="return confirm('Are you sure you want to delete this student?');" style="display:inline;">
        <input type="hidden" name="message" value="Student">
        <input type="hidden" name="redirect" value="user">
        <input type="hidden" name="id" value="<%= s.getId() %>">
        <button type="submit" class="delete-btn">Delete</button>
    </form>
</div>

</div>

<%
    }
%>

</div>
</body>
</html>