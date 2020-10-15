<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<title>Add a New Show</title>
</head>
<div class="container">
	<a href="/viewShows/">back to All Shows</a>  |  <a href="/logout">Logout</a>
		<hr />
		<h2>Create a new Show</h2>
	
		<form:form action="/addShows" method="post" modelAttribute="show">		
		    <div class="form-group">
		        <form:label path="title">Title</form:label>
		        <form:errors path="title"/>
		        <form:input class="form-control" path="title"/>
		    </div>
		    <div class="form-group">
		        <form:label path="network">Network</form:label>
		        <form:errors path="network"/>
		        <form:input class="form-control" path="network"/>
		    </div>
		   <%--  <div class="form-group">
		        <form:label path="ratingAvg">Rating</form:label>
		        <form:errors path="ratingAvg"/>
		        <form:input class="form-control" path="rating"/>
		    </div>  --%>
		    <button>Create</button>
		</form:form>
	</div>
</body>
</html>