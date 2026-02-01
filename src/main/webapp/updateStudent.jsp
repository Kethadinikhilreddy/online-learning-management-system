<%@ page import="org.jsp.dao.StudentDao" %>
<%@ page import="org.jsp.dto.StudentDetails" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Student</title>
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
    StudentDao studentDao = new StudentDao();
    StudentDetails student = studentDao.findById(id);

    if (student == null) {
        out.println("Student not found");
        return;
    }
%>

<form action="update" method="post">

    <label>Student ID</label><br>
    <input type="number" name="id" value="<%= student.getId() %>" readonly><br><br>

    <label>Name</label><br>
    <input type="text" name="name" value="<%= student.getName() %>"><br><br>

    <label>Email</label><br>
    <input type="email" name="email" value="<%= student.getEmail() %>"><br><br>

    <label>Password</label><br>
    <input type="password" name="password" value="<%= student.getPassword() %>"><br><br>

    <label>Gender</label><br>
    <input type="text" name="gender" value="<%= student.getGender() %>"><br><br>

    <label>Date of Birth</label><br>
    <input type="date" name="dob" value="<%= student.getDateOfBirth() %>"><br><br>

    <label>Mobile Number</label><br>
    <input type="tel" name="mobilenumber" value="<%= student.getMobileNumber() %>"><br><br>

    <label>Address</label><br>
    <input type="text" name="address" value="<%= student.getAddress() %>"><br><br>
    
    <input type="text" name="message" value="Student" hidden>

    <button type="submit">Update Student</button>

</form>

</body>
</html>
