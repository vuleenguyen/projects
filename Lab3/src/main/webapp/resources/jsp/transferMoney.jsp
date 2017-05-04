<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transfer Money</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="resources/css/style.css">
</head>
<body>
	<div id="transferMoney">
		<form method="post" action="transfer">
			<div class="form-group">
				<label for="accountNumber">Account Number:</label> <input type="text"
					class="form-control" id="accountNumber" name="accountNumber"
					value="${accountNumber}" readonly>
			</div>
			<div class="form-group">
				<label for="toAccount">Select list:</label> <select class="form-control"
					id="toAccount" name="toAccount">
					<c:forEach items="${accountList}" var="account">
						<option>${account}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="description">Description:</label>
				<textarea rows="5" cols="50" name="description"></textarea>
			</div>
			<div class="form-group">
				<label for="amount">Amount:</label> <input type="number"
					class="form-control" id="amount" name="amount" required>
			</div>
			<input type="submit" value="Transfer Money" class="btn btn-info" />
		</form>
	</div>
</body>
</html>