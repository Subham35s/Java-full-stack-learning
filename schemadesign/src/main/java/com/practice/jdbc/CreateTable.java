package com.practice.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class CreateTable {
	public static void main(String[] args)throws Exception{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1", "root", "root");
			Statement st = con.createStatement();
			String sql = "create table student(id int,name varchar(30), age int)";
			st.execute(sql);
			con.close();
			st.close();
			System.out.println("sucessfully create");	
	}
}
