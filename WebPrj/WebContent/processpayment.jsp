<!DOCTYPE html>
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

Object startTime = (Object)request.getAttribute("startTime");

String bookedSeat = (String)request.getAttribute("seatNumber");

%>
</head>
<body>
<form action="SubmitCardDetail">
<div class="flex-container">
<header>
  <h1>BookMyChoice</h1>
</header>

  <input type="hidden" name="startTime" value=<%=startTime%>>
  <input type="hidden" name="seatNumber" value=<%=bookedSeat%>>
<nav class="nav">
<ul>
 <li><b> Enjoy Your Show</b></li>

</ul>
</nav>

<article class="article">

Booking Summary

Seat Number 	<input type="text" value="${seatNumber}" disabled="disabled">
Sub Total 	   <input type="text" value="${ticketPrice}" disabled="disabled">

Amount Payable <input type="text" value="${ticketPrice}" disabled="disabled">

<button type="submit" style="color: blue">PROCEED</button>

</article>

<footer>Copyright &copy; BookMyChoice</footer>
</div>
</form>
</body>
</html>
