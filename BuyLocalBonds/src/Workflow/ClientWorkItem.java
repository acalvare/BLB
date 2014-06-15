package Workflow;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import server.content.Customer;
import server.content.Trader;
import server.content.Bond;
import server.content.Client;
import Data.AuthentificationServiceStub;
import Data.CustomerServiceStub;
import Data.HoldingServiceStub;

/**
 * Servlet implementation class ClientWorkItem
 */
public class ClientWorkItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		/** 
		 * This gets all of the bonds that the customer currently has
		 */
		HttpSession session = request.getSession(true);
		Client currentClient = new Client();
		String clientId = request.getParameter("client");
		List<Client> clientList = new ArrayList<Client>();
		clientList=(ArrayList)session.getAttribute("clientList");
		
		for(int i = 0; i < clientList.size(); i++){
			String id = ((Client)clientList.get(i)).getCustomerId();
			if(clientId.equals(id))
					{
					currentClient = clientList.get(i);
					}		
		}
	
		
		currentClient.setCustomerId(clientId);
		System.out.println("Current client id is :"+currentClient.getCustomerId());
		HoldingServiceStub holdingService = new HoldingServiceStub();
		List holdingList = holdingService.getHoldings(currentClient);


		String error;
		
		

		if(holdingList!=null)
	     {
	        System.out.println("Holdings found!");
	        System.out.println("Holdings size: " + holdingList.size());
			session.setAttribute("holdingsList",holdingList);
	          session.setAttribute("currentClient",currentClient);
	          response.sendRedirect("introScreen.jsp"); //logged-in page      		
	     }
		        
	     else {
	    	 error = "Error retreiving current holdings";
	    	 session.setAttribute("error",error); 
	    	 request.setAttribute("error", error);
	         this.getServletContext().getRequestDispatcher("/login.jsp").forward(request,response); //error page 
	     }
	} 
		


}
