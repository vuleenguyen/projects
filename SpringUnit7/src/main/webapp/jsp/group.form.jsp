<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<tiles:insertDefinition name="template">
	<tiles:putAttribute name="body">
		<div class="container">
			<h1>Add Group</h1>
			<form:form  method="POST" action="/group/save" >
				<div class="form-group">
					<form:input path="name" type="text" name="name" class="form-control"/>
				</div>
				<p class="submit">
					<input type="submit" value="Login" name="commit" class="btn btn-success"/>
				</p>
			</form:form>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>