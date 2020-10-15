<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

<title>Edit TV Shows</title>
</head>
<body>
<div class="container">
		<a href="viewShows/">back to All Shows</a>  |  <a href="/logout">Logout</a>
		<hr>
	
			<hr>
		<h3>Edit  TV Show</h3>
		<form:form method="POST" action="/${show.id}" modelAttribute="show">
		
				<p>
				<form:label path="title">Title:
				<form:errors path="title"/>
				<form:input path="title"/></form:label>
				</p>
				
				<p>
				<form:label path="network">Network:
				<form:errors path="network"/>
				<form:input path="network"/></form:label>
				</p>
				
			<%-- 	<p>
				<form:label path="rating">Rating(1-5):
				<form:errors path="rating"/>
				<form:input path="rating"/></form:label>
				</p>  --%>
				
				<button>Update TV Show</button>
				<hr>
		</form:form>
		
		<a href="/delete/${show.id }">Delete TV Show</a>		
		
	</div>
</body>
</html>