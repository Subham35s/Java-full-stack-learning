package com.practice_dynamic;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.LinkedList;
import java.util.List;
public class ConnectionPoole {
	private static final int poolesize = 10;
	private static List<Connection> pool = new LinkedList<Connection>();
	private static String url = "jdbc:mysql://localhost:3306/test1";
	private static String username = "root";
	private static String password = "root";
	static {
		for(int i = 1; i <= poolesize; i++) {
			try {
				Connection con = DriverManager.getConnection(url, username, password);
				pool.add(con);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void destroy()throws Exception{
		for(Connection con : pool) {
			con.close();
		}
		pool.clear();
	}
	 public static Connection supply() {
		return pool.remove(0);
	}
	public static void accept(Connection con) {
		pool.add(con);
	}
}
