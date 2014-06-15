
package server.content;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;




/**
 * <p>Java class for bond complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="bond">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="askPrice" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="bidPrice" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="CUSIP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="coupon" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="issuer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="maturity" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="par" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="rating" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="yield" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bond", propOrder = {
    "askPrice",
    "bidPrice",
    "cusip",
    "coupon",
    "issuer",
    "maturity",
    "name",
    "par",
    "quantity",
    "rating",
    "type",
    "yield"
})
public class Bond {

    protected double askPrice;
    protected double bidPrice;
    @XmlElement(name = "CUSIP")
    protected String cusip;
    protected double coupon;
    protected String issuer;
    @XmlSchemaType(name = "dateTime")
    protected Date maturity;
    protected String name;
    protected double par;
    protected int quantity;
    protected String rating;
    protected String type;
    protected double yield;

    public Bond(){
    	
    }
    public Bond(String cUSIP, double bidPrice, double askPrice, double coupon,
			Date maturity, String issuer, String name, String rating,
			double yield, double par, int quantity, String type) {
		super();
		cusip = cUSIP;
		this.bidPrice = bidPrice;
		this.askPrice = askPrice;
		this.coupon = coupon;
		this.maturity = maturity;
		this.issuer = issuer;
		this.name = name;
		this.rating = rating;
		this.yield = yield;
		this.par = par;
		this.quantity = quantity;
		this.type = type;
	}
    /**
     * Gets the value of the askPrice property.
     * 
     */
    public double getAskPrice() {
        return askPrice;
    }

    /**
     * Sets the value of the askPrice property.
     * 
     */
    public void setAskPrice(double value) {
        this.askPrice = value;
    }

    /**
     * Gets the value of the bidPrice property.
     * 
     */
    public double getBidPrice() {
        return bidPrice;
    }

    /**
     * Sets the value of the bidPrice property.
     * 
     */
    public void setBidPrice(double value) {
        this.bidPrice = value;
    }

    /**
     * Gets the value of the cusip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCUSIP() {
        return cusip;
    }

    /**
     * Sets the value of the cusip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCUSIP(String value) {
        this.cusip = value;
    }

    /**
     * Gets the value of the coupon property.
     * 
     */
    public double getCoupon() {
        return coupon;
    }

    /**
     * Sets the value of the coupon property.
     * 
     */
    public void setCoupon(double value) {
        this.coupon = value;
    }

    /**
     * Gets the value of the issuer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIssuer() {
        return issuer;
    }

    /**
     * Sets the value of the issuer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIssuer(String value) {
        this.issuer = value;
    }

    /**
     * Gets the value of the maturity property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public Date getMaturity() {
        return maturity;
    }

    /**
     * Sets the value of the maturity property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setMaturity(Date value) {
        this.maturity = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the par property.
     * 
     */
    public double getPar() {
        return par;
    }

    /**
     * Sets the value of the par property.
     * 
     */
    public void setPar(double value) {
        this.par = value;
    }

    /**
     * Gets the value of the quantity property.
     * 
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the value of the quantity property.
     * 
     */
    public void setQuantity(int value) {
        this.quantity = value;
    }

    /**
     * Gets the value of the rating property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRating() {
        return rating;
    }

    /**
     * Sets the value of the rating property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRating(String value) {
        this.rating = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the yield property.
     * 
     */
    public double getYield() {
        return yield;
    }

    /**
     * Sets the value of the yield property.
     * 
     */
    public void setYield(double value) {
        this.yield = value;
    }
	@Override
	public String toString() {
		return "Bond [askPrice=" + askPrice + ", bidPrice=" + bidPrice
				+ ", cusip=" + cusip + ", coupon=" + coupon + ", issuer="
				+ issuer + ", maturity=" + maturity + ", name=" + name
				+ ", par=" + par + ", rating=" + rating + ", yield=" + yield
				+ "]";
	}

    
}
