<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Create</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h2>Create content</h2>
		<form method="post" action="/blog/save">
			<div class="form-group">
				<label for="title">Title</label> <input type="text"
					class="form-control" id="blogTitle" name="blogTitle" required="required">
			</div>
			<div class="form-group">
				<label for="author">Author</label> <input type="text"
					class="form-control" id="blogAuthor" name="blogAuthor" required="required">
			</div>
			<div class="form-group">
				<label for="content">Post</label>
				<textarea class="form-control" rows="10" id="blogPost" name="blogPost" required="required"></textarea>
			</div>
			<button type="submit" class="btn btn-default">Submit</button>
			<a href="http://localhost:8080/blog/list" class="btn btn-default" role="button">Cancel</a>
		</form>
	</div>
</body>
</html>