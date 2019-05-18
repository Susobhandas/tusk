package com.boom;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCTest {

	public static void main(String[] args) {
	
		String jdbcurl="jdbc:oracle:thin:@localhost:1521:orcledb";
		
		
		String user="system";
		String password="sdas";
		
		try {
			System.out.println("Connecting to Sql....");
			Connection con=DriverManager.getConnection(jdbcurl, user, password);
			System.out.println("connection is successful..in oracel..");
		}
		catch(Exception ex) {
			
			ex.printStackTrace();
		}
		finally {
			
		}

	}

}
