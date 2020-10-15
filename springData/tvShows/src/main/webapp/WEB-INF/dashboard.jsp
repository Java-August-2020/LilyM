<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<title>TV Shows</title>
</head>
<body>
	<div class="container">
		<a class="float-right" href="/logout">Logout</a>
	
		<h2>Welcome  ${user.firstName } ${user.lastName }</h2>	
		<h4>TV Shows</h4>	
	
		<table class="table table-hover">
			<tbody>
				<tr>
					<th>Show</th>
	 				<th>Network</th>
					<th>Avg Rating</th>	
				</tr>				
				<c:forEach items="${ shows }" var="sw">
					<tr>
						<td><a href="/rater/${ sw.id }">${ sw.title }</a></td>
						<td>${ sw.network}</td>   
								<%--  how to calculate an average rating  <td>${ sw.rating }</td> --%>
					</tr>
			</c:forEach>
			</tbody>
		</table>
		
		<hr />
		<h3><a href="/shows/new">Add a Show</a> </h3>
	</div>
</body>
</html>
