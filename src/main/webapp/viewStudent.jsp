<%@page import="org.jsp.dao.StudentDao"%>
<%@page import="org.jsp.dto.StudentDetails"%>
<%@page import="org.jsp.dto.BatchDetails"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Student</title>
<link rel="stylesheet" href="css/profile.css">
<style type="text/css">
.header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 20px;
}

.back-btn {
    text-decoration: none;
    padding: 6px 12px;
    background-color: #007bff;
    color: white;
    border-radius: 4px;
    margin-left: 50px;
}

.back-btn:hover {
    background-color: #0056b3;
}

</style>
</head>
<body>

<%
StudentDetails student = (StudentDetails) request.getAttribute("student");
if(student == null){
    out.println("Student not found");
    return;
}
List<BatchDetails> batches = student.getBatches();
%>


<div class="header">
    <h2>Student Profile</h2>
    <a href="displayAllStudents.jsp" class="back-btn">Back</a>
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

    <div class="profile-row">
        <span class="label">Batches ID</span>
        <span class="value">
            <%
                if (batches != null && !batches.isEmpty()) {
                    for (int i = 0; i < batches.size(); i++) {
                        out.print(batches.get(i).getBid());
                        if (i < batches.size() - 1) out.print(", ");
                    }
                } else {
                    out.print("No Batches");
                }
            %>
        </span>
    </div>

</div>

</body>
</html>
