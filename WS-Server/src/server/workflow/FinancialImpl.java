package server.workflow;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.jws.WebService;

import server.business.Bond;
import server.business.Client;
import server.interfaces.Financial;

@WebService(endpointInterface = "server.interfaces.Financial")
public class FinancialImpl implements Financial {

	Connection conn = null;

	@Override
	public boolean buyBond(Bond bond, Client client, int quantity) {

		// preparing some objects for connection
		PreparedStatement transactionPrpStmt = null;
		PreparedStatement portfolioPrpStmt = null;

		// Todo: getValues from low and high and build the Query

		String transactionSql = "insert into transaction (CUSIP, quantity, type, price) values (?, ?, 'B', ?)";
		String portfolioSql = "INSERT INTO portfolio (portfolioId ,transactionId)"
				+ " (select max(portfolioId) as portfolioId, max(transactionId) as transactionId "
				+ "from portfolioownership, transaction where clientId = ?)";
		try {
			// connect to DB
			conn = DatabaseConnector.getConnection();
			transactionPrpStmt = conn.prepareStatement(transactionSql);
			transactionPrpStmt.setString(1, bond.getCUSIP());
			transactionPrpStmt.setInt(2, quantity);
			transactionPrpStmt.setDouble(3, bond.getAskPrice());
			
			portfolioPrpStmt = conn.prepareStatement(portfolioSql);
			portfolioPrpStmt.setString(1, client.getCustomerId());
			
			System.out.println("In FinancialImpSevice, CUSIP: "+bond.getCUSIP()+"current quantity: "+quantity+" price is: "+bond.getAskPrice());
			
			boolean transWork = false;
			boolean portWork = false;
			transWork = transactionPrpStmt.executeUpdate() > 0 ? true : false;
			portWork = portfolioPrpStmt.executeUpdate()> 0 ? true : false;
			if(transWork && portWork)
			return true;
			else
				return false;

		}

		catch (Exception ex) {
			System.out.println("Buy bonds failed " + ex);
		}

		// some exception handling
		finally {

			if (transactionPrpStmt != null) {
				try {
					transactionPrpStmt.close();
				} catch (Exception e) {
				}
				transactionPrpStmt = null;
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
				}

				conn = null;
			}
		}

		return false;
	}

	@Override
	public boolean sellBond(Bond bond, Client client, int quantity) {

		// preparing some objects for connection
		PreparedStatement prpStmt = null;

		// Todo: getValues from low and high and build the Query

		String sql = "";
		try {
			// connect to DB
			conn = DatabaseConnector.getConnection();
			prpStmt = conn.prepareStatement(sql);
			// prpStmt.setString(1, traderId);

			return prpStmt.executeUpdate("") > 0 ? true : false;

		}

		catch (Exception ex) {
			System.out.println("Sell bonds failed " + ex);
		}

		// some exception handling
		finally {

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

		return false;
	}
}
