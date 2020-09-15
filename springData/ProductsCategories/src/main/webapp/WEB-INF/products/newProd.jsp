<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<title>Add a New Product</title>
</head>
<div class="container">
		<h2>Add a Product</h2>
		<h6><a href="/">back to Products</a></h6>
		<hr>
		<form:form action="/products" method="post" modelAttribute="product">
			<div class="form-group">
			
		<form:label path="categories">Category Name</form:label>
		        <form:errors path="categories"/> 
		        <form:select class="form-control" path="categories">		        
	     		<c:forEach items="${ categories }" var="categ">
		        <option value=${ categ.id }>${ categ.name }</option>
		        </c:forEach> 
		        </form:select>		        
		       		        
		    </div>
		    <div class="form-group">
		        <form:label path="name">Product Name</form:label>
		        <form:errors path="name"/>
		        <form:input class="form-control" path="name"/>
		    </div>
		    <div class="form-group">
		        <form:label path="description">Description</form:label>
		        <form:errors path="description"/>
		        <form:input class="form-control" path="description"/>
		    </div>
		    <div class="form-group">
		        <form:label path="price">Price</form:label>
		        <form:errors path="price"/>
		        <form:input class="form-control" path="price"/>
		    </div>
		    <button>Add Product</button>
		</form:form>
	</div>
</body>
</html>