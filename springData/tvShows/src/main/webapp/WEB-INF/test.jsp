<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

<title>Show users that rated a show</title>
</head>
<body>
<div class="container">
			<a href="viewShows/">back to All Shows</a>  |  <a href="/logout">Logout</a>
		<hr>
		<br/>
		<p>Title:  <c:out value="${show.title}"/></p>
		<p>Network:   <c:out value="${show.network}"/></p>
		<p>Rating (1-5):  <c:out value="${show.rating}"/></p>
		
		<form action="/${ show.id }" method="post">
			<input type="hidden" name="_method" value="delete" />
			<input class="btn btn-danger" type="submit" value="Delete" />
		</form>
	
	
	
	
	
			
<%--  <c:choose>
	<c:when test="${show.rating.rating  != null}">
	<p>You have already rated this show!</p>
	</c:when>
<c:otherwise>

<h3>Add rating to this show</h3>
	<form:form method="POST" action="/newRating/{id}" modelAttribute="rating">
		<form:hidden path="show" value="${show.id}"/>
		
		<%--how can you add the user.id --%>
		
	<%--		<p>
			<form:label path="rating">Rating (1-5): 
			<form:errors path="rating"/>
			<form:input path="rating"/></form:label>
			</p>
			
		<button>Rate it!</button>
	</form:form>
</c:otherwise>
</c:choose> --%>

	
	
	
		
	</div>
</body>
</html>