<%@page import="java.util.ArrayList"%>
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
<h1>THE AVAILABLE VECHILES ARE</h1>
<table border="2px solid black">
        <tr>
        <th>Vechile_id</th>
        <th>Vechile_brand</th>
        <th>Vechile_name</th>
        <th>Vechile_type</th>
        <th>price</th>
        <th>delete</th>
        <th>update</th>
        </tr>
   <% ArrayList<Vechile> vechiles=(ArrayList)request.getAttribute("vechile");
   for(Vechile v:vechiles){%>
   <tr>
  <td><%=v.getVechileid() %></td>
   <td><%= v.getVechilebrand()%></td>
   <td><%=v.getVechilename() %></td>
   <td><%=v.getVechiletype()%></td>
   <td><%=v.getVechileprice()%></td>
    <td><a href="delete1?id=<%=v.getVechileid()%>">delete</a></td>
    <th><a href="update1?id=<%=v.getVechileid()%>">edit</a></th>
    
   </tr>
   <%} %>
	 </table>
	 <h2><a href="welcome.html">home</a></h>
</body>
</html>