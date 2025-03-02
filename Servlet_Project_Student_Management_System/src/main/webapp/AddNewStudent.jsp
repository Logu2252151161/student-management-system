<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Enter Student Details</h2>
<form action="add-student" method="post">
<input type="number" placeholder="Enter Student Id" name="studentid">
<input type="text" placeholder="Enter Student Name" name="studentname">
<input type="text" placeholder="Enter Student Email" name="studentemail">
<input type="number" placeholder="Enter Student Age" name="studentage">
<input type="text" placeholder="Enter Student Course" name="studentcourse">
<input type="text" placeholder="Enter Student City" name="studentcity">
<input type="submit" value="ADD">
</form>
</body>
</html>