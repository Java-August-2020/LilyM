<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<link rel="stylesheet" href="/css/style.css" />
<title>Song Details</title>
</head>
<body>
	
	<div class="showContainer">
		<a class="float-right" href="/songs">Dashboard</a>
		<br/>
		<p>Title:  <c:out value="${song.name}"/></p>
		<p>Artist:   <c:out value="${song.artist}"/></p>
		<p>Rating (1-10):  <c:out value="${song.rating}"/></p>
		
		<form action="/songs/${ song.id }" method="post">
			<input type="hidden" name="_method" value="delete" />
			<input class="btn btn-danger" type="submit" value="Delete" />
		</form>
	</div>
</body>
</html>