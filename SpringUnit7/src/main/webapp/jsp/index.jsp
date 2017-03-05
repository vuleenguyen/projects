<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<tiles:insertDefinition name="template">
	<tiles:putAttribute name="body">
		<div class="container">
			<h2>${message}</h2>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>