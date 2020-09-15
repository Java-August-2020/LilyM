<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<title>Products and Categories</title>
</head>
<body>
	<div class="container">
		<h3><a href="/products/new">Add a Product</a> | <a href="/categories/new">Add a Category</a></h3>
		<hr />
		<h2>All Products</h2>
		
		<table class="table table-hover">
			<tbody>
				<tr>
					<th>Product Name</th>
	 				<th>Description</th>
					<th>Product Price</th>	
				</tr>				
				<c:forEach items="${ products }" var="prod">
					<tr>
						<td><a href="/${ prod.id }">${ prod.name }</a></td>
						<td>${ prod.description}</td>   
						<td>${ prod.price }</td>
					</tr>
			</c:forEach>
			</tbody>
		</table>
		
		<hr />
		<h5><a href="/categories/all">See all Categories</a></h5>		
	</div>
</body>
</html>
