<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>All the Dents in the database</h1>
<ul>
<c:forEach var="product" items="${requestScope.products}">
	<li>${product.id}: ${product.product_id } / ${product.name } / ${product.weight} / ${product.energy}}
</c:forEach>
<br>
<a href="/index.html">
            <button>Takaisin</button>
        </a>
</ul>
</body>
</html>