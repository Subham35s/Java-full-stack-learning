package com.qsp.schemadesign;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateSchema {
	public static void main(String[] args)throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");
		
		Statement st = con.createStatement();
		st.execute("create database test");
		st.close();
		con.close();
		System.out.println("DATABASE CREATED");
	}
}
