
<!DOCTYPE html>
<html lang="en">
<head>
  
  <title>BLB Tool</title>
   <link type="text/css" rel="stylesheet" href="login.css">
   <link rel="stylesheet" type="text/css" href="general.css" />
   <script type="text/javascript" src="jquery.js"></script>
	<script type="text/javascript" src="ajaxtabs/ajaxtabs.js"></script>
	<script type="text/javascript" src="popup.js"></script>
  
  
</head>
<style>
	form
	{
		border: 1px solid black;
		margin-left: auto;
		margin-right: auto;
		width:60%;
		vertical-align:bottom;
		padding: 10px;
		text-align: center;
	}
	div{
		margin-left: auto;
		margin-right: auto;
	}
	p{
		
		margin-left: auto;
		margin-right: auto;
		width: 70%;
	}
	footer{
		text-align: center;
	}

</style>
<body>
	<div id="container" style="width: 80%;">
	  <div id="popupContact" style="width: 60%;">
	  	<h1 style="text-align: center;">Please enter your login information</h1>
	  	<form action="LoginWorkitem" method=post>
	  		Trader ID
					<input type="text" id="traderId" name="traderId"><br>
			Password
					<input type="password" name="password" id="password"><br>
					<input type="submit" id="enter" value="Login">
	  	</form>
	  	<div id="message" style="text-align: center;"></div>
			<% 	
			String error="";
			if(session.getAttribute("error")!=null){
			error = session.getAttribute("error").toString();
			session.setAttribute("error",null); 
			}
	
			%>
			
			<h3 style="color: red; text-align: center;">${error} </h3>
		
		
		    <footer>
		     <p>&copy; Copyright  by Team3</p>
		    </footer>
	  </div>
	 </div>
	 <div id="backgroundPopup">	
			</div>
</body>
</html>
