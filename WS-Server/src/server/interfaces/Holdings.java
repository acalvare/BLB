package server.interfaces;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import server.business.Bond;
import server.business.Client;

@WebService
public interface Holdings {
	@WebMethod
	List<Bond> getCustomerBonds(Client client);
	
}
