<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<tiles:insertDefinition name="template">
	<tiles:putAttribute name="body">
		<div class="container">
			<h1>User List</h1>
			<c:if test="${not empty error}">
				<div class="form-group error">
					${error}
				</div>
			</c:if>
			<form action="/account/list" method="get">
				<div class="form-group">
					<input type="text" class="form-control" name="q" placeHolder="Age Filter..." style="width: 20% !important; display: inline"/>
					<button type="submit" value="find" name="commit" class="btn btn-danger" style="border-radius: 40px; font-size: 21px !important;">
						<span class="glyphicon glyphicon-search"></span>
					</button>
				</div>
			</form>
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
							<td><a href="/account/delete/${item.userName}"><img border="0" src="../resources/image/delete-icon.png"></a></td>
							<td><a href="/account/update?userName=${item.userName}"><img border="0" src="../resources/image/edit-icon.png"></a></td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="6" style="font-weight: bold">
							${average}
						</td>
					</tr>
				</tbody>
			</table>
			<div class="form-group" style="text-align: center;">
				<ul class="pagination">
					<c:forEach begin="1" end="${pagination}" varStatus="loop">
						<li>
							<c:url var="nextUrl" value="">
								<c:forEach items="${param}" var="entry">
								    <c:if test="${entry.key != 'page'}">
								        <c:param name="${entry.key}" value="${entry.value}" />
								    </c:if>
								</c:forEach>
								<c:param name="page" value="${loop.index}" />
							</c:url>
							<a href="${nextUrl}">${loop.index}
							</a>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>