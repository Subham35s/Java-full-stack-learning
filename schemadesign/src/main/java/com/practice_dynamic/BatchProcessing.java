package com.practice_dynamic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.Scanner;

public class BatchProcessing {
	public static void main(String[] args)throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1", "root", "root");
		String sql = "insert into student value(?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		Scanner sc = new Scanner(System.in);
		for(int i = 1; i <= 3; i++) {
			System.out.println("Enter the Id");
			int id = sc.nextInt();
			 ps.setInt(1, id);
			 System.out.println("Enter the name");
			 String name = sc.next();
			 ps.setString(2, name);
			 System.out.println("Enter the age");
			 int age = sc.nextInt();
			 ps.setInt(3, age);
			 ps.addBatch();
		}
		int[] output = ps.executeBatch();
		System.out.println(Arrays.toString(output));
	}
}
