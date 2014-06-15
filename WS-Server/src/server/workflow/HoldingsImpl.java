package server.workflow;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import server.business.Bond;
import server.business.Client;
import server.interfaces.Holdings;

@WebService(endpointInterface = "server.interfaces.Holdings")
public class HoldingsImpl implements Holdings {

	Connection conn = null;
	ResultSet rs = null;
	List<Bond> bondList = null;

	@Override
	public List<Bond> getCustomerBonds(Client client) {

		bondList = new ArrayList<Bond>();
		// preparing some objects for connection
		PreparedStatement prpStmt = null;

		String sql = "select bond.CUSIP, bond.bondName, bond.issuer, bond.coupon, bond.yield, "
				+ "bond.par, bond.maturityDate, bond.rating, bond.bidPrice, "
				+ "bond.askPrice, bond.quantity as `marketQuantity`, holding.quantityHeld,  "
				+ "holding.`AveragePrice` from bond inner "
				+ "join (select CUSIP, sum(Case When type = 'B' Then Quantity Else "
				+ "(Quantity * -1) End) as QuantityHeld,sum(Quantity*price)/sum(Quantity) as `AveragePrice` "
				+ "from transaction where transactionId in (select portfolio.transactionId from portfolioownership "
				+ "inner join portfolio where portfolioownership.clientId = ? and "
				+ "portfolio.portfolioId = portfolioownership.portfolioId) group by CUSIP) as holding "
				+ "where bond.CUSIP = holding.CUSIP";

		try {
			// connect to DB
			conn = DatabaseConnector.getConnection();
			prpStmt = conn.prepareStatement(sql);
			prpStmt.setString(1, client.getCustomerId());

			rs = prpStmt.executeQuery();
			rs.toString();
			while (rs.next()) {
				Bond bond = new Bond();

				bond.setAskPrice(Double.parseDouble(rs.getString("askPrice")));
				bond.setCoupon(Double.parseDouble(rs.getString("coupon")));
				bond.setCUSIP(rs.getString("CUSIP"));
				bond.setIssuer(rs.getString("issuer"));

				SimpleDateFormat formater = new SimpleDateFormat("YYYY-MM-DD");
				bond.setMaturity(formater.parse(rs.getString("maturityDate")));
				bond.setName(rs.getString("bondName"));
				bond.setPar(Double.parseDouble(rs.getString("par")));
				//bond.setQuantity(Integer.getInteger(rs.getString("marketQuantity")));
				bond.setRating(rs.getString("rating"));
				//bond.setType(rs.getString("type"));
				bond.setYield(Double.parseDouble(rs.getString("yield")));
				bond.setQuantityHeld(Double.parseDouble(rs.getString("quantityHeld")));

				System.out.println(bond);
				bondList.add(bond);
				System.out.println("added");
				
			}
		}

		catch (Exception ex) {
			System.out.println("Getting holdings failed " + ex);
			ex.printStackTrace();
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

		return bondList;
	}
}