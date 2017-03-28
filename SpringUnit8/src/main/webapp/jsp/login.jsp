<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<tiles:insertDefinition name="template">
	<tiles:putAttribute name="body">
		<div class="container">
			<h2>Login Page</h1>
			<c:if test="${not empty error}"><p>Wrong name or password</p></c:if>
			<form method="post" action="/j_spring_security_check">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
				<div class="form-group">
					<label for="username">UserName:</label>
					<input type="text" name="username" id="username" placeholder="UserName..." class="form-control"/>
				</div>
				<div class="form-group">
					<label for="password">Password:</label>
					<input type="password" name="password" id="password" placeholder="PassWord..." class="form-control"/>
				</div>
				<p class="submit">
					<input type="submit" value="Login" name="commit" class="btn btn-success"/>
				</p>
			</form>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>