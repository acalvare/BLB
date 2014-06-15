package Data;

import java.util.ArrayList;
import java.util.List;

import server.content.Authentication;
import server.content.AuthenticationImplService;
import server.content.Holdings;
import server.content.HoldingsImplService;
import server.content.Bond;
import server.content.Client;

public class HoldingServiceStub {
	
	public List<Bond> getHoldings(Client currentClient){
		HoldingsImplService service = new HoldingsImplService();
		Holdings holdings = service.getHoldingsImplPort();
		System.out.println("Client id in holding stub is : "+currentClient.getCustomerId());
		return holdings.getCustomerBonds(currentClient);
		
	}

}
