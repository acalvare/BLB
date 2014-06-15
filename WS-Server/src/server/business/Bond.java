package server.business;

import java.util.Date;

public class Bond {
	
	private String CUSIP;
	private double bidPrice;
	private double askPrice;
	private double coupon;
	private Date maturity;
	private String issuer;
	private String name;
	private String rating;
	private double yield;
	private double par;
	private int quantity;
	private String type;
	private double avaragePrice;
	private double quantityHeld;
	
	public Bond(){
		
	}

	public Bond(String cUSIP, double bidPrice, double askPrice, double coupon,
			Date maturity, String issuer, String name, String rating,
			double yield, double par, int quantity, String type) {
		super();
		CUSIP = cUSIP;
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

 
	@Override
	public String toString() {
		return "Bond [CUSIP=" + CUSIP + ", bidPrice=" + bidPrice
				+ ", askPrice=" + askPrice + ", coupon=" + coupon
				+ ", maturity=" + maturity + ", issuer=" + issuer + ", name="
				+ name + ", rating=" + rating + ", yield=" + yield + ", par="
				+ par + ", quantity=" + quantity + ", type=" + type
				+ ", avaragePrice=" + avaragePrice + ", quantityHeld="
				+ quantityHeld + "]";
	}

	public String getCUSIP() {
		return CUSIP;
	}

	public void setCUSIP(String cUSIP) {
		CUSIP = cUSIP;
	}

	public double getBidPrice() {
		return bidPrice;
	}

	public void setBidPrice(double bidPrice) {
		this.bidPrice = bidPrice;
	}

	public double getAskPrice() {
		return askPrice;
	}

	public void setAskPrice(double askPrice) {
		this.askPrice = askPrice;
	}

	public double getCoupon() {
		return coupon;
	}

	public void setCoupon(double coupon) {
		this.coupon = coupon;
	}

	public Date getMaturity() {
		return maturity;
	}

	public void setMaturity(Date maturity) {
		this.maturity = maturity;
	}

	public String getIssuer() {
		return issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public double getYield() {
		return yield;
	}

	public void setYield(double yield) {
		this.yield = yield;
	}

	public double getPar() {
		return par;
	}

	public void setPar(double par) {
		this.par = par;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getAvaragePrice() {
		return avaragePrice;
	}

	public void setAvaragePrice(double avaragePrice) {
		this.avaragePrice = avaragePrice;
	}

	public double getQuantityHeld() {
		return quantityHeld;
	}

	public void setQuantityHeld(double quantityHeld) {
		this.quantityHeld = quantityHeld;
	}
	
	


}
