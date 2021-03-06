<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<link rel="stylesheet" href="css/style.css" />
<title>Lookify App</title>
</head>
<body>
	<div class="container">
		<nav>
			<h3><a href="/songs/new">Add New</a>      -        <a href="/songs/topTen">Top Ten</a></h3>
			<form action="/songs/search" class="float-right">
				<input type="text" name="artist"/>
				<button class="btn btn-primary">Search Artists</button>
			</form>
		</nav>
		<table class="table table-hover">
				 <thead>
						<tr>
							<th>Name</th>
							<th>Artist</th>
							<th>Rating</th>
							<th>Action</th>
						</tr>
					</thead> 
			<tbody>
			<c:forEach items="${ songs }" var="song">
				<tr>
					<td><a href="/songs/${ song.id }">${ song.name }</a></td>
					<td>${ song.artist }</td>
					<td>${ song.rating }</td>
					<td><a class="btn btn-danger" href="/songs/${ song.id }">Delete</a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
