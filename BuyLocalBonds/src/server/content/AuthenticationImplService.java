
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
@WebServiceClient(name = "AuthenticationImplService", targetNamespace = "http://workflow.server/", wsdlLocation = "http://localhost:65000/WS/Authenticate?wsdl")
public class AuthenticationImplService
    extends Service
{

    private final static URL AUTHENTICATIONIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException AUTHENTICATIONIMPLSERVICE_EXCEPTION;
    private final static QName AUTHENTICATIONIMPLSERVICE_QNAME = new QName("http://workflow.server/", "AuthenticationImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:65000/WS/Authenticate?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        AUTHENTICATIONIMPLSERVICE_WSDL_LOCATION = url;
        AUTHENTICATIONIMPLSERVICE_EXCEPTION = e;
    }

    public AuthenticationImplService() {
        super(__getWsdlLocation(), AUTHENTICATIONIMPLSERVICE_QNAME);
    }

    public AuthenticationImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), AUTHENTICATIONIMPLSERVICE_QNAME, features);
    }

    public AuthenticationImplService(URL wsdlLocation) {
        super(wsdlLocation, AUTHENTICATIONIMPLSERVICE_QNAME);
    }

    public AuthenticationImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, AUTHENTICATIONIMPLSERVICE_QNAME, features);
    }

    public AuthenticationImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public AuthenticationImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns Authentication
     */
    @WebEndpoint(name = "AuthenticationImplPort")
    public Authentication getAuthenticationImplPort() {
        return super.getPort(new QName("http://workflow.server/", "AuthenticationImplPort"), Authentication.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Authentication
     */
    @WebEndpoint(name = "AuthenticationImplPort")
    public Authentication getAuthenticationImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://workflow.server/", "AuthenticationImplPort"), Authentication.class, features);
    }

    private static URL __getWsdlLocation() {
        if (AUTHENTICATIONIMPLSERVICE_EXCEPTION!= null) {
            throw AUTHENTICATIONIMPLSERVICE_EXCEPTION;
        }
        return AUTHENTICATIONIMPLSERVICE_WSDL_LOCATION;
    }

}
