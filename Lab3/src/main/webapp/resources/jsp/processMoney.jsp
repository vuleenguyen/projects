<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Process Money</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="resources/css/style.css">
</head>
<body>
	<div id="processMoney">
		<c:choose>
			<c:when test="${deposit == true}">
				<form action="deposit" method="post">
					<h3>Deposit Money</h3>
					<div id="processMoney">
						<div class="form-group">
							<label for="accountNumber">Account Number:</label> <input
								type="text" class="form-control" id="accountNumber"
								name="accountNumber" value="${accountNumber}" readonly>
						</div>
						<div class="form-group">
							<label><input type="radio" name="processType" value="dollar" />Dollar</label>
							<label><input type="radio" name="processType" value="euro" />Euro</label>
						</div>
						<div class="form-group">
							<label for="amount">Amount:</label> <input type="number"
								class="form-control" id="amount" name="amount" required>
						</div>
						<input type="submit" value="Deposit Money" class="btn btn-info" />
					</div>
				</form>
			</c:when>
			<c:otherwise>
				<form action="withdraw" method="post">
					<h3>Withdraw Money</h3>
					<div id="processMoney">
						<div class="form-group">
							<label for="accountNumber">Account Number:</label> <input
								type="text" class="form-control" id="accountNumber"
								name="accountNumber" value="${accountNumber}" readonly>
						</div>
						<div class="form-group">
							<label><input type="radio" name="processType" value="dollar" />Dollar</label>
							<label><input type="radio" name="processType" value="euro" />Euro</label>
						</div>
						<div class="form-group">
							<label for="amount">Amount:</label> <input type="number"
								class="form-control" id="amount" name="amount" required>
						</div>
						<input type="submit" value="Withdraw Money" class="btn btn-info" />
					</div>
				</form>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>