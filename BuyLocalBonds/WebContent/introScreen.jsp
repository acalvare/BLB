<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ page import="server.content.Trader" %>
    <%@ page import="java.util.*" %>
    <%@ page import="server.content.Client" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="ajaxtabs/ajaxtabs.css" />
<link rel="stylesheet" type="text/css" href="general.css" />
<script type="text/javascript" src="ajaxtabs/ajaxtabs.js"></script>
<script type="text/javascript" src="popup.js"></script>

<title>BLB Tool</title>
<style>
.right
		{
		float:right;
		width:47%;
		}
		.left
		{
		float:left;
		width:47%;
		}
		.header
		{
		background-color:white;
		}
		#header
		{
		background-color:white;
		}
</style>
</head>
<body >
	<% 	
			String traderInfo="";
			String traderName="";
			String clientName="";
			String tradeLimit="";
			String clientId="";
			List clientList = new ArrayList<Client>();
			Trader currentTrader;
			if(session.getAttribute("currentTrader")!=null){
				traderInfo = session.getAttribute("currentTrader").toString();
				currentTrader= (Trader)session.getAttribute("currentTrader");
				traderName = currentTrader.getName();
				System.out.println(traderInfo);
				System.out.println(traderName);
				clientList = (ArrayList)session.getAttribute("clientList");
				System.out.println(((ArrayList)session.getAttribute("clientList")).size());
// 				if(session.getAttribute("currentClient")!=null)
// 				clientName=(String)session.getAttribute("currentClient");
			}
			else{
				//this redirects the user to the login screen if they are not logged in
				session.setAttribute("error", "Please log in to the BLB tool");
				this.getServletContext().getRequestDispatcher("/login.jsp").forward(request,response);
			}
	
			%>
<div id="container" style="width:80%; margin-left: auto;
		margin-right: auto; margin-top: auto; border:10px solid black; background-color:white; margin-bottom: 1em; padding: 10px ">

<div id="header" style="background-color:white" >
	<h1 style="margin-bottom:0;" class="left">BLB Tool</h1>
	<img src="style/db.jpg" class="right"/>
</div>

<div id="menu" style="height:500px;width:12%;float:left; padding-top: 5%;">
	<ul id="options" class="shadetabs">
	<br/>
		<p><li><a href="client.jsp" rel="optionsContainer" class="selected">Holdings</a></li></p>
		<br/>
		<br/>
		<p><li><a href="buyBonds.jsp" rel="optionsContainer"> Purchase  </a></li></p>
		<br/>
		<br/>
		<p><li><a href="http://www.timeanddate.com/holidays/us/">Calendar</a></li></p>
	</ul>
</div>

<div id="content" style="height:500px;width:86%;float:left; border:2px solid black; background-color:#CCC ">
    <div id="clientSelect" style="margin-bottom: 1em; padding: 10px">
        <form id="selectForm" action="ClientWorkItem" method="post">
        Client : <select name="client"  >
        	<%
			for(int i=0; i < clientList.size(); i++)
			{
				String customerName = ((Client)clientList.get(i)).getName();
				String customerId = ((Client)clientList.get(i)).getCustomerId();
				%>
				<option value="<%= customerId %>" /> <%= customerName %>, Id:<%= customerId %>
				
				<% 
					
			}
			
			%>
        </select>   
        <input type="submit" value="Select Client"> 
        </form>
        <hr/>                   
    </div>
    
    <div id="clientInfo" style="margin-bottom: 1em; padding: 10px">
    <%
    if(session.getAttribute("currentClient")!=null){
    	Client currentClient = (Client)session.getAttribute("currentClient");
    	clientName= currentClient.getName();
    	tradeLimit = currentClient.getTradeLimit();
    	clientId = currentClient.getCustomerId();
    }
    
    %>
    <table border="1">
    <tr><th>Name</th><th>ID</th><th>Trade Limit</th></tr>
    <tr><td><%= clientName %></td><td><%= clientId %></td><td><%= tradeLimit %></td></tr>
    </table>
    <hr/>  
    </div>
    
    <div id="specificInfo" style="margin-bottom: 1em; padding: 10px">
    
    	<div id="optionsContainer" style="overflow-y: auto; margin-bottom: auto;  height:200px;">
		
		<hr/>  
		</div>
		
		<script type="text/javascript">
		var countries=new ddajaxtabs("options", "optionsContainer")
		countries.setpersist(true)
		countries.setselectedClassTarget("link") //"link" or "linkparent"
		countries.init()
		</script>
		
    </div>


</div>

<div id="footer" style="clear:both;text-align:center;">
</div>

</div>
 
</body>
</html>