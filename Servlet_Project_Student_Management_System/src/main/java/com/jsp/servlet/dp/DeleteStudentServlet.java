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

@WebServlet("/delete-by-id")
public class DeleteStudentServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int studentid=Integer.parseInt(req.getParameter("studentId"));
		//jdbc logic
		
		Connection conn=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_student_management_system",
					"root", "root");
			
			PreparedStatement pst=conn.prepareStatement("DELETE FROM student WHERE studentId=?");
			pst.setInt(1, studentid);
			
			pst.executeUpdate();
			
			resp.sendRedirect("display-all-students");

		} catch (ClassNotFoundException | SQLException e) {
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
