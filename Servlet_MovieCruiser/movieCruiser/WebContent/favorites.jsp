<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style/style.css">
</head>
<body>
	<div class="topnav">
		<div class="home">Movie Cruiser</div>
		<img src="image/moviecruiser-logo.JPG"> <a href="ShowFavorites">Favorites</a> <a
			href="ShowMovielistCustomer">Movie</a>
	</div>
	<h1 class="hed-mla">Favorites</h1>
	<table class="tbl" id="tableID">
		<c:if test="${deleteFavoritesStatus}">
			<div>
				<h2 class="success-message">Items remove from the cart
					successfully</h2>
			</div>
		</c:if>
		<tr>
			<th><h4>Title</h4></th>
			<th><h4>Box office</h4></th>
			<th><h4>Genre</h4></th>
		</tr>
		<c:forEach items="${favorites.movies}" var="movies">
			<tr>
				<td>${movies.title}</td>
				<td class="currency">$.<fmt:formatNumber
						value="${movies.gross}" />
				</td>
				<td>${movies.genre}</td>
				<td><a href="RemoveFavorites?id=${movies.id}">Delete</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td><h4>No. of favorites:${favorites.total}</h4></td>
		</tr>
	</table>

	<div class="footer">
		<h3>Copyright@2019</h3>
	</div>

</body>
</html>