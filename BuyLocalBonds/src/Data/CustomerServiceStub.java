package Data;

import java.util.List;

import server.content.Client;
import server.content.Customer;
import server.content.CustomerImplService;
import server.content.Trader;

public class CustomerServiceStub 
{
	
	public List<Client> getClients(Trader trader)
	{
		CustomerImplService service = new CustomerImplService();
		Customer customer = service.getCustomerImplPort();
		return customer.getClients(trader);
				
	}

}
