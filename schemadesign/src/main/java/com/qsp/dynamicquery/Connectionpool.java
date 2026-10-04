package com.qsp.dynamicquery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.LinkedList;
import java.util.List;

public class Connectionpool {
	private static final int poolsize = 10;
	private static List<Connection> pool = new LinkedList<Connection>();
	private static String url = "jdbc:mysql://localhost:3306/test";
	private static String username = "root";
	private static String password = "root";
	static {
		for (int i = 1; i <= poolsize; i++) {
			try {
				Connection temp = DriverManager.getConnection(url, username, password);
				pool.add(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public static void destroy() throws Exception {
		System.out.println("connection destroy starts");
		for (Connection con : pool) {
			System.out.println("Connction destroyed");
			con.close();
		}
		pool.clear();
		System.out.println("Pool destroyed");
	}

	public static Connection supply() {
		System.out.println("Supply connection");
		return pool.remove(0);
	}

	public static void accept(Connection con) {
		System.out.println("Accept connection");
		pool.add(con);
	}
}
