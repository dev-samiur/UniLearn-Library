package models;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class Book {
	
	private Connection conn;
	private ResultSet rs;
	private String sql;
	private Statement stmt;
	
	public Book()
	{
		conn= DBconfig.connect();
	}

	public ResultSet findAll()
	{
		sql= "SELECT * FROM books";
		
		try {
			
			stmt  = conn.createStatement();
			rs= stmt.executeQuery(sql);
	
			
	    }catch (SQLException e) {
	            System.out.println(e.getMessage());
	    }
		
		return rs;
	}
	
}
