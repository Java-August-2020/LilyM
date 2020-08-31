<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<link rel="stylesheet" href="/css/style.css" />
<title>Programming Languages App</title>
</head>
<body>
	<div class="container">
		<h1>Language Details -${language.name}</h1>
		<hr />
		<p>Language Name: <c:out value="${language.name}"/></p>
		<p>Creator: <c:out value="${language.creator}"/></p>
		<p>Current Version: <c:out value="${language.currentVersion}"/></p>
		<a class="btn btn-primary" href="/${language.id}/edit">Edit</a>
		<a class="btn btn-danger" href="${ language.id }/remove">Delete</a>	
	</div>
</body>
</html>