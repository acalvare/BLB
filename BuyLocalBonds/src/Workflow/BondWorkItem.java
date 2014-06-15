package Workflow;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import server.content.Trader;
import server.content.Bond;
import server.content.Client;
import Data.AuthentificationServiceStub;
import Data.FinancialServiceStub;
import Data.FindBondsServiceStub;

/**
 * Servlet implementation class BondWorkItem
 */
//@WebServlet("/BondWorkItem")
public class BondWorkItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		String error="";
		if(request.getParameter("back") == null){
			String[] selectedBonds = new String[1];
			String[] selectedQuantities = new String[1];
			Client client = new Client();
			Trader trader = new Trader();
			Bond bond = new Bond();
			try{
			selectedBonds = request.getParameterValues("selectedBonds[]");
			selectedQuantities = request.getParameterValues("selectedQuantities[]");
			}
			catch(Exception e){
				System.out.println("No bonds or quantities found");
				error="Please select bonds ands quantities to buy";
			}
			try{
				client = (Client)session.getAttribute("currentClient");
				System.out.println("The selected client in buyBonds is: "+client.toString());
				trader = (Trader)session.getAttribute("currentTrader");
			}
			catch(Exception e){
				System.out.println("Error pulling client/trader from session");
				
			}
			for(int i =0; i<selectedBonds.length;i++){
				String s = selectedBonds[i];
				String quantityString = selectedQuantities[i];
				int quantity = Integer.parseInt(quantityString);
				
				double askPrice=0;
				bond.setCUSIP(s);
				for(Bond b: (List<Bond>)session.getAttribute("bondList")){
					if(b.getCUSIP().equals(s)){
						askPrice=b.getAskPrice();
					}			
				}
				bond.setAskPrice(askPrice);
				FinancialServiceStub financialService =  new FinancialServiceStub();
				boolean status = financialService.transactBonds(bond, client, quantity);
				System.out.println("Was the bond transaction successful :"+status);
				
				
				
			}
			for(String s: selectedQuantities){
				System.out.println(s);
			}
			if(selectedBonds.length!=selectedQuantities.length)
			{
				error="Please enter quantities for each bond";
			}
			session.setAttribute("error",error);
			//session.setAttribute("bondListFetched","false");
			 response.sendRedirect("introScreen.jsp"); //logged-in page  
		}
		else{
			System.out.println("back is: "+request.getParameter("back"));
			if(request.getParameter("back").equals("true")){
					session.setAttribute("bondListFetched","false");
				 
			}
		 response.sendRedirect("introScreen.jsp"); //logged-in page
		}
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date maturityLow = new Date();
		Date maturityHigh = new Date();
		Bond lowBond = new Bond();
		Bond highBond = new Bond();
		
		/**This is the super long part of the code that makes sure that
		none of the parameters are null, and if any are they aren't added to
		the bond objects
		*/
		if(request.getParameter("cusip")!=null){
			lowBond.setCUSIP(request.getParameter("cusip"));
			highBond.setCUSIP(request.getParameter("cusip"));
		}
		if(request.getParameter("issuerName")!=null){
			lowBond.setIssuer(request.getParameter("issuerName"));
			highBond.setIssuer(request.getParameter("issuerName"));
		}
		if(request.getParameter("bondName")!=null){
			lowBond.setName(request.getParameter("bondName"));
			highBond.setName(request.getParameter("bondName"));
		}
		if(request.getParameter("askPriceLow")!=null){
			try{
			lowBond.setAskPrice(Double.parseDouble(request.getParameter("askPriceLow")));
			}
			catch(Exception e){
				System.out.println(e);
			}
		}
		if(request.getParameter("askPriceHigh")!=null){
			try{
			highBond.setAskPrice(Double.parseDouble(request.getParameter("askPriceHigh")));
			}
			catch(Exception e){
				System.out.println(e);
			}
		}
		if(request.getParameter("couponLow")!=null){
			try{
			lowBond.setCoupon(Double.parseDouble(request.getParameter("couponLow")));
			}
			catch(Exception e){
				System.out.println(e);
			}
		}
		if(request.getParameter("couponHigh")!=null){
			try{
			highBond.setCoupon(Double.parseDouble(request.getParameter("couponHigh")));
			}
			catch(Exception e){
				System.out.println(e);
			}
		}
		try{
			maturityLow = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("maturityLow"));
			lowBond.setMaturity(maturityLow);

			maturityHigh = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("maturityHigh"));
			highBond.setMaturity(maturityHigh);

		}
		catch(Exception e){
			System.out.println(e);
		}
		if(request.getParameter("ratingLow")!=null){
			lowBond.setRating(request.getParameter("ratingLow"));
		}
		if(request.getParameter("ratingHigh")!=null){
			highBond.setRating(request.getParameter("ratingHigh"));
		}
		if(request.getParameter("yieldLow")!=null){
			try{
			lowBond.setYield(Double.parseDouble(request.getParameter("yieldLow")));
			}
			catch(Exception e){
				System.out.println(e);
			}
		}
		if(request.getParameter("yieldHigh")!=null){
			try{
			highBond.setYield(Double.parseDouble(request.getParameter("yieldHigh")));
			}
			catch(Exception e){
				System.out.println(e);
			}
		}
		if(request.getParameter("parLow")!=null){
			try{
			lowBond.setPar(Double.parseDouble(request.getParameter("parLow")));
			}
			catch(Exception e){
				System.out.println(e);
			}
		}
		if(request.getParameter("parHigh")!=null){
			try{
			highBond.setPar(Double.parseDouble(request.getParameter("parHigh")));
			}
			catch(Exception e){
				System.out.println(e);
			}
		}
		if(request.getParameter("type")!=null){
			lowBond.setType(request.getParameter("type"));
			highBond.setType(request.getParameter("type"));
		}

		String error;

		/** Since we are searching for bonds to buy, I set the bid price to 0 (we aren't selling)
		 * and also set the quantity to zero (since we aren't ACTUALLY purchasing yet). Quantity
		 * will be set after the total bond list has already been displayed to the customer
		 */

		//Bond lowBond = new Bond(cusip,0,askPriceLow,couponLow,maturityLow,issuerName,bondName,ratingLow,yieldLow,parLow,0,type);
		//Bond highBond = new Bond(cusip,0,askPriceHigh,couponHigh,maturityHigh,issuerName,bondName,ratingHigh,yieldHigh,parHigh,0,type);
		List bondList = new ArrayList<Bond>();
		HttpSession session = request.getSession(true);
		
		FindBondsServiceStub bondService =  new FindBondsServiceStub();
		bondList=bondService.getBonds(highBond, lowBond);
		
		if(bondList!=null)
	     {
	        
				List clientList = new ArrayList<Client>();
				session.setAttribute("bondList",bondList);
				session.setAttribute("bondListFetched","true");
	         // session.setAttribute("currentSessionUser",traderId); 
	          //session.setAttribute("currentTrader",trader);
	          //session.setAttribute("clientList",trader.getClients());
	          response.sendRedirect("introScreen.jsp"); //logged-in page      		
	     }
		        
	     else {
	    	 error = "Error retrieving bond list";
	    	 session.setAttribute("error",error); 
	    	 request.setAttribute("error", error);
	         this.getServletContext().getRequestDispatcher("/login.jsp").forward(request,response); //error page 
	     }
	}

}
