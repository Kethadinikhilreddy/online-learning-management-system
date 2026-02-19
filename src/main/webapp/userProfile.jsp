<%@page import="org.jsp.dto.UserDetails"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Profile</title>
<link rel="stylesheet" href="css/profile.css">
</head>
<body>


<%
    UserDetails user = (UserDetails) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<div class="profile-container">

    <div class="profile-header">
        <h2>User Profile</h2>
        <p>Welcome, <%= user.getName() %></p>
    </div>

    <div class="profile-card">

        <div class="profile-row">
            <span class="label">User ID</span>
            <span class="value"><%= user.getId() %></span>
        </div>

        <div class="profile-row">
            <span class="label">Name</span>
            <span class="value"><%= user.getName() %></span>
        </div>

        <div class="profile-row">
            <span class="label">Email</span>
            <span class="value"><%= user.getEmail() %></span>
        </div>

        <div class="profile-row">
            <span class="label">Mobile</span>
            <span class="value"><%= user.getMobileNumber() %></span>
        </div>

		<div class="profile-actions">
        <a href="userHome.jsp" class="btn">Back</a>
        <a href="updateUser.jsp?id=<%= user.getId() %>" class="btn">Update</a>
        <form action="delete" method="post" onsubmit="return confirm('Are you sure you want to delete this student?');" style="display:inline;">
        <input type="hidden" name="message" value="User">
        <input type="hidden" name="id" value="<%= user.getId() %>">
        <button type="submit" class="btn danger">Delete</button>
    </form>


    	</div>
    </div>

    

</div>

</body>
</html>
