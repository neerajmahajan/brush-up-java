<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Login</title>
</head>
<body>
<form action="login" method="post">
	<br>User Id : <input type="text" name="userId" />
	<br>Password  : <input type="password" name="password" />
	<br><input type="submit" value="SignIn" />
	<br> New User ? <input type="button" value="signUp" onclick="window.location='SignUp.jsp'"/> 

</form> 
</body>
</html>