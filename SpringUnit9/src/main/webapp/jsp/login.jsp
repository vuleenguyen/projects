<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<tiles:insertDefinition name="template">
	<tiles:putAttribute name="body">
		<div class="container">
			<h2>Login Page</h1>
			<c:if test="${not empty error}"><p class="error">Wrong name or password</p></c:if>
<!-- 			<form method="post" action="/j_spring_security_check"> -->
<%-- 				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"> --%>
<!-- 				<div class="form-group"> -->
<!-- 					<label for="username">Username:</label> -->
<!-- 					<input type="text" name="username" id="username" placeholder="UserName..." class="form-control"/> -->
<!-- 				</div> -->
<!-- 				<div class="form-group"> -->
<!-- 					<label for="password">Password:</label> -->
<!-- 					<input type="password" name="password" id="password" placeholder="PassWord..." class="form-control"/> -->
<!-- 				</div> -->
<!-- 				<p class="submit"> -->
<!-- 					<input type="submit" value="Login" name="commit" class="btn btn-success"/> -->
<!-- 				</p> -->
<!-- 			</form> -->
				<form name="facebookSocialloginForm" action="/auth/facebook" method="POST">
				 	<input type="hidden" name="scope" value="public_profile,email,user_about_me,user_birthday">
				 	
				 	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				 	<div class="form-group">
						<label for="username">Username:</label>
						<input type="text" name="username" id="username" placeholder="UserName..." class="form-control"/>
					</div>
					<div class="form-group">
						<label for="password">Password:</label>
						<input type="password" name="password" id="password" placeholder="PassWord..." class="form-control"/>
					</div>
					<p class="submit">
						<input type="submit" value="Login" name="commit" class="btn btn-success"/>
					</p>
				 	
				 	<label class="uiButton uiButtonConfirm" style="" id="loginbutton" for="u_0_q">
				 		<input value="Sign In With FaceBook" tabindex="4" type="submit" id="u_0_q">
				 	</label>
				</form>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>