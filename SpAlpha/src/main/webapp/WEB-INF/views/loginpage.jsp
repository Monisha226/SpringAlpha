<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
     <%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
<div align="center"> 
<h3 >LOGIN</h3>
<c:if test="${param.error != null}">
<i style="color: red">invalid username or password</i>
</c:if>
<form:form action="cafe" method="post">
USERNAME: <input type="text" name="username"><br>
PASSWORD: <input type="password" name="password">
<br>
<button type="submit" value="Login">Submit</button>
</form:form>

</div>
</body>
</html>