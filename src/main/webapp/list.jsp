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
				<input type="submit" value="Sign Out" class="btn btn-default" style="margin-top: 10px"/>
			</form>
		</div>
		<a href="/blog/create" class="btn btn-default" role="button"> Create content </a>
		<!-- <a
			href="/blog/logout" class="btn btn-default" role="button"
			"> Logout </a> -->
		<hr>
		<c:choose>
			<c:when test="${not empty blog}">
				<c:forEach var="blist" items="${blog}">
					<div class="panel panel-default">
						<div class="panel-heading">
							<strong> ${blist.blogTitle} </strong> by ${blist.blogAuthor}
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
			<c:otherwise>
       No records !!
    </c:otherwise>
		</c:choose>
	</div>
</body>
</html>