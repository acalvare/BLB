package server.workflow;

import java.util.List;

import javax.xml.ws.Endpoint;

import server.business.Bond;
import server.business.Client;

public class WSPublisher {
	public static void main(String[] args) {
		
		Endpoint.publish("http://localhost:65000/WS/Authenticate",
				new AuthenticationImpl());
		Endpoint.publish("http://localhost:65000/WS/Customer",
				new CustomerImpl());
		Endpoint.publish("http://localhost:65000/WS/FindBond",
				new FindBondImpl());
		Endpoint.publish("http://localhost:65000/WS/Holdings",
				new HoldingsImpl());
		Endpoint.publish("http://localhost:65000/WS/Market",
				new MarketImpl());
		Endpoint.publish("http://localhost:65000/WS/Financial",
				new FinancialImpl());
		Endpoint.publish("http://localhost:65000/WS/AuditTrail",
				new AuditTrailImpl());
		
		System.out.println("Services running");

//		FindBondImpl f = new FindBondImpl();
//		Bond b1=new Bond();
//		Bond b2=new Bond();
//		
//		b1.setAskPrice(askPrice);

		//List<Bond> bonds = f.getBonds(b1, b2);
//		for(Bond b : bonds)
//			System.out.println(b.toString());
//		HoldingsImpl h = new HoldingsImpl();
//		Client c = new Client();
//		c.setCustomerId("1");
//		List<Bond> bonds = h.getCustomerBonds(c);
//		for(Bond b : bonds)
//			System.out.println(b.toString());

		
	}
}
