<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<tiles:insertDefinition name="template">
	<tiles:putAttribute name="body">
		<div class="container">
			<h1>User List</h1>
			<table style="width: 100%" class="table table-inverse">
				<thead>
					<tr>
						<td>#</td>
						<td>Name</td>
						<td>Email</td>
						<td>Age</td>
						<td></td>
						<td></td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${users}" var="item" varStatus="loop">
						<tr>
							<td>${loop.count}</td>
							<td><a href="/account/detail?username=${item.userName}">${item.userName}</a></td>
							<td>${item.email}</td>
							<td>${item.age}</td>
							<td><a href="/group/delete/${item.userName}"><img border="0" src="../resources/image/delete-icon.png"></a></td>
							<td><a href="/group/update?id=${item.userName}"><img border="0" src="../resources/image/edit-icon.png"></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>