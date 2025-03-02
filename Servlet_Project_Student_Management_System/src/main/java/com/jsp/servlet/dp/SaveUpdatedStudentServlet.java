package com.jsp.servlet.dp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/save-update-student")
public class SaveUpdatedStudentServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int Studentid=Integer.parseInt(req.getParameter("studentid"));
		String Studentname=req.getParameter("studentname");
		String Studentemail=req.getParameter("studentemail");
		int Studentage=Integer.parseInt(req.getParameter("studentage"));
		String Studentcourse=req.getParameter("studentcourse");
		String Studentcity=req.getParameter("studentcity");
		
		//JDBC logic
		Connection conn=null;
		
		try {
			Driver driver=new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_student_management_system",
					"root", "root");
			
			PreparedStatement pst=conn.prepareStatement("UPDATE student SET studentName=?,studentEmail=?,studentAge=?,studentCourse=?,studentCity=? WHERE studentId=?");
			
			pst.setString(1, Studentname);
			pst.setString(2, Studentemail);
			pst.setInt(3, Studentage);
			pst.setString(4, Studentcourse);
			pst.setString(5, Studentcity);
			pst.setInt(6, Studentid);
			
			pst.executeUpdate();
			
			resp.sendRedirect("display-all-students");

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
