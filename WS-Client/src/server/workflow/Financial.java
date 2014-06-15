
package server.workflow;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import server.interfaces.ObjectFactory;
import server.interfaces.Trader;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Financial", targetNamespace = "http://interfaces.server/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Financial {


    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "authenticate", targetNamespace = "http://interfaces.server/", className = "server.interfaces.Authenticate")
    @ResponseWrapper(localName = "authenticateResponse", targetNamespace = "http://interfaces.server/", className = "server.interfaces.AuthenticateResponse")
    @Action(input = "http://interfaces.server/Financial/authenticateRequest", output = "http://interfaces.server/Financial/authenticateResponse")
    public boolean authenticate(
        @WebParam(name = "arg0", targetNamespace = "")
        Trader arg0);

}
