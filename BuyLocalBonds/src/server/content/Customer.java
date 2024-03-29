
package server.content;

import java.util.List;
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
@WebService(name = "Customer", targetNamespace = "http://interfaces.server/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Customer {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<server.content.Client>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getClients", targetNamespace = "http://interfaces.server/", className = "server.content.GetClients")
    @ResponseWrapper(localName = "getClientsResponse", targetNamespace = "http://interfaces.server/", className = "server.content.GetClientsResponse")
    @Action(input = "http://interfaces.server/Customer/getClientsRequest", output = "http://interfaces.server/Customer/getClientsResponse")
    public List<Client> getClients(
        @WebParam(name = "arg0", targetNamespace = "")
        Trader arg0);

}
