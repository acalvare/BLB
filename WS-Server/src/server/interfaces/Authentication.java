package server.interfaces;

import javax.jws.WebMethod;
import javax.jws.WebService;

import server.business.Trader;

@WebService
public interface Authentication {
	@WebMethod
	Trader authenticate(Trader trader);
}
