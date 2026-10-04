package com.practice.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class ReadTable {
	public static void main(String[] args)throws Exception{
//		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1", "root", "root");
		Statement st = con.createStatement();
		String sql = "select * from student";
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
			int id = rs.getInt(1);
			String name = rs.getString("name");
			int age = rs.getInt(3);
			System.out.println(id +" "+name+" "+age);
		}
		System.out.println("Database data printed");
		con.close();
	}
}
