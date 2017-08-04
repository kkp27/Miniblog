<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit</title>
</head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h2>Edit content</h2>
		<hr>
		<c:forEach var="blist" items="${blog}">
			<form method="post" action="/blog/update">
				<div class="form-group">
					<label for="title">Title</label> <input type="text"
						class="form-control" id="blogTitle" name="blogTitle"
						value="${blist.blogTitle}" required="required">
				</div>
				<div class="form-group">
					<label for="author">Author</label> <input type="text"
						class="form-control" id="blogAuthor" name="blogAuthor"
						value="${blist.blogAuthor}" required="required">
				</div>
				<div class="form-group">
					<label for="content">Post</label>
					<div contenteditable="true" style="height: 200px" class="form-control"> ${blist.blogPost} </div>
				</div>
				<button type="submit" class="btn btn-default">Edit</button>
				<a href="/blog/list" class="btn btn-default" role="button">Cancel</a>
			</form>
		</c:forEach>
	</div>
</body>
</html>