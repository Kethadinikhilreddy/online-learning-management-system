<%@page import="org.jsp.dto.StudentDetails"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
<%@ page import="org.jsp.dto.StudentDetails" %>

<%
StudentDetails student = (StudentDetails) session.getAttribute("student");

if (student == null) {
    response.sendRedirect("login.jsp");
    return;
}

String studentName = student.getName();
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Student Home - OnlineLearning</title>
    <link rel="stylesheet" href="css/studentHome.css">
</head>
<body>

    <!-- Header -->
    <header class="header">
        <h1>OnlineLearning Management System</h1>
        <p>Welcome, <span><%= studentName %></span></p>
    </header>

    <!-- Navigation -->
    <nav class="nav-bar">
        <a href="studentProfile.jsp" class="nav-btn profile">My Profile</a>
        <a href="myBatches.jsp" class="nav-btn batch">My Batches</a>
        <a href="availableBatches.jsp" class="nav-btn enroll">Available Batches</a>
        <a href="logout?message=Student" class="nav-btn logout">Logout</a>
    </nav>

    <!-- Main Content -->
    <main class="main-content">
        <h2>Student Dashboard</h2>
        <p>
            From here, you can view your profile details, check batches you are enrolled in,
            explore available batches, and securely logout.
        </p>

        <section class="info-cards">
            <div class="card">
                <h3>Profile</h3>
                <p>View and manage your personal details.</p>
            </div>

            <div class="card">
                <h3>My Batches</h3>
                <p>Check your enrolled batches and schedules.</p>
            </div>

            <div class="card">
                <h3>Learning</h3>
                <p>Track your learning progress and updates.</p>
            </div>
        </section>
    </main>

    <!-- Footer -->
    <footer class="footer">
        &copy; 2026 OnlineLearning Management System | Student Portal
    </footer>

</body>
</html>
