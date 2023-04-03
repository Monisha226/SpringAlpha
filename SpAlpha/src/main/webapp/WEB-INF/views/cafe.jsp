<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cafe</title>
<style>
.error {
  color: red;position: static;
}
</style>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script>
$(document).ready(function() {
	
	$('#dt').val(new Date().toJSON().slice(0,10));
});
</script>
<script type="text/javascript">


function setprice() {
	mcp=document.getElementById((document.getElementById("mc").value)).value;
	qt=document.getElementById("qty").value;
	//alert(mcp +"...."+ qt);
	if (isNaN(qt)) {
	    qt=0;
	  }
	if (isNaN(mcp)) {
	    mcp=0;
	  }
	pr=mcp  *  qt ;
	document.getElementById("pr").value=pr;
}


</script>
</head>

<body>
<h1 align="center"> MONZ CAFE </h1>
<a href="orderlist">my orders List</a> <br/>
<button type="submit" value="logout">Logout</button> <br/>


<div align="center">
<form:form modelAttribute="orderb"  action="order-confirm" method="post" >
<p>
<form:label for="mc" path="">main course:</form:label>
<form:select id ="mc" path="maincourse" onchange="setprice()"   >
<form:option value="" label="" >--select--</form:option>
<form:option  value="cold coffee" label="cold coffee" >cold coffee -$15</form:option>
<form:option value="hot coffee" label="hot coffee">hot coffee -$20</form:option>
<form:option value="burger"  label="burger">burger -$20</form:option>
<form:option value="fries"  label="burger">fries -$10</form:option>
<form:option value="cake" label="cake">cake -$25</form:option>
<form:option value="milkshake" label="milkshake">milkshake -$15</form:option>
</form:select>
</p> 
<form:hidden path=""  id="cold coffee" value="15"/>
<form:hidden path="" id="hot coffee" value="20" />
<form:hidden path="" id="burger"  value="20"/>
<form:hidden path="" id="fries"  value="10"/>
<form:hidden path="" id="cake" value="25"/>
<form:hidden path="" id="milkshake" value="15"/>

<form:errors cssClass="error" path="Maincourse"></form:errors>

<p>
<form:label for="qty" path="" >quantity</form:label>
 <form:input path="quantity" onchange="setprice()"   type="number"  id="qty"  max="100" min="1"/>
</p>

<form:errors cssClass="error" path="Quantity"></form:errors>
<p>
<form:label for="pr" path="">price</form:label>
 <form:input path="total" readonly="true"  type="number" id="pr" min="0"/>
</p>

<p>
<form:label for="dt" path="" >Date</form:label>
 <form:input path="odate"  type="date" disabled="true"  id="dt"/>
</p>

<form:errors cssClass="error" path="Total"></form:errors>

<form:button type="submit">submit</form:button>
</form:form>
</div>
</body>
</html>