<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
	<head>
		<title>Spring Unit8 Application</title>
	</head>
	<body>
		<h1>Welcome to Spring Unit8</h1>
		<p><a href="/">Main Page</a></p>
		<tiles:insertAttribute name="body" />
	</body>
</html>