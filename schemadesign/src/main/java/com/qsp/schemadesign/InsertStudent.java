package com.qsp.schemadesign;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertStudent {
	public static void main(String[] args) throws Exception {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		Statement st = con.createStatement();
		String sql = "insert into student value(3, 'Harish', 25)";
		int row = st.executeUpdate(sql);
		st.close();
		con.close();
		System.out.println(row +" Row inserted");
	}
}
