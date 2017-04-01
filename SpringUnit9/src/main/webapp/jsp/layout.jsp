<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
	<head>
		<title>Spring Unit9 Application</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<link rel="stylesheet" href="../resources/css/main.css">
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="container">
			<h1>Welcome to Spring Unit9</h1>
			<p><a href="/">Main Page</a>
			<sec:authorize access="!hasAnyRole('ROLE_USER')">
				<a href="/login" style="margin-left: 30px">Login</a>
			</sec:authorize>
			<sec:authorize access="hasAnyRole('ROLE_USER')">
				<a href="/user" style="margin-left: 30px">User</a>
				<a href="javascript:document.getElementById('logout').submit()" style="margin-left: 30px">Logout</a>
			</sec:authorize>
			</p>
			<form action="/j_spring_security_logout" id="logout" method="post">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			</form>
		</div>
		<tiles:insertAttribute name="body" />
	</body>
</html>