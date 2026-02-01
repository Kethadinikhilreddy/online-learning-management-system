<%@page import="org.jsp.dto.UserDetails"%>
<%@page import="org.jsp.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update User</title>
<link rel="stylesheet" href="css/update.css">
</head>

<body>

<%
    String message = request.getParameter("message");
    if (message != null) {
%>
        <h3><%= message %></h3>
<%
    }
    String idParam = request.getParameter("id");
    if (idParam == null) {
        out.println("Invalid Request");
        return;
    }

    int id = Integer.parseInt(idParam);
    UserDao userDao = new UserDao();
    UserDetails user = userDao.findById(id);

    if (user == null) {
        out.println("User not found");
        return;
    }
%>

<form action="update" method="post">

    <label>User ID</label><br>
    <input type="number" name="id" value="<%= user.getId() %>" readonly><br><br>

    <label>Name</label><br>
    <input type="text" name="name" value="<%= user.getName() %>"><br><br>

    <label>Email</label><br>
    <input type="email" name="email" value="<%= user.getEmail() %>"><br><br>

    <label>Password</label><br>
    <input type="password" name="password" value="<%= user.getPassword() %>"><br><br>

    <label>Mobile Number</label><br>
    <input type="tel" name="mobilenumber" value="<%= user.getMobileNumber() %>"><br><br>

    
    <input type="text" name="message" value="User" hidden>

    <button type="submit">Update User</button>

</form>

</body>
</html>
