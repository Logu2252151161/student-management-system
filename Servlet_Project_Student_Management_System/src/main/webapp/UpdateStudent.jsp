<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% ResultSet rs= (ResultSet) request.getAttribute("resultSet"); 
rs.next();%>
<h1>UPDATE STUDENT DETAILS</h1>

<form action="save-update-student" method="post">
<input type="number" value="<%=rs.getInt(1) %>" name="studentid" readonly="readonly"> <br>
<input type="text" value="<%=rs.getString(2) %>" name="studentname"><br>
<input type="text" value="<%=rs.getString(3) %>" name="studentemail"><br>
<input type="number" value="<%=rs.getInt(4) %>" name="studentage"><br>
<input type="text" value="<%=rs.getString(5) %>" name="studentcourse"><br>
<input type="text" value="<%=rs.getString(6) %>" name="studentcity"><br>
<input type="submit" value="UPDATE">
</form>

</body>
</html>