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
<%
ResultSet rs=(ResultSet) request.getAttribute("resultSet"); 
%>
<h2 align="center" style="color: red;">Student Details</h2>

<table border="" style="border: double;" >
<tr>
<th>Student Id</th>
<th>Student Name</th>
<th>Student Email</th>
<th>Student Age</th>
<th>Student Course</th>
<th>Student city</th>
<th>Update</th>
<th>DELETE</th>

</tr>

<% 
while(rs.next()) {
	%>
	<tr>
	<td><%=rs.getInt(1) %></td>
	<td><%=rs.getString(2) %></td>
	<td><%=rs.getString(3) %></td>
	<td><%=rs.getInt(4) %></td>
	<td><%=rs.getString(5) %></td>
	<td><%=rs.getString(6) %></td>
	<td><a href="find-by-id?studentId=<%=rs.getInt(1) %>"><button >UPDATE</button></a></td>
	<td><a href="delete-by-id?studentId=<%=rs.getInt(1) %>"><button>DELETE</button></a></td>
	</tr>
	<%
	}
	%>
</table>

</body>
</html>