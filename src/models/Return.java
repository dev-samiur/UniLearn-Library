package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Return {
	
	private Connection conn;
	private ResultSet rs;
	private String sql;
	private Statement stmt;
	private PreparedStatement preparedStmt;
	
	public Return()
	{
		conn= DBconfig.connect();
	}

	public ResultSet findAll()
	{
		sql= "SELECT * FROM return_requests";
		
		try {
			
			stmt  = conn.createStatement();
			rs= stmt.executeQuery(sql);
	
			
	    }catch (SQLException e) {
	         System.out.println(e.getMessage());
	    }
		
		return rs;
	}
	
	public boolean save(int borrowId, String returnRequestStatus)      
	{
		sql= "INSERT INTO return_requests (borrow_id, return_request_status) VALUES (?,?)";
		
		try {
			
			preparedStmt= conn.prepareStatement(sql);
			preparedStmt.setInt(1, borrowId);
			preparedStmt.setString(2, returnRequestStatus);
			preparedStmt.executeUpdate();
	
			
	    }catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }
		
		return true;
	}
	
	public boolean modify(int returnRequestsId, String returnRequestStatus)   
	{
		sql= "UPDATE return_requests SET return_request_status='"+returnRequestStatus+"' WHERE return_request_id="+returnRequestsId;
		
		try {
			
			stmt  = conn.createStatement();
			stmt.executeUpdate(sql);
	
			
	    }catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }
		
		return true;
	}
	
	public boolean delete(int returnRequestsId)      
	{
		sql= "DELETE FROM return_requests WHERE return_request_id="+returnRequestsId;
		
		try {
			
			stmt  = conn.createStatement();
			stmt.executeUpdate(sql);
	
			
	    }catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }
		
		return true;
	}
}
