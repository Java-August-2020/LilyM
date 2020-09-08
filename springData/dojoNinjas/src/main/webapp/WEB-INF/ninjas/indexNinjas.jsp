<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<title>All Ninjas</title>
</head>
<body>
<div class="container">
		<h5><a href="/">See all Dojos</a></h5>
		<a href="/ninjas/new">Add Ninja</a>
		<hr />
		<h2>All Ninjas</h2>
		<table class="table table-hover">
			<tbody>
				<tr>
					<th>Ninja Name</th>
	 				<th>Age</th>
					<th>Dojo Name</th>	
				</tr>				
				<c:forEach items="${ ninjas }" var="ninja">
					<tr>
						<td>${ ninja.firstName } ${ ninja.lastName }</td>
						<td>${ ninja.age}</td>   
						<td>${ ninja.dojo.name }</td>
					</tr>
			</c:forEach>
			</tbody>
		</table>
		<%-- ${ninjas}  -test if reading ninjas since <c:forEach not working --%>
	</div>
</body>
</html>