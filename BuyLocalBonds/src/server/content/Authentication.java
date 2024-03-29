
package server.content;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Authentication", targetNamespace = "http://interfaces.server/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Authentication {


    /**
     * 
     * @param arg0
     * @return
     *     returns server.content.Trader
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "authenticate", targetNamespace = "http://interfaces.server/", className = "server.content.Authenticate")
    @ResponseWrapper(localName = "authenticateResponse", targetNamespace = "http://interfaces.server/", className = "server.content.AuthenticateResponse")
    @Action(input = "http://interfaces.server/Authentication/authenticateRequest", output = "http://interfaces.server/Authentication/authenticateResponse")
    public Trader authenticate(
        @WebParam(name = "arg0", targetNamespace = "")
        Trader arg0);

}
