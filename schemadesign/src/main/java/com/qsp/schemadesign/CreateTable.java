package com.qsp.schemadesign;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable {
	public static void main(String[] args) throws Exception{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		
		Statement st = con.createStatement();
		String sql = "create table student(id int, name varchar(30), age int)";
		st.execute(sql);
		st.close();
		con.close();
		System.out.println("student table created");
	}
}
