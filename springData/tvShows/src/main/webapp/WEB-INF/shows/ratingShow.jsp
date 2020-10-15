<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<title>Users who rated this Show</title>
</head>
<body>
	<div class="container">
	
		<h2>Show:   ${show.title }</h2>		
		<h3>Network:  ${show.network }</h3>
		<hr>
			<a href="viewShows/">back to All Shows</a>    <a class="float-right" href="/logout">Logout</a>
		<hr>
		
		<h4>Users who rated this TV Show</h4>	
	
		<table class="table table-hover">
			<tbody>
				<tr>
					<th>Rated by  User</th>
	 				<th>Rating</th>			
				</tr>		
					<c:forEach items="${ratings}" var="rating">
					<tr>
    					<%-- rater is from User model to mappedBy to Rating model	--%>
						 <td>${rating.rater.firstName}  ${rating.rater.lastName} </td>
						<td>${rating.rating}</td>		
							<td> ${rating.rater.id}  </td>			
					</tr>
					</c:forEach>		
			</tbody>
		</table>
		
		
		<hr />			
			<%-- 	<h5><a href="/{id}">Edit Show</a> </h5>  --%>
		<h5><a href="/${ show.id }">Edit Show</a> </h5>
	<hr>		
	
<%--
		<p>${user.id}</p>			
		<p>${show.ratings.contains(user)}</p>
		<p>hello - testing if I reach this point</p>
		<hr>	
		<c:if test = "${show.ratings.contains(user)}">
         <p>You already rated this show><p>
	      </c:if>
 --%>	
 <c:out value="${user.id }" ></c:out>
 
	 <c:choose>
				<%--  <c:when test="${show.ratings.rater.id  == userID}">  --%>
		<c:when test="${show.ratings.contains(user)}">
		<p>You have already rated this show!</p>
		</c:when>
		<c:otherwise>		
		<a href="/displayToAddRating/${ show.id }"><button> Rate This Show! </button></a>
		</c:otherwise>
	</c:choose> 
 
	</div>
</body>
</html>
