<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ page import="java.sql.*,Third.*" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Profile</title>
		<link rel="stylesheet" type="text/css" href="resources/css/style.css">
	</head>
	<body style="background-color:dogerwhite;">
	<style>
	   .profile{
	      background-color:powderBlue;
	   }
	   .logout{
	     padding-top:0.1px;
	     padding-right:30px;
	     padding-bottom:50px;
	     padding-left:50px;
	     float:right;
	   }
	</style>
		<div class="box1">
		<h1 style="text-align:center; color:#8B008B;">Book Details</h1>
			<div class="subb">
				<% 
			        String id=null;
					Cookie[] cookies=request.getCookies();
					for(Cookie cookie:cookies){
						if(cookie.getName().equals("id")){
							id=cookie.getValue();
						}
					}
					if(id!=null){
					Statement st=DB.getStatement();
					ResultSet rs=st.executeQuery("select * from Book where email='"+id+"'");
					out.print("<table border='10' background-color='powderblue' width='100%'");
	            	out.print("<tr style='background-color:powderblue;'><th>BookId</th><th>BookName</th><th>Category</th><th>Author</th></tr>");
	            	while(rs.next()) {
	            		out.print("<tr style='background-color:white;'><td>"+((rs.getString("BookId"))+"</td><td>"+rs.getString("BookName")+"</td><td>"+(rs.getString("Category"))+"</td><td>"+rs.getString("author")+"</td></tr>"));
	            	}
	            	out.print("</table>");
					
					}else{
						response.sendRedirect("login.jsp");
					}
				%>
				<div class-"Logout">
				<a href="logout">LOGOUT</a>
				</div>
			</div>
		</div>
	</body>
</html>