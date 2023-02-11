<%@page import="com.js.dto.Vechile" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>ENTER BIKE DETAILS TO UPDATE</h1>
<% Vechile vi=(Vechile) request.getAttribute("vechile"); %>
<form action="update2">
VECHILE_ID:<input type="number" name="vid" value="<%=vi.getVechileid()%>"><br><br>
VECHILE_BRAND:<input type="text" name="vbrand" value="<%=vi.getVechilebrand() %>"><br><br>
VECHILE_NAME:<input type="text" name="vname" value="<%=vi.getVechilename() %>"><br><br>
VECHILE TYPE:<input type="text" name="vtype" value="<%=vi.getVechiletype() %>"><br><br>
PRICE:<input type="number" name="vp" value="<%= vi.getVechileprice()%>">
<input type="submit" value="update">
</form>
<h2><a href="welcome.html">home</a></h2>
</body>
</html>