<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User SignUp Page</title>
<link rel="stylesheet" href="css/signup.css">
<style type="text/css">

span{
    color: red;
    font-size: 15px;
    display: block;
    margin-top: -8px;
    margin-bottom: 10px;
}
</style>
</head>
<body>

<form action="signup" method="post">
    <label>Name</label>
    <input type="text" name="name" value="Example" required><br>

    <label>Email</label>
    <input type="email" name="email" value="example@learning.com" required><br>
    
    <%
        String error = (String) request.getAttribute("error");
    %>
    <span class="errorr">
    		<%= (error != null) ? error : "" %>
	</span>
    
        

    <label>Password</label>
    <input type="password" name="password" value="example@123" required><br>

    <label>Mobile Number</label>
    <input type="tel" name="mobilenumber" value="9876543210" required><br>
    
    <input type="text" name="message" value="User" hidden >

    <button>Sign Up</button>

    

    <h4>Already Have Account <a href="login.jsp">Click Here</a></h4>
</form>

</body>
</html>
