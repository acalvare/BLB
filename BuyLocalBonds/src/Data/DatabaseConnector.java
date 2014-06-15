package Data;

import java.sql.*;
import java.util.*;

public class DatabaseConnector {
	
	private DatabaseConnector instance = null;
	
	public DatabaseConnector()
	{
		
	}
	
	static Connection con;
    static String url;
          
    public Connection getConnection()
    {
      
	       try
	       {
	
	          Class.forName("com.mysql.jdbc.Driver");
	          System.out.println("in the first try");
	          
	          try
	          {            	
	             con = DriverManager.getConnection("jdbc:mysql://localhost/blbdb","root","mysql");
	             System.out.println("Logged in successfully");
	               
	          }
	          
	          catch (SQLException ex)
	          {
	             ex.printStackTrace();
	          }
	       }
	
	       catch(ClassNotFoundException e)
	       {
	          System.out.println(e);
	       }
	
	    return con;
    }
	
	
	public boolean executeQuery(String query){
		
		return true;
	}
	

}
