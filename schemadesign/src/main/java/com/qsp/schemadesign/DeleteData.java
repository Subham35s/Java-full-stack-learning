package com.qsp.schemadesign;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteData {
	public static void main(String[] args)throws Exception  {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "root");
		try {
			Statement st = con.createStatement();
			String sql = "delete from student where id = 3";
			int row = st.executeUpdate(sql);
			System.out.println(row + "Row delete");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Aladin news");
		}finally {
			con.close();
		}
		
	}
}
