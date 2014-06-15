package server.interfaces;

import javax.jws.WebMethod;
import javax.jws.WebService;

import server.business.Transaction;

@WebService
public interface AuditTrail {
	@WebMethod
	boolean logging(Transaction transaction);
}
