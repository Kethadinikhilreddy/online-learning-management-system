<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Student</title>
<link rel="stylesheet" href="css/addStudent.css">
<style type="text/css">
.back-btn {
        position: fixed;
        top: 20px;
        left: 20px;
        padding: 8px 14px;
        background: #555;
        color: white;
        text-decoration: none;
        border-radius: 4px;
        font-size: 14px;
        z-index: 1000;
    }

    .back-btn:hover {
        background: #333;
    }

</style>
</head>
<body>
<a href="userHome.jsp" class="back-btn">Back</a>
<div class="container">
    <h2>Add Student to Batch</h2>

    <%
        String msg = (String) request.getAttribute("msg");
        if (msg != null) {
    %>
        <div class="message">
            <%= msg %>
        </div>
    <%
        }
    %>

    <form action="addStudent" method="post">
        <div class="form-group">
            <label for="bid">Batch ID</label>
            <input type="number" id="bid" name="bid"
                   value="2"
                   required>
        </div>

        <div class="form-group">
            <label for="sid">Student ID</label>
            <input type="number" id="sid" name="sid"
                   value="1"
                   required>
        </div>

        <button type="submit">Add Student</button>
    </form>
</div>

</body>
</html>
