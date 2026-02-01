<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<link rel="stylesheet" href="css/login.css">
<style type="text/css">

span{
    color: red;
    font-size: 15px;
    display: block;
    margin-top: -10px;
    margin-bottom: 10px;
}
</style>
</head>
<body>

<form action="login" method="post">

    <label>Email</label>
    <input type="email" name="email" value="example@gmail.com" required>

    <!-- EMAIL ERROR -->
    <%
        String emailError = (String) request.getAttribute("emailError");
        if (emailError != null) {
    %>
        <span><%= emailError %></span>
    <%
        }
    %>

    <label>Password</label>
    <input type="password" name="password" value="example@123" required>

    <!-- PASSWORD ERROR -->
    <%
        String passwordError = (String) request.getAttribute("passwordError");
        if (passwordError != null) {
    %>
        <span><%= passwordError %></span>
    <%
        }
    %>

    <button>Login</button>

    <h4>New User? <a href="selectSignup.jsp">Click Here</a></h4>

</form>

</body>
</html>
