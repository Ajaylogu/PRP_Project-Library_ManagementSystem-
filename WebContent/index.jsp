<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Register</title>
		<link rel="stylesheet" type="text/css" href="resources/css/style.css">
	</head>
	<body style="background-color:grey;"> 
	<style>
	.div{
	   background-color:"powderblue";
	}
	</style>
		<div class="box">
		<h1 style="text-align:center; color:#8B008B;">Register</h1>
			<div class="sub">
			<center>
				<form method="POST" action="Login">
					<p style="color:red;">
						<% 
							if(request.getAttribute("msg")!=null){
								out.println(request.getAttribute("msg"));
							}
						%>
					</p>
					<label class="lbl">Name</label><br><input type="text" name="name" class="label"><br>
					<label class="lbl">Gender</label><br>
					<select name="gender" class="gen">
						<option value="male">Male</option>
						<option value="female">Female</option>
					</select><br>
					<label class="lbl">DOB</label><br><input type="date" name="dob" class="label"><br>
					<label class="lbl">Email</label><br><input type="email" name="email" class="label"><br>
					<label class="lbl">Password</label><br><input type="password" name="password" class="label"><br>
					<label class="lbl">Confirm Password</label><br><input type="password" name="confirm" class="label"><br>
					<button class="btn">REGISTER</button>
					<a href="login.jsp">LOGIN</a>
				</form>
			</center>
			</div>
		</div>
	</body>
</html>