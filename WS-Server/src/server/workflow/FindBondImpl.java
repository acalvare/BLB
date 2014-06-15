package server.workflow;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import server.business.Bond;
import server.interfaces.FindBond;

@WebService(endpointInterface = "server.interfaces.FindBond")
public class FindBondImpl implements FindBond {

	Connection conn = null;
	ResultSet rs = null;
	List<Bond> bondList = new ArrayList<Bond>();

	@Override
	public List<Bond> getBonds(Bond low, Bond high) {

		// preparing some objects for connection
		PreparedStatement prpStmt = null;

		// Todo: getValues from low and high and build the Query

		String sql = "select bond.CUSIP, bond.issuer, bond.coupon, bond.yield, bond.bondName, bond.par, bond.maturityDate, " +
				"bond.rating, bond.bidPrice, bond.askPrice, bond.bondType, bond.quantity as `marketQuantity` " +
				"from bond " +
				"where CUSIP like ? " +
				"and issuer like ? " +
				"and bondName like ? " +
				"and coupon between ? AND ? " +
				"and yield between ? AND ? " +
				"and par between ? AND ? " +
				"and askPrice between ? AND ? "+
				"and maturityDate between ? AND ? ";
		try {
			// connect to DB
			java.util.Date utilStartDateLow = low.getMaturity();
			java.sql.Date sqlStartDateLow = new java.sql.Date(utilStartDateLow.getTime());
			java.util.Date utilStartDateHigh = high.getMaturity();
			java.sql.Date sqlStartDateHigh = new java.sql.Date(utilStartDateHigh.getTime());
			conn = DatabaseConnector.getConnection();
			prpStmt = conn.prepareStatement(sql);
//			prpStmt.setString(1, "%"+low.getCUSIP()+"%");
//			prpStmt.setString(2, "%"+low.getIssuer()+"%");
//			prpStmt.setString(3, low.getName());
//			prpStmt.setDouble(3, low.getCoupon());
//			prpStmt.setDouble(4, high.getCoupon());
//			prpStmt.setDouble(5, low.getYield());
//			prpStmt.setDouble(6, high.getYield());
//			prpStmt.setDouble(7, low.getPar());
//			prpStmt.setDouble(8, high.getPar());
//			prpStmt.setDouble(9, low.getAskPrice());
//			prpStmt.setDouble(10, high.getAskPrice());
//			//prpStmt.setDate(12, (Date) low.getMaturity());
			prpStmt.setString(1, "%"+low.getCUSIP()+"%");
			prpStmt.setString(2,"%"+low.getIssuer()+"%");
			prpStmt.setString(3, "%"+low.getName()+"%");
			prpStmt.setDouble(4, low.getCoupon());
			prpStmt.setDouble(5, high.getCoupon());
			prpStmt.setDouble(6, low.getYield());
			prpStmt.setDouble(7, high.getYield());
			prpStmt.setDouble(8, low.getPar());
			prpStmt.setDouble(9, high.getPar());
			prpStmt.setDouble(10, low.getAskPrice());
			prpStmt.setDouble(11, high.getAskPrice());
			prpStmt.setDate(12, sqlStartDateLow);
			prpStmt.setDate(13, sqlStartDateHigh);


			rs = prpStmt.executeQuery();

			while (rs.next()) { 
				Bond bond = new Bond();

				bond.setCoupon(Double.parseDouble(rs.getString("coupon")));
				bond.setCUSIP(rs.getString("CUSIP"));
				bond.setIssuer(rs.getString("issuer"));
				bond.setYield(Double.parseDouble(rs.getString("yield")));

				SimpleDateFormat formater = new SimpleDateFormat("YYYY-MM-DD");
				bond.setMaturity(formater.parse(rs.getString("maturityDate")));
				bond.setName(rs.getString("bondName"));
				bond.setPar(Double.parseDouble(rs.getString("par")));
				bond.setQuantity(Integer.parseInt(rs.getString("marketQuantity")));
				bond.setRating(rs.getString("rating"));
				bond.setType(rs.getString("bondType"));
				bond.setAskPrice(Double.parseDouble(rs.getString("askPrice")));
				bond.setBidPrice(Double.parseDouble(rs.getString("bidPrice")));
				
				System.out.println(bond);
				bondList.add(bond);
				System.out.println("added");
			}
		}

		catch (Exception ex) {
			System.out.println("Getting bonds failed " + ex);
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
