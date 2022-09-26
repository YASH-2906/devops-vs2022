package com.day12.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseDaoImpl {
	Connection con;
	private String driver = "org.apache.derby.jdbc.EmbeddedDriver";
	private String jdbcUrl= "jdbc:derby:C:\\day12db;";
	public DaoDatabaseImpl() 
	{
		
	}
	//method signature is fix	
	public boolean saveData(DistanceModel data) 
	{	
		private String driver = "org.apache.derby.jdbc.EmbeddedDriver";
		private String jdbcUrl= "jdbc:derby:C:/Users/YASH CHAUDHARI/day12;";
		try 
		{	
			Class.forName(driver);
			con = DriverManager.getConnection(jdbcUrl);
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		try(PreparedStatement pstmt = con.prepareStatement("INSERT INTO day12data (name,city,kms,summary) VALUES(?,?,?,?)")) 
		{
			
			pstmt.setString(1, data.getName());
			pstmt.setString(2, data.getCity());
			pstmt.setInt(3, data.getKms());
			pstmt.setString(4,data.getSummary() );
			
			int numberofRowsUpdated = pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();return false;
		}
	}
}
