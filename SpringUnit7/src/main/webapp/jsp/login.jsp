<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<tiles:insertDefinition name="template">
	<tiles:putAttribute name="body">
		<h1>Login Page</h1>
		<c:if test="${not empty error}"><p>Wrong name or password</p></c:if>
		<form method="post" action="/j_spring_security_check">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			<p>
				<input type="text" name="username" id="username" placeholder="UserName..." />
			</p>
			<p>
				<input type="password" name="password" id="password" placeholder="PassWord..."/>
			</p>
			<p class="submit">
				<input type="submit" value="Login" name="commit" />
			</p>
		</form>
	</tiles:putAttribute>
</tiles:insertDefinition>