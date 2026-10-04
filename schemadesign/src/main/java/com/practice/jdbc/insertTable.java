package com.practice.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class insertTable {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1", "root", "root");
		String sql = "insert into student value(1, 'Avinash', 25)";
		String sql1 = "insert into student value(2, 'dev', 26)";
		PreparedStatement st = con.prepareStatement(sql);
		PreparedStatement st1 = con.prepareStatement(sql1);
		int row = st.executeUpdate(sql);
		int row1 = st1.executeUpdate(sql);
		con.close();
		st.close();
		System.out.println("insert the table row");
	}

}
