
package server.content;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "MarketImplService", targetNamespace = "http://workflow.server/", wsdlLocation = "http://localhost:65000/WS/Market?wsdl")
public class MarketImplService
    extends Service
{

    private final static URL MARKETIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException MARKETIMPLSERVICE_EXCEPTION;
    private final static QName MARKETIMPLSERVICE_QNAME = new QName("http://workflow.server/", "MarketImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:65000/WS/Market?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        MARKETIMPLSERVICE_WSDL_LOCATION = url;
        MARKETIMPLSERVICE_EXCEPTION = e;
    }

    public MarketImplService() {
        super(__getWsdlLocation(), MARKETIMPLSERVICE_QNAME);
    }

    public MarketImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), MARKETIMPLSERVICE_QNAME, features);
    }

    public MarketImplService(URL wsdlLocation) {
        super(wsdlLocation, MARKETIMPLSERVICE_QNAME);
    }

    public MarketImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, MARKETIMPLSERVICE_QNAME, features);
    }

    public MarketImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public MarketImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns Market
     */
    @WebEndpoint(name = "MarketImplPort")
    public Market getMarketImplPort() {
        return super.getPort(new QName("http://workflow.server/", "MarketImplPort"), Market.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Market
     */
    @WebEndpoint(name = "MarketImplPort")
    public Market getMarketImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://workflow.server/", "MarketImplPort"), Market.class, features);
    }

    private static URL __getWsdlLocation() {
        if (MARKETIMPLSERVICE_EXCEPTION!= null) {
            throw MARKETIMPLSERVICE_EXCEPTION;
        }
        return MARKETIMPLSERVICE_WSDL_LOCATION;
    }

}
