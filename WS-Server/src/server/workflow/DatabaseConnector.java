package server.workflow;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
	
	static Connection con;
    static String url;
          
    public static Connection getConnection()
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
	

}
