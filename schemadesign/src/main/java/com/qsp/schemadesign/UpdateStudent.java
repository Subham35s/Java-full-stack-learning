package com.qsp.schemadesign;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateStudent {
	public static void main(String[] args)throws Exception {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		Statement  st = con.createStatement();
		String sql = "update Student set age = 28 where id = 1";
		int row = st.executeUpdate(sql);
		st.close();
		con.close();
		System.out.println(row + "Row update");
	}
}
