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
	private PreparedStatement preparedStmt;
	
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
	
	public ResultSet findByCatagory(String catagory)
	{
		sql= "SELECT * FROM books where book_catagory='"+catagory+"'";
		
		try {
			
			stmt  = conn.createStatement();
			rs= stmt.executeQuery(sql);
	
			
	    }catch (SQLException e) {
	    	System.out.println(e.getMessage());
	    }
		
		return rs;
	}
	
	public ResultSet findBySearchValue(String searchVal)
	{
		sql= "SELECT * FROM books WHERE book_name LIKE ? OR book_author LIKE ? OR book_catagory LIKE ?";
		
		try {
			
			preparedStmt= conn.prepareStatement(sql);
			preparedStmt.setString(1, "%"+searchVal+"%");
			preparedStmt.setString(2, "%"+searchVal+"%");
			preparedStmt.setString(3, "%"+searchVal+"%");
			rs= preparedStmt.executeQuery();
	
			
	    }catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }
		
		return rs;
	}
	
	public boolean save(String bookName, String bookAuthor, String bookCatagory, String bookFees, String bookQuantity, String bookCover)      
	{
		sql= "INSERT INTO books (book_name, book_author, book_catagory, book_fees, book_quantity, book_cover) VALUES (?,?,?,?,?,?)";
		
		try {
			
			preparedStmt= conn.prepareStatement(sql);
			preparedStmt.setString(1, bookName);
			preparedStmt.setString(2, bookAuthor);
			preparedStmt.setString(3, bookCatagory);
			preparedStmt.setString(4, bookFees);
			preparedStmt.setString(5, bookQuantity);
			preparedStmt.setString(6, bookCover);
			preparedStmt.executeUpdate();
	
			
	    }catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }
		
		return true;
	}
	
	public boolean modify(int book_id, String bookName, String bookAuthor, String bookCatagory, String bookFees, String bookQuantity, String bookCover)      
	{
		sql= "UPDATE books SET book_name=?, book_author=?, book_catagory=?, book_fees=?, book_quantity=?, book_cover=? WHERE book_id="+book_id;
		
		try {
			
			preparedStmt= conn.prepareStatement(sql);
			preparedStmt.setString(1, bookName);
			preparedStmt.setString(2, bookAuthor);
			preparedStmt.setString(3, bookCatagory);
			preparedStmt.setString(4, bookFees);
			preparedStmt.setString(5, bookQuantity);
			preparedStmt.setString(6, bookCover);
			preparedStmt.executeUpdate();
	
			
	    }catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }
		
		return true;
	}
	
	public boolean delete(int book_id)      
	{
		sql= "DELETE FROM books WHERE book_id="+book_id;
		
		try {
			
			stmt  = conn.createStatement();
			stmt.executeUpdate(sql);
	
			
	    }catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }
		
		return true;
	}
	
}
