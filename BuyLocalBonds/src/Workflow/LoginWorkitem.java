package Workflow;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import server.content.Trader;
import server.content.Client;
import Data.AuthentificationServiceStub;
import Data.CustomerServiceStub;

/**
 * Servlet implementation class LoginServlet
 */

public class LoginWorkitem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String traderId = request.getParameter("traderId");
		String password = request.getParameter("password");
		String error;
		Trader trader = new Trader();
		trader.setTraderId(traderId);
		trader.setPassword(password);
		HttpSession session = request.getSession(true);

		AuthentificationServiceStub authService = new AuthentificationServiceStub();
		// trader.isValid().getValid())
		// authService.authenticate(trader)
		trader = authService.authenticate(trader);
		if (trader != null) {

			CustomerServiceStub custService = new CustomerServiceStub();
			session.setAttribute("clientList", null);
			List clientList = custService.getClients(trader);
			System.out.println("Client list size: "+clientList.size());
			session.setAttribute("clientList", clientList);
			session.setAttribute("currentSessionUser", traderId);
			session.setAttribute("currentTrader", trader);
			// session.setAttribute("clientList",trader.getClients());
			response.sendRedirect("introScreen.jsp"); // logged-in page
		}

		else {
			error = "Incorrect TraderId/Password Combo, Please Try Again";
			session.setAttribute("error", error);
			request.setAttribute("error", error);
			this.getServletContext().getRequestDispatcher("/login.jsp")
					.forward(request, response); // error page
		}
	}

}
