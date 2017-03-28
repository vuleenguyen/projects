<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<tiles:insertDefinition name="template">
	<tiles:putAttribute name="body">
		<div class="container">
			<h1>Add User</h1>
			<form:form  method="POST" action="/account/save" id="userForm">
				<div class="form-group">
					<form:input id="username" path="userName" type="text" name="username" class="form-control" placeholder="Username..."/>
				</div>
				
				<div class="form-group">
					<form:input path="passWord" type="password" id="password" name="password" class="form-control" placeholder="Password..."/>
				</div>
				
				<div class="form-group">
					<form:input path="email" type="email" name="email" class="form-control" placeholder="Email..."/>
				</div>	
							
				<div class="form-group">
					<form:input path="age" type="text" name="age" class="form-control" placeholder="Age..."/>
				</div>				
				<div class="form-group">
					<form:select path="groupToInput" id="group" name="group" class="form-control">
						<form:options items="${group}"/>
					</form:select>
				</div>								
				<p class="submit">
					<input type="submit" value="Add" name="commit" class="btn btn-success"/>
				</p>
			</form:form>
		</div>
		<script>
			$(document).ready(function() {
				document.getElementById('userForm').reset();
			});
		</script>
	</tiles:putAttribute>
</tiles:insertDefinition>