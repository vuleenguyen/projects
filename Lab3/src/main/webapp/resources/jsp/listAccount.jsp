<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accounts</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h2>Accounts</h2>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Account Number</th>
					<th>Customer Name</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${accounts}" var="account">
					<tr>
						<td><a
							href="<c:url value="/account?action=detail&accountNumber=${account.accountnumber}"/>">${account.accountnumber}</a></td>
						<td>${account.customer.name}</td>
						<td><a class="btn btn-success"
							href="<c:url value="/account?action=deposit&accountNumber=${account.accountnumber}"/>"> Deposit</a></td>
						<td><a class="btn btn-primary"
							href="<c:url value="/account?action=withdraw&accountNumber=${account.accountnumber}"/>"> Withdraw</a></td>
						<td><a class="btn btn-danger"
							href="<c:url value="/account?action=transfer&accountNumber=${account.accountnumber}"/>"> Transfer</a></td>
					</tr>

				</c:forEach>
			</tbody>
		</table>
		<a class="btn btn-success"
			href="<c:url value="/account?action=insert"/>">Add Account</a>
	</div>
</body>
</html>