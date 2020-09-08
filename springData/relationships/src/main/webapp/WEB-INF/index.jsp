<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<title>Driver's License App</title>
</head>
<body>
	<div class="container">
		<nav>
			<h2><a href="/new">Add Person</a>   -    <a href="/licenses/new">Add License</a></h2>
		</nav>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>License #</th>	
					<th>State</th>	
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${ persons }" var="person">
				<tr>
						<td><a href="/${ person.id }">${ person.firstName}</a></td>
					
					<td>${ person.lastName } </td>
					<td>${ person.license.getNumberAsString() }</td>
					<td>${ person.license.state}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>	
	</div>
</body>
</html>