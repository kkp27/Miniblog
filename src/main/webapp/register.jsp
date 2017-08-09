<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New user</title>
<style>
.error {
	color: #ff0000;
}
</style>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<c:if test="${not empty error1}">
		<div class="alert alert-danger" align="center">${error1}</div>
	</c:if>
	<div class="container" align="center">
		<h2>Registration</h2>
		<form:form method="post" action="/register" commandName="registration"
			cssClass="form-horizontal">
			<div class="form-group" align="left">
				<div class="col-md-4">
					<label for="email" class="control-label">Email</label>
					<form:input path="email" cssClass="form-control" />
					<form:errors path="email" cssClass="error" />
				</div>
			</div>
			<div class="form-group" align="left">
				<div class="col-md-4">
					<label for="Username" class="control-label">Username</label>
					<form:input path="username" cssClass="form-control" />
					<form:errors path="username" cssClass="error" />
				</div>
			</div>
			<div class="form-group" align="left">
				<div class="col-md-4">
					<label for="Password" class="control-label">Password</label>
					<form:password path="password" cssClass="form-control" />
					<form:errors path="password" cssClass="error" />
				</div>
			</div>
			<div class="form-group" align="left">
				<div class="col-md-4">
					<label for="Confirm Password" class="control-label">Confirm
						Password</label>
					<form:password path="confirmPassword" cssClass="form-control" />
					<form:errors path="confirmPassword" cssClass="error" />
					<c:if test="${not empty error2}">
						<span class="error">${error2}</span>
					</c:if>
				</div>
			</div>
			<button type="submit" class="btn btn-default">Register</button>
			<a href="/login" class="btn btn-default" role="button"
				style="margin-left: 20px">Cancel</a>
		</form:form>
	</div>
</body>
</html>
