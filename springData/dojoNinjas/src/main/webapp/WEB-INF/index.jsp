<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<link rel="stylesheet" href="css/style.css" />
<title>All Dojos</title>
</head>
<body>
	<div class="container">
	<h2>All Dojos</h2>
	<h6><a href="/dojos/new">Add a new Dojo</a></h6>
	<a href="/ninjas/new">Add a Ninja</a>
	<hr />
		<ul>
		<c:forEach items="${ dojos }" var="dojo">
			<li><a href="/${ dojo.id }">${ dojo.name }</a></li>
		</c:forEach>
		</ul>	
		<hr />
		<h5><a href="/ninjas/all">See all Ninjas</a></h5>	
	</div>
</body>
</html>