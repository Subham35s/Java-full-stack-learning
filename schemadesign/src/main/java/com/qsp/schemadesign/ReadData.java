package com.qsp.schemadesign;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReadData {
	public static void main(String[] args)throws Exception {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		Statement st = con.createStatement();
		String sql = "select * from student";
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()) {
			int id = rs.getInt(1);
			String name = rs.getString("name");
			int age = rs.getInt(3);
			System.out.println("id = "+id + " name = "+name+ " age = "+ age);
		}
		System.out.println("Databse  data printed");
		con.close();
	}
}
