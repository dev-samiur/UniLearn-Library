package models;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class Borrow {
	
	private Connection conn;
	private ResultSet rs;
	private String sql;
	private Statement stmt;
	private PreparedStatement preparedStmt;
	
	public Borrow()
	{
		conn= DBconfig.connect();
	}

	public ResultSet findAll()
	{
		sql= "SELECT * FROM borrows";
		
		try {
			
			stmt  = conn.createStatement();
			rs= stmt.executeQuery(sql);
	
			
	    }catch (SQLException e) {
	         System.out.println(e.getMessage());
	    }
		
		return rs;
	}
	
	public boolean save(int bookId, String bookName, int borrowedBy, String borrowDate, String borrowStatus, String fine)      
	{
		sql= "INSERT INTO borrows (book_id, book_name, borrowed_by, borrow_date, borrow_status, fine) VALUES (?,?,?,?,?,?)";
		
		try {
			
			preparedStmt= conn.prepareStatement(sql);
			preparedStmt.setInt(1, bookId);
			preparedStmt.setString(2, bookName);
			preparedStmt.setInt(3, borrowedBy);
			preparedStmt.setString(4, borrowDate);
			preparedStmt.setString(5, borrowStatus);
			preparedStmt.setString(6, fine);
			preparedStmt.executeUpdate();
	
			
	    }catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }
		
		return true;
	}
	
	public boolean modifyStatus(int borrowId, String borrowStatus)   
	{
		sql= "UPDATE borrows SET borrow_status='"+borrowStatus+"' WHERE borrow_id="+borrowId;
		
		try {
			
			stmt  = conn.createStatement();
			stmt.executeUpdate(sql);
	
			
	    }catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }
		
		return true;
	}
	
	public boolean modifyFine(int borrowId, String fine)   
	{
		sql= "UPDATE borrows SET fine='"+fine+"' WHERE borrow_id="+borrowId;
		
		try {
			
			stmt  = conn.createStatement();
			stmt.executeUpdate(sql);
	
			
	    }catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }
		
		return true;
	}
	
	public boolean delete(int borrowId)      
	{
		sql= "DELETE FROM borrows WHERE borrow_id="+borrowId;
		
		try {
			
			stmt  = conn.createStatement();
			stmt.executeUpdate(sql);
	
			
	    }catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }
		
		return true;
	}
	
}
