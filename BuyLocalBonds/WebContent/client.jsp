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
<link rel="stylesheet" type="text/css" href="ajaxtabs/ajaxtabs.css" />
<script type="text/javascript" src="ajaxtabs/ajaxtabs.js"></script>

<title>BLB Tool</title>
</head>
<body>

<div id="container" >

		
		<% 	
			String traderInfo="";
			String traderName="";
			List holdingList = new ArrayList<Client>();
			Trader currentTrader;
			if(session.getAttribute("currentTrader")!=null){
				traderInfo = session.getAttribute("currentTrader").toString();
				currentTrader= (Trader)session.getAttribute("currentTrader");
				traderName = currentTrader.getName();
				if(session.getAttribute("holdingsList")!=null){
				holdingList = (ArrayList)session.getAttribute("holdingsList");
				}
				System.out.println(((ArrayList)session.getAttribute("clientList")).size());
			}
			else{
				//this redirects the user to the login screen if they are not logged in
				session.setAttribute("error", "Please log in to the BLB tool");
				this.getServletContext().getRequestDispatcher("/login.jsp").forward(request,response);
			}
	
			%>
	<table border="1">
	<tr><th>CUSIP</th><th>Issuer</th><th>Coupon</th><th>Bond Name</th><th>Price</th><th>Maturity</th><th>Yield</th><th>Par</th><th>Type</th><th>Rating</th></tr>
	<%
	for(int i=0; i < holdingList.size(); i++)
			{
				Bond currentBond = (Bond)holdingList.get(i);
				String cusip = currentBond.getCUSIP();
				String issuer = currentBond.getIssuer();
				String name = currentBond.getName();
				Double price = currentBond.getAskPrice();
				Date maturity = currentBond.getMaturity();
				Double yield = currentBond.getYield();
				Double par = currentBond.getPar();
				Double coupon = currentBond.getCoupon();
				String type = currentBond.getCUSIP();
				String rating = currentBond.getRating();
				System.out.println(currentBond.toString());
				%>
					<tr><td><%= cusip %></td>
					<td><%= issuer %></td>
					<td><%= coupon %></td>
					<td><%= name %></td>
					<td><%= price.toString() %></td>
					<td><%= maturity.toString() %></td>
					<td><%= yield.toString() %></td>
					<td><%= par.toString() %></td>
					<td><%= type %></td>
					<td><%= rating %></td>
					</tr>
				<% 
			}
	%>
	</table>

		
		
			<%
// 			System.out.println("In client.jsp holding size is: "+holdingList.size());
// 			for(Bond b : (List<Bond>)holdingList){
// 				System.out.println(b.toString());
// 				//String bondName = b.getName()
// 			}
// 			for(int i=0; i < holdingList.size(); i++)
// 			{
// 				String cusip = ((Bond)holdingList.get(i)).getCUSIP();
// 				((Bond)holdingList.get(i)).toString();
				%>
<%-- 					<input type="submit" name="selectedCustomer" value="<%= cusip %>" /> --%>
					<%
			//}
			
			
			%>
	
		
		
		

			
		</div>