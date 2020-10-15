<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rate this show</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<div class="container">

	<h2>Rate this Show!</h2>
		<hr>
		<h4>Show:   ${show.title }</h4>		
		<h5>Network:  ${show.network }</h5>
		<hr>
			<a href="/rater/viewShows/">back to All Shows</a>    <a class="float-right" href="/logout">Logout</a>
		<hr>
		
	
 

	<h3>Add rating to this show</h3>
	<form:form method="POST" action="/newRating/{id}" modelAttribute="rating">
		   <form:hidden path="rating" value="${show.id}"/>   
		 <form:hidden path="rating" value="${user.id}"/>   
		 
		<%--how can you add the user.id - need another hidden field??  --%>

 
			<p>
			<form:label path="rating">Rating (1-5): 
			<form:errors path="rating"/>
			<form:input path="rating"/></form:label>
			</p>
			
		<button>Rate it!</button>
	</form:form>  
	

</div>
</body>
</html>