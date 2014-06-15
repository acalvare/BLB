package server.interfaces;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import server.business.Bond;

@WebService
public interface FindBond {
	@WebMethod
	List<Bond> getBonds(Bond low, Bond high);
}
