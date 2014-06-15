package server.workflow;

import javax.jws.WebService;

import server.business.Transaction;
import server.interfaces.Market;
@WebService(endpointInterface = "server.interfaces.Market")
public class MarketImpl implements Market {

	@Override
	public boolean settle(Transaction transaction) {
		// TODO Auto-generated method stub
		return false;
	}


	

}