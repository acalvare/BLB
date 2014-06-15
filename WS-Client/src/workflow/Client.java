package workflow;

import server.interfaces.Trader;
import server.workflow.Authentification;
import server.workflow.AuthentificationImplService;

public class Client {
	public static void main(String[] args) {
		
		AuthentificationImplService serviceLogin = new AuthentificationImplService();
		Authentification a = serviceLogin.getAuthentificationImplPort();
		System.out.println(a.authenticate(null));
		System.out.println(a.authenticate(new Trader()));

	}
}
