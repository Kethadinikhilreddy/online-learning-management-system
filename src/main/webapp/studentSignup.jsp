<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student SignUp Page</title>
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

<form action="signup" method="post" class="student-form">
	<div class="field">
    <label>Name</label>
    <input type="text" name="name" value="Example" required><br>
    </div>

	<div class="field">
    <label>Email</label>
    <input type="email" name="email" value="example@gmail.com" required><br>
    </div>
    <%
        String error = (String) request.getAttribute("error");
     %>
        <span class="error">
    			<%= (error != null) ? error : "" %>
		</span>
        
	<div class="field">
    <label>Password</label>
    <input type="password" name="password" value="example@123" required><br>
    </div>
    <div class="field">
    <label>Gender</label>
    <input type="text" name="gender" value="Male" required><br>
    </div>
    <div class="field">
    <label>DateOfBirth</label>
    <input type="date" name="dob" value="01-01-2000" required><br>
    </div>
    <div class="field">
    <label>Mobile Number</label>
    <input type="tel" name="mobilenumber" value="9876543210" required><br>
    </div>
    <div class="field">
    <label>Address</label>
    <input type="text" name="address" value="Hyderabad" required><br>
    </div>
    <input type="text" name="message" value="Student" hidden >

    <button>Sign Up</button>

    

    <h4>Already Have Account <a href="login.jsp">Click Here</a></h4>
</form>

</body>
</html>
