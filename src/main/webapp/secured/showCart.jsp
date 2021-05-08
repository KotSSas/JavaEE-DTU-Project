<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 4/17/2021
  Time: 11:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cart</title>
</head>
<body>
<jsp:useBean id="cart" type="com.example.demoAutorisa.Cart" scope="request"/>
<h1>${cart.name}</h1>
<br>
<h2>${cart.quantity}</h2>
</body>
</html>
