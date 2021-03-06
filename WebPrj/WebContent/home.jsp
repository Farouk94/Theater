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

String timeErrorMessage = (String)request.getAttribute("timeExceededError")!=null?(String)request.getAttribute("timeExceededError"):"";

%>

</head>
<body>
<form action="DisplayShows">
<div class="flex-container">
<header>
  <h1>BookMyChoice</h1>
  <a href="login.jsp"><b>Logout</b></a>
</header>

<% if(timeErrorMessage!=null || !timeErrorMessage.equals("")){ %>

<p style="color: red;">${timeExceededError}</p>

<%} %>

<nav class="nav">
<ul>
  <li><a href="DisplayShows?name=events">Events</a></li>
  <li><a href="DisplayShows?name=movies">Movies</a></li>
  
</ul>
</nav>

<article class="article">
  <img src="movies.jpg" alt="Smiley face" height="300" width="500">
  <img src="upcomingevents.jpg" alt="Smiley face" height="300" width="500">
  
</article>

<footer>Copyright &copy; BookMyChoice</footer>
</div>
</form>
</body>
</html>
