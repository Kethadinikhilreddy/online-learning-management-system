<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Batch</title>
<link rel="stylesheet" href="css/createBatch.css">
</head>
<body>

<div class="top-bar">
    <a href="userHome.jsp" class="back-btn">Back</a>
</div>


<div class="form-container">
    <h2>Create New Batch</h2>

    <form action="createBatch" method="post">

        <div class="form-group">
            <label>Trainer Name</label>
            <input type="text" name="trainername" value="Nikhil" required>
        </div>

        <div class="form-group">
            <label>Subject Name</label>
            <input type="text" name="subjectname" value="JAVA" required>
        </div>

        <div class="form-group">
            <label>Batch Date</label>
            <input type="date" name="batchdate" value="2000-01-01" required>
        </div>

        <div class="form-group">
            <label>Batch Timing</label>
            <input type="time" name="batchtiming" value="02:30" required>
        </div>

        <div class="form-group">
            <label>Status</label>
            <div class="radio-group">
                <label><input type="radio" name="status" value="OnGoing" checked> OnGoing</label>
                <label><input type="radio" name="status" value="Hold"> Hold</label>
                <label><input type="radio" name="status" value="Closed"> Closed</label>
            </div>
        </div>
        
        <%
    String error = request.getParameter("error");
    if (error != null) {
%>
    <div class="error-msg">
        <%
            if ("InvalidInput".equals(error)) {
                out.print("Please fill all required fields correctly.");
            } else if ("SaveFailed".equals(error)) {
                out.print("Failed to create batch. Please try again.");
            } else {
                out.print("Something went wrong.");
            }
        %>
    </div>
<%
    }
%>
        

        <button type="submit" class="submit-btn">Create Batch</button>

    </form>
</div>


</body>
</html>
