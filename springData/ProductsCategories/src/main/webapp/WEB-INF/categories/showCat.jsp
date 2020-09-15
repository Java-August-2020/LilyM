<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<link rel="stylesheet" href="css/style.css" />
<title>Show products under a Category</title>
</head>
<body>
<div class="container">
		<h5><a href="/">back to Products</a></h5>
		<hr />
		<h2>Products under Category:  ${ category.name }</h2>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Product Name</th>
					<th>Description</th>	
					<th>Price</th>			
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${ category.products }" var="product">
				<tr>
					<td>${ product.name }</td>
					<td>${ product.description}</td>
					<td>${ product.price }</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>