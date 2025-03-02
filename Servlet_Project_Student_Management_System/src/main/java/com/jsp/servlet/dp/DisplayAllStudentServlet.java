package com.jsp.servlet.dp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/display-all-students")
public class DisplayAllStudentServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//JDBC logic
	Connection conn=null;
	
	
	try {
		Driver driver=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_student_management_system",
				"root", "root");
		
		PreparedStatement pst=conn.prepareStatement("SELECT * FROM student");
		
		ResultSet rst=pst.executeQuery();
		req.setAttribute("resultSet",rst);
		
	RequestDispatcher rd=req.getRequestDispatcher("DisplayAllStudent.jsp");
	rd.forward(req, resp);
		
		resp.sendRedirect("index.jsp");

	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}


}
