package com.practice.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteData {
	public static void main(String[] args)throws Exception {
		Connection con = DriverManager.getConnection("Jdbc:mysql://localhost:3306/test1", "root", "root");
		String sql = "delete from student where id = 1";
		PreparedStatement ps = con.prepareStatement(sql);
		int row = ps.executeUpdate(sql);
		con.close();
		ps.close();
		System.out.println("Delete from datbase");
	}
}
