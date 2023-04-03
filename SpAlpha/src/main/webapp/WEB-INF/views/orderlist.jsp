<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="cafe">return home</a>
<div align="center">
<table border="2" >
<thead>
<tr>
<td>ID</td>
<td>Main Course</td>
<td>Quantity</td>
<td>Total</td>
<td>Order Date</td>
<td></td>
</tr>
</thead>
<tbody >
<c:forEach items="${list}" var="order">
<tr>
<td>${order.oid}</td>
<td>${order.maincourse}</td>
<td>${order.quantity}</td>
<td>${order.total}</td>
<td></td>
<td>
<a href="">edit</a><br>
<a  href="">cancel</a>
</td>
</tr>
</c:forEach>
</tbody>
</table>



</body>
</html>