package Data;
import java.util.*;

import server.content.Bond;
import server.content.Client;
import server.content.Financial;
import server.content.FinancialImplService;
import server.content.FindBond;
import server.content.FindBondImplService;
import server.content.Holdings;
import server.content.HoldingsImplService;
import server.content.Trader;


public class FinancialServiceStub {
	
	public boolean transactBonds(Bond bond, Client client, int quantity)
	{
//		Date date = new Date();
//		ArrayList bonds = new ArrayList<Bond>();
//		Bond b1=new Bond("asdf", 30.00, 31.00, 6.00, date, "American Treasury", "Treasury Bond", "AAA", 6.00, 100.0, 10, "Government" );
//		Bond b2=new Bond("asdf", 30.00, 31.00, 6.00, date, "German", "Bundt", "AAA", 6.00, 100.0, 10, "Government" );
//
//		bonds.add(b1);
//		bonds.add(b2);
		FinancialImplService service = new FinancialImplService();
		Financial financial = service.getFinancialImplPort();
		//System.out.println("Client id in holding stub is : "+currentClient.getCustomerId());
		return financial.buyBond(bond, client, quantity);
				
	}

}
