<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>This is my Human experience</title>
</head>
<body>
<%-- <h1>Hello Ninja ${now}</h1> this prints the right now line--%>	
	<%--To test http://http://localhost:8080/?firstname=Lily or http://localhost:8080/ --%>
	<h1>Welcome, <c:out value="${savedName}"/></h1>	

</body>
</html>