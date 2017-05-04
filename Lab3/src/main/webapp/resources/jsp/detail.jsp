<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Account Detail</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	  	<link  rel="stylesheet" href="resources/css/style.css">
	</head>
<body>
	<div id="detail">
		<div class="container">
			<h2>Account Detail</h2>
			<div class="form-group">
				<label for="accountNumber">Account Number: <span>${account.accountnumber}</span></label> 
			</div>
			<div class="form-group">
				<label for="customerName">Customer Name: <span>${account.customer.name}</span></label>
			</div>
			<h4>Account Entries</h4>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Date</th>
						<th>Amount</th>
						<th>Description</th>
						<th>FromAccountNumber</th>
						<th>FromPersonName</th>
					</tr>
					
				</thead>
				<tbody>
					<c:forEach items="${account.entryList}" var="entry">
						<tr>
							<td>${entry.date}</td>
							<td>${entry.amount}</td>
							<td>${entry.description}</td>
							<td>${entry.fromAccountNumber}</td>
							<td>${entry.fromPersonName}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a class="btn btn-success"
				href="<c:url value="/account"/>">Return List Account</a>
		</div>
	</div>
</body>
</html>