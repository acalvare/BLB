package Data;

import java.sql.*;
import java.util.*;

import server.content.Client;
import server.content.Trader;

public class TraderProvider {
	
	 Connection conn = null;
	 ResultSet rs = null; 
	 DatabaseConnector connector = new DatabaseConnector();
	 List clientList= new ArrayList<Client>();
	
	public TraderProvider(){
		
		
		this.conn = connector.getConnection();
	}
	
	 
		
	
		
    
  


}
