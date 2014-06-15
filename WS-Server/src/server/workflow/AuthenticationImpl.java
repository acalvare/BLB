package server.workflow;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import server.business.Client;
import server.business.Trader;
import server.interfaces.Authentication;

@WebService(endpointInterface = "server.interfaces.Authentication")
public class AuthenticationImpl implements Authentication {

	Connection conn = null;
	ResultSet rs = null;
	List<Client> clientList = new ArrayList<Client>();

	@Override
	public Trader authenticate(Trader trader) {
 
		// preparing some objects for connection
		PreparedStatement prpStmt = null;

		String traderId = trader.getTraderId();
		String password = trader.getPassword();

		String sql = "select name,traderLimit,type from trader where traderId=? AND password=?";

		// String searchQuery ="select * from trader where traderId='"+ traderId
		// + "' AND password='"+ password+ "'";

		try {
			// connect to DB
			conn = DatabaseConnector.getConnection();
			prpStmt = conn.prepareStatement(sql);
			prpStmt.setString(1, traderId);
			prpStmt.setString(2, password);
			rs = prpStmt.executeQuery();
			boolean more = rs.next();

			// if user does not exist set the isValid variable to false
			if (!more) {
				trader = null;
				System.out
						.println("Sorry, you are not a registered user! Please sign up first");
			}

			// if user exists set the isValid variable to true
			else if (more) {
				String name = rs.getString("name");
				String traderLimit = rs.getString("traderLimit");
				String type = rs.getString("type");

				trader.setName(name);
				trader.setTraderLimit(traderLimit);
				trader.setType(type);
			}
		}

		catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! "
					+ ex);
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

		return trader;

	}

}