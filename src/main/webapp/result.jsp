<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result Page</title>

<style>
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-family: Arial, Helvetica, sans-serif;
    }

    body {
        height: 100vh;
        background-color: #f2f4f7;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .container {
        width: 360px;
        background-color: #ffffff;
        padding: 30px;
        border-radius: 8px;
        box-shadow: 0 8px 20px rgba(0, 0, 0, 0.15);
        text-align: center;
    }

    h2 {
        margin-bottom: 20px;
        color: #333;
    }

    .message {
        padding: 12px;
        margin-bottom: 20px;
        border-radius: 4px;
        font-weight: bold;
        background-color: #e6f0ff;
        color: #004085;
    }

    .btn {
        display: block;
        width: 100%;
        padding: 10px;
        background-color: #4a90e2;
        color: white;
        text-decoration: none;
        border-radius: 4px;
        font-size: 15px;
        font-weight: bold;
    }

    .btn:hover {
        background-color: #357abd;
    }
</style>

</head>
<body>

<div class="container">
    <h2>Result</h2>

    
    <div class="message">
        ${msg}
    </div>

    <a href="userHome.jsp" class="btn">Back To Home</a>
</div>

</body>
</html>
