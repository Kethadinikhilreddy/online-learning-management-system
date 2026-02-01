<%@page import="java.util.List"%>
<%@page import="org.jsp.dao.BatchDao"%>
<%@page import="org.jsp.dto.BatchDetails"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Batches</title>
<link rel="stylesheet" href="css/batches.css">
</head>
<body>

<%

    BatchDao batchDao = new BatchDao();
    List<BatchDetails> allBatches = batchDao.getAllBatchesWithStudents();
%>

<div class="header">
    <h2>All Batches</h2>
    <a href="userHome.jsp" class="back-btn">Back</a>
</div>

<%
    if (allBatches.isEmpty()) {
%>
    <h3 class="empty">No Batches Available</h3>
<%
    } else {
%>

<div class="batch-container">
<%
        for (BatchDetails batch : allBatches) {
%>
    <div class="batch-card">
        <p><strong>Batch ID:</strong> <%= batch.getBid() %></p>
        <p><strong>Subject:</strong> <%= batch.getSubjectName() %></p>
        <a href="viewBatch?message=vieww&id=<%= batch.getBid() %>" class="view-btn">View More</a>
        <a href="delete?message=Batch&id=<%= batch.getBid() %>" class="delete-btn"
           onclick="return confirm('Are you sure you want to delete this Batch?');">
           Delete
        </a>
    </div>
<%
        }
%>
</div>
<%
    }
%>

</body>
</html>
