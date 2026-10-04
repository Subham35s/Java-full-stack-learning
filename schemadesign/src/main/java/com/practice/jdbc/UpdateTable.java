package com.practice.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class UpdateTable {
	public static void main(String[] args)throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1", "root", "root");
		String sql = "update student set name = 'Good Morning' where id = 1";
		PreparedStatement st = con.prepareStatement(sql);
		int row = st.executeUpdate();
		con.close();
		st.close();
		System.out.println("Row updated");
	}
}
