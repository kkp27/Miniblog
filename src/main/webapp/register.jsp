<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New user</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="${pageContext.request.contextPath}/js/validate.js"></script>
</head>
<body>
	<c:if test="${not empty error}">
		<div class="alert alert-danger" align="center">${error}</div>
	</c:if>
	<h2 align="center">Registration</h2>
	<div class="container" style="width: 400px" align="center">
		<form method="post" action="/register">
			<div class="form-group" align="left">
				<label for="email">Email</label> <input type="email"
					class="form-control input-sm" id="email" name="email"
					required="required">
			</div>
			<div class="form-group" align="left">
				<label for="userame">Name</label> <input type="text"
					class="form-control input-sm" id="username" name="username"
					required="required">
			</div>
			<div class="form-group" align="left">
				<label for="password">Password</label> <input type="password"
					class="form-control input-sm" id="password" name="password"
					required="required">
			</div>
			<div class="form-group" align="left">
				<label for="confirmPassowrd">Confirm Password</label> <input
					type="password" class="form-control input-sm" id="confirmPassword"
					name="confirmPassowrd" required="required"
					onblur="return check();"> <span id="msg"></span>
			</div>
			<button type="submit" class="btn btn-default">Register</button>
			<a href="/login" class="btn btn-default" role="button" style="margin-left: 30px">Cancel</a>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		</form>
	</div>
</body>
</html>
