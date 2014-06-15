package server.workflow;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import server.business.Client;
import server.business.Trader;
import server.interfaces.Customer;

@WebService(endpointInterface = "server.interfaces.Customer")
public class CustomerImpl implements Customer {

	Connection conn = null;
	ResultSet rs = null;
	List<Client> clientList = null; 

	@Override
	public List<Client> getClients(Trader trader) {

		clientList = new ArrayList<Client>();
		// preparing some objects for connection
		PreparedStatement prpStmt = null;

		String traderId = trader.getTraderId();

		String sql = "select name,tradeLimit,clientId from client where traderId=?";

		try {
			// connect to DB
			conn = DatabaseConnector.getConnection();
			prpStmt = conn.prepareStatement(sql);
			prpStmt.setString(1, traderId);

			rs = prpStmt.executeQuery();
			while(rs.next())
			{
				Client client = new Client();
				String name = rs.getString("name");
				String tradeLimit = rs.getString("tradeLimit");
				String clientId = rs.getString("clientId");

				client.setName(name);
				client.setTradeLimit(tradeLimit);
				client.setCustomerId(clientId);

				System.out.println(client);
				clientList.add(client);
				System.out.println("added");
			}
		}

		catch (Exception ex) {
			System.out.println("Getting customers failed " + ex);
		}

		// some exception handling
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}

			if (prpStmt != null) {
				try {
					prpStmt.close();
				} catch (Exception e) {
				}
				prpStmt = null;
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
				}

				conn = null;
			}
		}

		return clientList;
	}

}