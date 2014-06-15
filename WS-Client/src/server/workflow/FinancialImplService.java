
package server.workflow;

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
@WebServiceClient(name = "FinancialImplService", targetNamespace = "http://workflow.server/", wsdlLocation = "http://localhost:8080/WS/Financial?wsdl")
public class FinancialImplService
    extends Service
{

    private final static URL FINANCIALIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException FINANCIALIMPLSERVICE_EXCEPTION;
    private final static QName FINANCIALIMPLSERVICE_QNAME = new QName("http://workflow.server/", "FinancialImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/WS/Financial?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        FINANCIALIMPLSERVICE_WSDL_LOCATION = url;
        FINANCIALIMPLSERVICE_EXCEPTION = e;
    }

    public FinancialImplService() {
        super(__getWsdlLocation(), FINANCIALIMPLSERVICE_QNAME);
    }

    public FinancialImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), FINANCIALIMPLSERVICE_QNAME, features);
    }

    public FinancialImplService(URL wsdlLocation) {
        super(wsdlLocation, FINANCIALIMPLSERVICE_QNAME);
    }

    public FinancialImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, FINANCIALIMPLSERVICE_QNAME, features);
    }

    public FinancialImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public FinancialImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns Financial
     */
    @WebEndpoint(name = "FinancialImplPort")
    public Financial getFinancialImplPort() {
        return super.getPort(new QName("http://workflow.server/", "FinancialImplPort"), Financial.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Financial
     */
    @WebEndpoint(name = "FinancialImplPort")
    public Financial getFinancialImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://workflow.server/", "FinancialImplPort"), Financial.class, features);
    }

    private static URL __getWsdlLocation() {
        if (FINANCIALIMPLSERVICE_EXCEPTION!= null) {
            throw FINANCIALIMPLSERVICE_EXCEPTION;
        }
        return FINANCIALIMPLSERVICE_WSDL_LOCATION;
    }

}