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
<title>View Batch</title>
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
String message=request.getParameter("message");
BatchDetails batch = (BatchDetails) request.getAttribute("batch");
if(batch == null){
    out.println("Batch not found");
    return;
}
List<StudentDetails> students = batch.getStudents();
%>


	<div class="header">
		<h2>Batch Details</h2>
		<%
		if ("vieww".equals(message)) {
		%>
		<a href="displayAllBatches.jsp" class="back-btn">Back</a>
		<%
		} else if ("myBatches".equals(message)) {
		%>
		<a href="myBatches.jsp" class="back-btn">Back</a>
		<%
		} else {
		%>
		<a href="availableBatches.jsp" class="back-btn">Back</a>
		<%
		}
		%>
	</div>

	<div class="profile-card">

    <div class="profile-row">
        <span class="label">Batch ID</span>
        <span class="value"><%= batch.getBid() %></span>
    </div>

    <div class="profile-row">
        <span class="label">Trainer Name</span>
        <span class="value"><%= batch.getTrainerName() %></span>
    </div>

    <div class="profile-row">
        <span class="label">Subject Name</span>
        <span class="value"><%= batch.getSubjectName() %></span>
    </div>

    <div class="profile-row">
        <span class="label">Date</span>
        <span class="value"><%= batch.getBatchDate() %></span>
    </div>

    <div class="profile-row">
        <span class="label">Timings</span>
        <span class="value"><%= batch.getBatchTiming() %></span>
    </div>


    <div class="profile-row">
        <span class="label">Status</span>
        <span class="value"><%= batch.getStatus() %></span>
    </div>

<%
if ("vieww".equals(request.getParameter("message"))) {
%>

<div class="profile-row">
    <span class="label">Students ID</span>
    <span class="value">
        <%
            if (students != null && !students.isEmpty()) {
                for (int i = 0; i < students.size(); i++) {
                    out.print(students.get(i).getId());
                    if (i < students.size() - 1) {
                        out.print(", ");
                    }
                }
            } else {
                out.print("No Students");
            }
        %>
    </span>
</div>

<%
}
%>

    

</div>

</body>
</html>
