<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.*"%>

<html>
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
*, *:before, *:after {
	box-sizing: border-box;
}

html {
	font-size: 16px;
}

.plane {
	margin: 20px auto;
	max-width: 800px;
}

.cockpit {
	height: 250px;
	position: relative;
	overflow: hidden;
	text-align: center;
	border-bottom: 5px solid #d8d8d8; &: before { content : "";
	display: block;
	position: absolute;
	top: 0;
	left: 0;
	height: 200px;
	width: 100%;
	border-radius: 50%;
	border-right: 5px solid #d8d8d8;
	border-left: 5px solid #d8d8d8;
}

h1 {
	width: 60%;
	margin: 100px auto 35px auto;
}

}
.exit {
	position: relative;
	height: 50px; &: before , & : after {
    content : "EXIT";
	font-size: 14px;
	line-height: 18px;
	padding: 0px 2px;
	font-family: "Arial Narrow", Arial, sans-serif;
	display: block;
	position: absolute;
	background: green;
	color: white;
	top: 50%;
	transform: translate(0, -50%);
}

&
:before {
	left: 0;
}

&
:after {
	right: 0;
}

}
.fuselage {
	border-right: 5px solid #d8d8d8;
	border-left: 5px solid #d8d8d8;
}

ol {
	list-style: none;
	padding: 0;
	margin: 0;
}

.row {
	
}

.seats {
	display: flex;
	flex-direction: row;
	flex-wrap: nowrap;
	justify-content: flex-start;
}

.seat {
	display: flex;
	flex: 0 0 14.28571428571429%;
	padding: 5px;
	position: relative;
	&:
	nth-child
	(3)
	{
	margin-right
	:
	14.28571428571429%;
}

input[type=checkbox] {
	position: absolute;
	opacity: 0;
}

input[type=checkbox]:checked { + label { background:#bada55;
	-webkit-animation-name: rubberBand;
	animation-name: rubberBand;
	animation-duration: 300ms;
	animation-fill-mode: both;
}

}
input[type=checkbox]:disabled { + label { background:#dddddd;
	text-indent: -9999px;
	overflow: hidden; &: after { content : "X";
	text-indent: 0;
	position: absolute;
	top: 4px;
	left: 50%;
	transform: translate(-50%, 0%);
}

&
:hover {
	box-shadow: none;
	cursor: not-allowed;
}

}
}
label {
	display: block;
	position: relative;
	width: 100%;
	text-align: center;
	font-size: 14px;
	font-weight: bold;
	line-height: 1.5rem;
	padding: 4px 0;
	background: #F42536;
	border-radius: 5px;
	animation-duration: 300ms;
	animation-fill-mode: both; &: before { content : "";
	position: absolute;
	width: 75%;
	height: 75%;
	top: 1px;
	left: 50%;
	transform: translate(-50%, 0%);
	background: rgba(255, 255, 255, .4);
	border-radius: 3px;
}

&
:hover {
	cursor: pointer;
	box-shadow: 0 0 0px 2px #5C6AFF;
}

}
}
@
-webkit-keyframes rubberBand { 0% {
	-webkit-transform: scale3d(1, 1, 1);
	transform: scale3d(1, 1, 1);
}

30%
{
-webkit-transform
:
 
scale3d
(1
.25
,
0
.75
,
1);
transform
:
 
scale3d
(1
.25
,
0
.75
,
1);
}
40%
{
-webkit-transform
:
 
scale3d
(0
.75
,
1
.25
,
1);
transform
:
 
scale3d
(0
.75
,
1
.25
,
1);
}
50%
{
-webkit-transform
:
 
scale3d
(1
.15
,
0
.85
,
1);
transform
:
 
scale3d
(1
.15
,
0
.85
,
1);
}
65%
{
-webkit-transform
:
 
scale3d
(
.95
,
1
.05
,
1);
transform
:
 
scale3d
(
.95
,
1
.05
,
1);
}
75%
{
-webkit-transform
:
 
scale3d
(1
.05
,
.95
,
1);
transform
:
 
scale3d
(1
.05
,
.95
,
1);
}
100%
{
-webkit-transform
:
 
scale3d
(1
,
1,
1);
transform
:
 
scale3d
(1
,
1,
1);
}
}
@
keyframes rubberBand { 0% {
	-webkit-transform: scale3d(1, 1, 1);
	transform: scale3d(1, 1, 1);
}

30%
{
-webkit-transform
:
 
scale3d
(1
.25
,
0
.75
,
1);
transform
:
 
scale3d
(1
.25
,
0
.75
,
1);
}
40%
{
-webkit-transform
:
 
scale3d
(0
.75
,
1
.25
,
1);
transform
:
 
scale3d
(0
.75
,
1
.25
,
1);
}
50%
{
-webkit-transform
:
 
scale3d
(1
.15
,
0
.85
,
1);
transform
:
 
scale3d
(1
.15
,
0
.85
,
1);
}
65%
{
-webkit-transform
:
 
scale3d
(
.95
,
1
.05
,
1);
transform
:
 
scale3d
(
.95
,
1
.05
,
1);
}
75%
{
-webkit-transform
:
 
scale3d
(1
.05
,
.95
,
1);
transform
:
 
scale3d
(1
.05
,
.95
,
1);
}
100%
{
-webkit-transform
:
 
scale3d
(1
,
1,
1);
transform
:
 
scale3d
(1
,
1,
1);
}
}
.rubberBand {
	-webkit-animation-name: rubberBand;
	animation-name: rubberBand;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js">
</script>

<script type="text/javascript">
$(document).ready(function()
{
    alert('onload');
    var 
    alert(seatStatusMap.size());
    //Hides /Shows Fields on load?
    if (("input[title$='Phone Data Collection']").is(':checked'))
    //if (("input[title$='Phone Data Collection']").checked
    {
        alert('inside show for phone');
    }
});
</script>
<%
	int basePrice = 0;
	Map<String,String> seatStatusMap = (Map<String,String>)request.getAttribute("seatStatusMap")!=null?(Map<String,String>)request.getAttribute("seatStatusMap"):null;
	basePrice = (Integer) request.getAttribute("basePrice")!=null?(Integer) request.getAttribute("basePrice"):0;
	
	%>
</head>

<body>

<form action="ProcessPayment">
	<div class="plane">
		<div class="cockpit">
			<h1>Please select a seat</h1>
		</div>
		<div class="exit exit--front fuselage"></div>
		<input type="hidden" name="basePrice" value="<%=basePrice%>">
		<input type="hidden" style="color: blue"><b>A</b>
		<ol class="cabin fuselage">
			
			<li class="row row--1">
				<ol class="seats" type="A">
				
				<% 
					int i = 0;
					int row = 1;
					String checkStatus = "";
					for (Map.Entry<String,String> entry : seatStatusMap.entrySet()) {
						i++;
						checkStatus = entry.getValue();
						if(checkStatus.equals("Booked")){
							checkStatus = "disabled";
						}else{
							checkStatus = "";
						}
    			%>
    			
    			<%
    			
    				if(i==6){
    					row ++;
    					i = 1;
    			%>
    				
    				</ol>
    				</li>
    				<li class="row row--"<%=row%>>
    				<ol class="seats" type="A">
    				
    			<%} %>
    			
    				<% if(checkStatus.equals("")){ %>
    			
    				<li class="seat"><input type="checkbox" name="seatCheck" value=<%=entry.getKey()%>
						class="single-checkbox" id=<%=entry.getKey()%> /> <label for=<%=entry.getKey()%>><%=entry.getKey()%></label></li>
    				
    				<%
    				} else{
					%>
    				<li class="seat"><input type="checkbox" value=<%=entry.getKey()%>
						class="single-checkbox" id=<%=entry.getKey()%> disabled="disabled" /> <label for=<%=entry.getKey()%>><%=entry.getKey()%></label></li>
    				
    				<%} %>
    				<%} %>
    			
				</ol>
			</li>
		</ol>
		&nbsp;&nbsp;&nbsp;<input type="submit" name="Book" value="Book">
		<div class="exit exit--back fuselage"></div>
	</div>

	

<script type="text/javascript">
$("input[name=seatCheck]").change(function(){
    var max= 4;
    if( $("input[name=seatCheck]:checked").length == max ){
        $("input[name=seatCheck]").attr('disabled', 'disabled');
        $("input[name=seatCheck]:checked").removeAttr('disabled');
    }else{
         $("input[name=seatCheck]").removeAttr('disabled');
    }
})
</script>
</form>
</body>
</html>