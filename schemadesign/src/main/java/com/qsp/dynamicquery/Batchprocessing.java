package com.qsp.dynamicquery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.Scanner;

public class Batchprocessing {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		String sql = "insert into student value(?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		for (int i = 1; i <= 1; i++) {
			System.out.println("Enter Id");
			int id = sc.nextInt();
			System.out.println("Enter name");
			String name = sc.next();
			System.out.println("Enter age");
			int age = sc.nextInt();
			ps.setInt(1, id);
			ps.setInt(3, age);
			ps.setString(2, name);
			ps.addBatch();
		}
		int[] output = ps.executeBatch();
		System.out.println(Arrays.toString(output));
		con.close();
	}
}
