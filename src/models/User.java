package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class User {
	
	private Connection conn;
	private ResultSet rs;
	private String sql;
	private Statement stmt;
	private PreparedStatement preparedStmt;
	
	public User()
	{
		conn= DBconfig.connect();
	}

	public ResultSet findAll()
	{
		sql= "SELECT * FROM users";
		
		try {
			
			stmt  = conn.createStatement();
			rs= stmt.executeQuery(sql);
	
			
	    }catch (SQLException e) {
	         System.out.println(e.getMessage());
	    }
		
		return rs;
	}
	
	public ResultSet findById(int userId)
	{
		sql= "SELECT * FROM users WHERE user_id="+userId;
		
		try {
			
			stmt  = conn.createStatement();
			rs= stmt.executeQuery(sql);
	
			
	    }catch (SQLException e) {
	         System.out.println(e.getMessage());
	    }
		
		return rs;
	}
	
	public ResultSet findByEmail(String userEmail)
	{
		sql= "SELECT * FROM users WHERE user_email='"+userEmail+"'";
		
		try {
			
			stmt  = conn.createStatement();
			rs= stmt.executeQuery(sql);
	
			
	    }catch (SQLException e) {
	         System.out.println(e.getMessage());
	    }
		
		return rs;
	}
	
	public boolean save(String userName, String userEmail, String userPassword, String userAddress, int userDues)      
	{
		sql= "INSERT INTO users (user_name, user_email, user_Password, user_address, user_dues) VALUES (?,?,?,?,?)";
		
		try {
			
			preparedStmt= conn.prepareStatement(sql);
			preparedStmt.setString(1, userName);
			preparedStmt.setString(2, userEmail);
			preparedStmt.setString(3, userPassword);
			preparedStmt.setString(4, userAddress);
			preparedStmt.setInt(5, userDues);
			preparedStmt.executeUpdate();
	
			
	    }catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }
		
		return true;
	}
	
	public boolean modify(int userId, String userName, String userEmail, String userPassword, String userAddress, int userDues)   
	{
		sql= "UPDATE users SET user_name=?, user_email=?, user_password=?, user_address=?, user_dues=? WHERE user_id="+userId;
		
		try {
			
			preparedStmt= conn.prepareStatement(sql);
			preparedStmt.setInt(1, userId);
			preparedStmt.setString(2, userName);
			preparedStmt.setString(3, userEmail);
			preparedStmt.setString(4, userPassword);
			preparedStmt.setString(5, userAddress);
			preparedStmt.setInt(6, userDues);
			preparedStmt.executeUpdate();
	
			
	    }catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }
		
		return true;
	}
	
	public boolean delete(int userId)      
	{
		sql= "DELETE FROM users WHERE user_id="+userId;
		
		try {
			
			stmt  = conn.createStatement();
			stmt.executeUpdate(sql);
	
			
	    }catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }
		
		return true;
	}
}
