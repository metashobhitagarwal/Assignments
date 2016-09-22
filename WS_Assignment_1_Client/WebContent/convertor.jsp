<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html ">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet">
<link type="text/css" href="myStyle.css" rel="stylesheet">
</head>
<body>


<section id="header">
<h4>F To C Converter</h4></section>

   <section id="contact-form">
       <form  action="MyConvertor" method="post" >
	       <div class="line">
    	       <div class="lab"><label>Temperature </label></div>
        		   <span><i class="fa fa-sun" aria-hidden="true"></i></span>
              	<input type="number" name="tempInF" step="0.01" placeholder="temp">
			</div>

           <center>
           <button type="submit">Temp Convertor
           	<span><i class="fa fa-paper-plane-o" aria-hidden="true"></i></span>
           </button>
               </center>
       </form>	
<div class="resultbox"><%
if(request.getAttribute("outputTemp") != null){
%>
<p id="result"><%=request.getAttribute("outputTemp") %></p>

<% 	
}
%>

</div>
   </section>
</body>
</html>