
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
@WebService(name = "Financial", targetNamespace = "http://interfaces.server/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Financial {


    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "buyBond", targetNamespace = "http://interfaces.server/", className = "server.content.BuyBond")
    @ResponseWrapper(localName = "buyBondResponse", targetNamespace = "http://interfaces.server/", className = "server.content.BuyBondResponse")
    @Action(input = "http://interfaces.server/Financial/buyBondRequest", output = "http://interfaces.server/Financial/buyBondResponse")
    public boolean buyBond(
        @WebParam(name = "arg0", targetNamespace = "")
        Bond arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        Client arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        int arg2);

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "sellBond", targetNamespace = "http://interfaces.server/", className = "server.content.SellBond")
    @ResponseWrapper(localName = "sellBondResponse", targetNamespace = "http://interfaces.server/", className = "server.content.SellBondResponse")
    @Action(input = "http://interfaces.server/Financial/sellBondRequest", output = "http://interfaces.server/Financial/sellBondResponse")
    public boolean sellBond(
        @WebParam(name = "arg0", targetNamespace = "")
        Bond arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        Client arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        int arg2);

}