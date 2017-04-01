<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<tiles:insertDefinition name="template">
	<tiles:putAttribute name="body">
		<div class="container">
			<h1>User Detail</h1>
			<div class="form-group detail">UserName: ${user.userName}</div>
			<div class="form-group detail">PassWord: ${user.passWord}</div>
			<div class="form-group detail">Email: ${user.email}</div>
			<div class="form-group detail">Age: ${user.age}</div>
			<div class="form-group detail">Group: ${user.group}</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>