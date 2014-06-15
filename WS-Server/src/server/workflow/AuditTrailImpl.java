package server.workflow;

import javax.jws.WebService;

import server.business.Transaction;
import server.interfaces.AuditTrail;
@WebService(endpointInterface = "server.interfaces.AuditTrail")
public class AuditTrailImpl implements AuditTrail {

	@Override
	public boolean logging(Transaction transaction) {
		// TODO Auto-generated method stub
		return false;
	}


	

}