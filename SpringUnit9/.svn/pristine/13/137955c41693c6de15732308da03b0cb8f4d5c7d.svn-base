<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<tiles:insertDefinition name="template">
	<tiles:putAttribute name="body">
		<div class="container">
			<h1>Group List</h1>
			<table style="width: 100%" class="table table-inverse">
				<thead>
					<tr>
						<td>Name</td>
						<td colspan="2">#</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td colspan="3">
							<form method="get" action="/group/list">
								<div class="form-group">
									<input type="text" name="q" class="form-control">
								</div>
							</form>
						</td>
					</tr>
					<c:forEach items="${group}" var="item" varStatus="loop">
						<tr>
							<td><a href="/account/list?groupId=${item.id}">${item.name}</a></td>
							<td><a href="/group/delete/${item.id}"><img border="0" src="../resources/image/delete-icon.png"></a></td>
							<td><a href="/group/update?id=${item.id}"><img border="0" src="../resources/image/edit-icon.png"></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>