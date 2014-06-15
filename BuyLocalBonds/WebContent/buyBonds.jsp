<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page import="server.content.Trader" %>
    <%@ page import="java.util.*" %>
    <%@ page import="server.content.Client" %>
    <%@ page import="server.content.Bond" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Buy Bonds</title>
</head>
<body>

<% 	
			String traderInfo="";
			String traderName="";
			List bondList = new ArrayList<Bond>();
			boolean bondListFetched = false;
			Trader currentTrader;
			String error="";
			if(session.getAttribute("error")!=null){
				error = (String)session.getAttribute("error");
			}
			if(session.getAttribute("currentTrader")!=null){
				if((session.getAttribute("bondListFetched")!=null) && (session.getAttribute("bondListFetched").equals("true"))){
					System.out.println(session.getAttribute("bondListFetched"));
					bondListFetched = true;
					traderInfo = session.getAttribute("currentTrader").toString();
					currentTrader= (Trader)session.getAttribute("currentTrader");
					traderName = currentTrader.getName();
					System.out.println(traderInfo);
					System.out.println(traderName);
					bondList = (ArrayList)session.getAttribute("bondList");
					System.out.println(((ArrayList)session.getAttribute("bondList")).size());
				}
				else
					System.out.println("no bond list yet");
			}
			else{
				//this redirects the user to the login screen if they are not logged in
				session.setAttribute("error", "Please log in to the BLB tool");
				this.getServletContext().getRequestDispatcher("/login.jsp").forward(request,response);
			}
	
			%>

<% if(bondListFetched == false){%>
<table>
	<form id="bondSearch" method="post" action="BondWorkItem">
	<tr><th>Property</th><th>Low</th><th>High</th></tr>
	<tr><td>CUSIP    </td>  <td>   <input type="text" name="cusip"/></td> <td></td></tr>
	<tr><td>Issuer Name   </td>  <td><input type="text" name="issuerName"/></td> <td></td></tr>
	<tr><td>Bond Name </td>  <td><input type="text" name="bondName"/></td> <td></td></tr>
	<tr><td>Ask Price low: </td> <td><input type="text" name="askPriceLow"/></td> <td> High: <input type="text" name="askPriceHigh"/></td></tr>
	<tr><td>Coupon low: </td> <td><input type="text" name="couponLow"/></td> <td>High: <input type="text" name="couponHigh"/></td></tr>
	<tr><td>Maturity low: </td> <td><input type="date" name="maturityLow"/></td> <td>High: <input type="date" name="maturityHigh"/></td></tr>
	
	
<!-- 	<tr><td>Rating low: </td> <td><input type="text" name="ratingLow"/></td> <td> High: <input type="text" name="ratingHigh"/></td></tr> -->
	<tr><td>Yield low: </td> <td><input type="text" name="yieldLow"/></td> <td> High: <input type="text" name="yieldHigh"/></td></tr>
	<tr><td>Par low: </td> <td><input type="text" name="parLow"/></td> <td> High: <input type="text" name="parHigh"/></td></tr>
	<tr><td>Type </td> <td><select name="type">
			<option value="Corporate"> Corporate </option>
			<option value="Government"> Government </option>
			</select></td><td><input type="submit" value="Find Bonds"/></td></tr>
	</form>
</table>
<% }
	
	else{
	System.out.println("have bond list");
	System.out.println(bondList.toString());
	%>
	<form id="buyBonds" method="get" action="BondWorkItem">
	<table border="1">
	<tr><th>CUSIP</th><th>Issuer</th><th>Bond Name</th><th>Price</th><th>Maturity</th><th>Yield</th><th>Par</th><th>Type</th><th>Quantity</th></tr>
	<%
	for(int i=0; i < bondList.size(); i++)
			{
				Bond currentBond = (Bond)bondList.get(i);
				String cusip = currentBond.getCUSIP();
				String issuer = currentBond.getIssuer();
				String name = currentBond.getName();
				Double price = currentBond.getAskPrice();
				Date maturity = currentBond.getMaturity();
				Double yield = currentBond.getYield();
				Double par = currentBond.getPar();
				String type = currentBond.getCUSIP();
				%>
					<tr><td><input type="checkbox" name="selectedBonds[]" value="<%= cusip %>" /><%= cusip %></td>
					<td><%= issuer %></td>
					<td><%= name %></td>
					<td><%= price.toString() %></td>
					<td><%= maturity.toString() %></td>
					<td><%= yield.toString() %></td>
					<td><%= par.toString() %></td>
					<td><%= type %></td>
					<td><input type="text" name="selectedQuantities[]"/></td>
					</tr>
				<% 
			}
	%>
	</table><br/>
	<input type="submit" value="Buy Bonds!">
	</form>
	
	<form id="back" action="BondWorkItem">
		<input type="text" name="back" value="true" style="display: none;"/>
		<input type="submit" value="Back"/>
	</form>
	<%
	}
			
			%>
<h3 style="color:red">
<%= error %>
</h3>
</body>
</html>