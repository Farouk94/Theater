<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.*"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
</head>

<%

Map<String, Integer>  seatCountByCategory = (Map<String, Integer> )request.getAttribute("seatCountByCategory");

int aCategory = seatCountByCategory.get("aCount");
int bCategory = seatCountByCategory.get("bCount");

double earnings = (aCategory*5*3) + (bCategory*2.5*5);
%>

<body>

A : <input type="text" value= <%=aCategory %> />

B : <input type="text" value= <%=bCategory %> />

Total Earning <input type="text" value= <%=earnings %> />
</body>
</html>