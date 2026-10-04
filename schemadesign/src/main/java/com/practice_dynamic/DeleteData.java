package com.practice_dynamic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.qsp.dynamicquery.Connectionpool;

public class DeleteData {
	public static void main(String[] args)throws Exception{
		Connection con = ConnectionPoole.supply();
		String sql = "delete from student where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		System.out.println("Enter id");
		int id = new Scanner(System.in).nextInt();
		ps.setInt(1, id);
		int row = ps.executeUpdate();
		Connectionpool.accept(con);
		System.out.println(row+"delete the row");
		
	}
}
