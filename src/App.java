
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Book;

public class App {
	
	public static void main(String[] args) {
		
		
		try {
			
			Book obj= new Book();
			ResultSet rs= obj.findAll();
			
			while( rs.next())
			{
				System.out.println(rs.getInt("book_fees"));
			}
	
			
	    }catch (SQLException e) {
	            System.out.println(e.getMessage());
	    }
	}

}
