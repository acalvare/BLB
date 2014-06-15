package server.interfaces;

import javax.jws.WebMethod;
import javax.jws.WebService;

import server.business.Bond;
import server.business.Client;

@WebService
public interface Financial {
	@WebMethod
	boolean buyBond(Bond bond, Client client, int quantity);
	@WebMethod
	boolean sellBond(Bond bond, Client client, int quantity);
}
