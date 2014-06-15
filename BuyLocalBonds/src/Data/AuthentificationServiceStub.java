package Data;

import server.content.Authentication;
import server.content.AuthenticationImplService;
import server.content.Trader;

public class AuthentificationServiceStub 
{
	
	public Trader authenticate(Trader trader)
	{
		AuthenticationImplService service = new AuthenticationImplService();
		Authentication auth = service.getAuthenticationImplPort();
		return auth.authenticate(trader);
				
	}

}
