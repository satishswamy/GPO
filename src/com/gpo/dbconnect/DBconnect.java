package com.gpo.dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBconnect {

	public void TableAccess(String name , String phone, String email, String enquiry) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/gpo","root","root");
			String query = " insert into contact (name, phone, email, enquiry)"
			        + " values (?, ?, ?, ?)";
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1,name);
			preparedStatement.setString(2,phone);
			preparedStatement.setString(3,email);
			preparedStatement.setString(4,enquiry);
			preparedStatement.executeUpdate();
			System.out.println("New enquiry received");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
