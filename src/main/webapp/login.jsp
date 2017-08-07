<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<c:if test="${not empty message}">
		<div class="alert alert-success" align="center">${message}</div>
	</c:if>
	<c:if test="${error == false}">
		<div class="alert alert-danger" align="center">${error}</div>
	</c:if>
	<h2 align="center">Login</h2>
	<div class="container" style="width: 400px" align="center">
		<form method="post" action="/login">
			<div class="form-group" align="left">
				<label for="email">Email</label> <input type="email"
					class="form-control" id="email" name="email" required="required">
			</div>

			<div class="form-group" align="left">
				<label for="pwd">Password:</label> <input type="password"
					class="form-control" id="password" name="password"
					required="required">
			</div>

			<button type="submit" class="btn btn-default">Login</button> 
			<a href="/register" class="btn btn-default" role="button" style="margin-left: 30px">	New user </a>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		</form>
	</div>
</body>
</html>