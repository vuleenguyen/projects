<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Account</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link  rel="stylesheet" href="resources/css/style.css">
</head>
<body>
	<div id="insertAccount">
		<form method="post" action="account">
			<div class="form-group">
				<label for="accountNumber">Account Number:</label> <input type="number"
					class="form-control" id="accountNumber" name="accountNumber" required>
			</div>
			<div class="form-group">
				<label for="customerName">Customer Name:</label> <input type="text"
					class="form-control" id="customerName" name="customerName" required>
			</div>
			<button type="submit" class="btn btn-warning">Add Account</button>
			<a class="btn btn-success"
			href="<c:url value='/account'/>"> Return List Account</a>
		</form>
	</div>
</body>
</html>