package server.business;


public class Client {
	
	private boolean valid = false;
	private String traderId;
	private String customerId;
	private String name;
	private String tradeLimit;
	
	public Client(){
		
	}
	public boolean isValid() {
		return valid;
	}
	@Override
	public String toString() {
		return "Client [customerId=" + customerId + ", name=" + name
				+ ", tradeLimit=" + tradeLimit + "]";
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	public String getTraderId() {
		return traderId;
	}
	public void setTraderId(String traderId) {
		this.traderId = traderId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTradeLimit() {
		return tradeLimit;
	}
	public void setTradeLimit(String tradeLimit) {
		this.tradeLimit = tradeLimit;
	}
	
	


}
