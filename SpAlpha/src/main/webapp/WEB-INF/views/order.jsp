<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>order</title>
</head>
<body>
<div align="center">YOUR ORDERs:

<p><label>order_ID:     </label>${orderb.oid}</p>
<p><label>Main Course:  </label>${orderb.maincourse}</p>
<p><label>Quantity:     </label>${orderb.quantity}</p>
<p><label>Total:     </label>${orderb.total}</p>
<a href="placeorder">confirm order</a><br>
 <h1>${errmsg}</h1> <br>
<!-- <a href="mailbill">mail by bill</a> <br/> -->
 <a href="cafe">return home</a>
</div>
</body>
</html>