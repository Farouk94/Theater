<!DOCTYPE html>
<%@page import="java.util.*"%>
<html>
<head>
<style> 
.flex-container {
    display: -webkit-flex;
    display: flex;  
    -webkit-flex-flow: row wrap;
    flex-flow: row wrap;
    text-align: center;
}

.flex-container > * {
    padding: 15px;
    -webkit-flex: 1 100%;
    flex: 1 100%;
}

.article {
    text-align: left;
}

header {background: black;color:white;}
footer {background: #aaa;color:white;}
.nav {background:#eee;}

.nav ul {
    list-style-type: none;
    padding: 0;
}
.nav ul a {
    text-decoration: none;
}

@media all and (min-width: 768px) {
    .nav {text-align:left;-webkit-flex: 1 auto;flex:1 auto;-webkit-order:1;order:1;}
    .article {-webkit-flex:5 0px;flex:5 0px;-webkit-order:2;order:2;}
    footer {-webkit-order:3;order:3;}
}
</style>

<%
	ArrayList<String> eventList = new ArrayList<String>();
	ArrayList<String> eventIDList = new ArrayList<String>();
	 Map<Integer, String> eventMap =  new LinkedHashMap<Integer, String>();
	//storing passed value from jsp
	eventMap = ( Map<Integer, String>) request.getAttribute("eventListMap");
%>
</head>
<body>
<form action="BookingAction">
<div class="flex-container">
<header>
  <h1>BookMyChoice</h1>
</header>

<nav class="nav">
<ul>
 
  <li>List of Events</li>
  
</ul>
</nav>

<article class="article">
  <table border="10 px" style="width: 100">

				<%
					for (Map.Entry<Integer, String> entry : eventMap.entrySet()) {
				%>
				<tr bgcolor="blue">
					<td style="font-size: 20"><b><%=entry.getValue()%></b></td>
					<td>
						<button type="submit" name="submitEventId" value=<%=entry.getKey()%> style="width: 50; height: 70">Book</button>
					</td>
				</tr>

				<%
					}
				%>
				<tr>
					<td><img src="artevent.jpg" alt="Smiley face" height="200"
						width="200"></td>
					<td>
						<button type="submit" style="width: 50; height: 70">Book</button>
					</td>
				</tr>

			</table>
  
</article>

<footer>Copyright &copy; BookMyChoice</footer>
</div>
</form>
</body>
</html>
