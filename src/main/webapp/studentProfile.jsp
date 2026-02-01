<%@page import="org.jsp.dto.StudentDetails"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Profile</title>
<link rel="stylesheet" href="css/profile.css">
</head>
<body>


<%
    StudentDetails student = (StudentDetails) session.getAttribute("student");
    if (student == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<div class="profile-container">

    <div class="profile-header">
        <h2>Student Profile</h2>
        <p>Welcome, <%= student.getName() %></p>
    </div>

    <div class="profile-card">

        <div class="profile-row">
            <span class="label">Student ID</span>
            <span class="value"><%= student.getId() %></span>
        </div>

        <div class="profile-row">
            <span class="label">Name</span>
            <span class="value"><%= student.getName() %></span>
        </div>

        <div class="profile-row">
            <span class="label">Email</span>
            <span class="value"><%= student.getEmail() %></span>
        </div>

        <div class="profile-row">
            <span class="label">Gender</span>
            <span class="value"><%= student.getGender() %></span>
        </div>

        <div class="profile-row">
            <span class="label">Date of Birth</span>
            <span class="value"><%= student.getDateOfBirth() %></span>
        </div>

        <div class="profile-row">
            <span class="label">Mobile</span>
            <span class="value"><%= student.getMobileNumber() %></span>
        </div>

        <div class="profile-row">
            <span class="label">Address</span>
            <span class="value"><%= student.getAddress() %></span>
        </div>
		
	
		<div class="profile-actions">
        <a href="studentHome.jsp" class="btn">Back</a>
        <a href="updateStudent.jsp?id=<%= student.getId() %>" class="btn">Update</a>
        <a href="<%= request.getContextPath() %>/delete?message=Student&id=<%= student.getId() %>" 
   class="btn danger" 
   onclick="return confirm('Are you sure you want to delete your account?');">
   Delete
</a>


    	</div>
    </div>

    

</div>

</body>
</html>
