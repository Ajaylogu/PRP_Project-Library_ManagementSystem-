<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Login</title>
		<link rel="stylesheet" type="text/css" href="resources/css/style.css">
	</head>
	<body style="background-color:grey;">
		<div class="box">
		<h1 style="text-align:center; color:#8B008B;">Login</h1>
			<div class="sub">
				<form method="POST" action="Controller">
					<p style="color:red;">
						<% 
							if(request.getAttribute("msg")!=null){
								out.println(request.getAttribute("msg"));
							}
						%>
					</p>
					<label class="lbl">Email</label><br><input type="email" name="email" class="label"><br>
					<label class="lbl">Password</label><br><input type="password" name="password" class="label"><br>
					<button class="btn">LOGIN</button>
					<a href="index.jsp">CREATE NEW ACCOUNT</a>
				</form>
			</div>
		</div>
	</body>
</html>