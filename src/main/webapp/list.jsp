<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List</title>
<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<a href="/blog/create"> Create content </a>
		<hr>
		<c:choose>
			<c:when test="${not empty blog}">
				<c:forEach var="blist" items="${blog}">
					<div class="panel panel-default">
						<div class="panel-heading"> <strong> ${blist.blogTitle} </strong> by  ${blist.blogAuthor} </div>
						<div class="panel-body">${blist.blogPost}</div>
						<div>
							<a href="#">Edit</a> | <a href="/blog/delete/${blist.blogTitle}">Delete</a>
						</div>
					</div>
				</c:forEach>
			</c:when>
			<c:otherwise>
       No records !!
    </c:otherwise>
		</c:choose>
	</div>
</body>
</html>