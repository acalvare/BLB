package server.interfaces;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import server.business.Client;
import server.business.Trader;

@WebService
public interface Customer {
	@WebMethod
	List<Client> getClients(Trader trader);
}
