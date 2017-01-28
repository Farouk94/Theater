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

String startTime = (String)request.getAttribute("startTime");

String bookedSeat = (String)request.getAttribute("seatNumber");
%>
</head>
<body>
<form action="SubmitPayment">
<div class="flex-container">
<header>
  <h1>BookMyChoice</h1>
</header>

<nav class="nav">
<ul>
 <li><b> Enjoy Your Show</b></li>
  
</ul>
</nav>

<article class="article">

 <input type="hidden" name="startTime" value=<%=startTime%>>
<input type="hidden" name="seatNumber" value= <%=bookedSeat%>>
<blockquote><b>Enter Your Card Details </b></blockquote>

Card Number <input type="text" name="cardNumber" >&nbsp;
Name on The Card <input type="text" name="name" > &nbsp;

Expiry Month <input type="text" name="month"> &nbsp; 
Expiry Year <input type="text" name="year">
CVV <input type="text" name="cvv">
<button type="submit" style="color: blue">Make Payment</button>

</article>

<footer>Copyright &copy; BookMyChoice</footer>
</div>
</form>
</body>
</html>
