<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<title>All Categories</title>
</head>
<body>
<div class="container">
		<h5><a href="/">See all Products</a></h5>
		<a href="/categories/new">Add Category</a>
		<hr />
		<h2>All Categories</h2>
		
		<ul>
			<c:forEach items="${categories }" var="categ">
				<li><a href="/categories/${ categ.id }">${ categ.name }</a></li>
			</c:forEach>
		</ul>	
			
		<%-- ${ninjas}  -test if reading ninjas since <c:forEach not working --%>
	</div>
</body>
</html>