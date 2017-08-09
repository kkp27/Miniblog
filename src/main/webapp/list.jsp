<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div align="right">
			<form method="post" action="/blog/logout">
				<input type="submit" value="Sign Out" class="btn btn-default"
					style="margin-top: 10px" />
			</form>
		</div>
		<c:if test="${not empty welcome}">${welcome}</c:if>
		<a href="/blog/create" class="btn btn-default" role="button">
			Create </a>
		<hr>
		<c:choose>
			<c:when test="${not empty blog}">
				<c:forEach var="blist" items="${blog}">
					<div class="panel panel-default">
						<div class="panel-heading">
							<strong> ${blist.blogTitle} </strong> <br> by
							${blist.blogAuthor} <br> <br>
							<c:out value="Created on:"></c:out>${blist.createdDate}
							<br>
							<c:out value="Last modified on: ">${blist.lastModifiedDate}</c:out>

						</div>
						<div class="panel-body">${blist.blogPost}</div>
						<div>
							<a href="/blog/edit/${blist.blogTitle}"
								style="margin-right: 10px">Edit</a> | <a
								href="/blog/delete/${blist.blogTitle}" style="margin-left: 10px">Delete</a>
						</div>
					</div>
				</c:forEach>
			</c:when>
			<c:when test="${empty welcome}">
       No records !!
    </c:when>
		</c:choose>
	</div>
</body>
</html>