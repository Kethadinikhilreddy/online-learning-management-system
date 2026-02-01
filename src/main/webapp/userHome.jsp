<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
<%@ page import="org.jsp.dto.UserDetails" %>
<%
UserDetails user = (UserDetails) session.getAttribute("user");

if (user == null) {
    response.sendRedirect("login.jsp");
    return;
}

String username = user.getName();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Home - OnlineLearning Management</title>
    <link rel="stylesheet" href="css/userHome.css">
    <style type="text/css">
    .action-btn.create{ background-color: #757500; }
    .action-btn.update { background-color: #787878; }
    </style>
</head>
<body>

    
    <header class="header">
        <h1>OnlineLearning Management System</h1>
        <p>Welcome, <%= username %>!</p>
    </header>

    
    <nav class="nav-actions">
    	<a href="createBatch.jsp" class="action-btn create">Create a Batch</a>
        <a href="addStudent.jsp" class="action-btn add">Add Student</a>
        <a href="displayAllBatches.jsp" class="action-btn update">View Batches</a>
        <a href="displayAllStudents.jsp" class="action-btn view">View Students</a>
        <a href="userProfile.jsp" class="action-btn profile">View Profile</a>
        <a href="logout?message=User" class="action-btn logout">Logout</a>
    </nav>

    
    <main class="main-content">
        <h2>Dashboard</h2>
        <p>Use the above buttons to manage students and your profile. You can add a new student, view existing students, or logout when finished.</p>
    </main>

    
    <footer class="footer">
        &copy; 2026 OnlineLearning Management System | All Rights Reserved
    </footer>

</body>
</html>
