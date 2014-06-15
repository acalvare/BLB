package server.business;

import java.util.ArrayList;
import java.util.List;

public class Trader {
	
	private String traderId;
	private String password;
	private String name;
	private String traderLimit;
	private String type;
	
	public Trader(){
		
	}
	public Trader(String traderId, String password){
		this.traderId=traderId;
		this.password=password;
		
	}
	
	public String getTraderId() {
		return traderId;
	}
	public void setTraderId(String traderId) {
		this.traderId = traderId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTraderLimit() {
		return traderLimit;
	}
	public void setTraderLimit(String tradeLimit) {
		this.traderLimit = tradeLimit;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Trader [traderId=" + traderId
				+ ", password=" + password + ", name=" + name
				+ ", traderLimit=" + traderLimit + ", type=" + type + "]";
	}
	
	
	
	
	

}
