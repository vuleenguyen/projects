<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<tilte>Spring Boot Application</tilte>
	</head>
	<style>
		.error {
			color: red;
		}
	</style>
	<body>
		<table border="1" cellpadding="2" cellspacing="2" align="center">
			<tr>
				<td height="30">
					Welcome to Java Spring class
				</td>
			</tr>
			<tr>
				<td>
					<a href="/">Main Page</a>
					<sec:authorize access="!hasRole('USER')">
						<a href="/login" style="margin-left:30px">Login</a>
					</sec:authorize>
					<sec:authorize access="hasRole('USER')">
						<a href="/user" style="margin-left:30px">Individual</a>
						<a href="/logout" style="margin-left:30px">Logout</a>
					</sec:authorize>
				</td>
			</tr>
			<tr>
				<td><tiles:insertAttribute name="body" /></td>
			</tr>		
		</table>
	</body>
</html>