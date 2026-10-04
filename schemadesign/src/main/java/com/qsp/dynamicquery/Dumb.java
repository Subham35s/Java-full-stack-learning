package com.qsp.dynamicquery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.Scanner;

public class Dumb {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection connection = Connectionpool.supply();
		String sql = "insert into student values(?, ?, ?)";
		PreparedStatement ptStatement = connection.prepareStatement(sql);

		Scanner sc = new Scanner(System.in);
		for(int i=0; i<1; i++) {
			System.out.println("Enter the id");
			int id = sc.nextInt();

			System.out.println("Enter the student name:");
			String name = sc.next();

			System.out.println("Enter the age: ");
			int age = sc.nextInt();

			ptStatement.setInt(1, id);
			ptStatement.setString(2, name);
			ptStatement.setInt(3, age);
			ptStatement.addBatch();
		}

		int[] result = ptStatement.executeBatch();
		
		System.out.println(result);
		System.out.println(Arrays.toString(result));
		System.out.println("Insertion operation sesa");

		Connectionpool.accept(connection);
		Connectionpool.destroy();
	}
}
