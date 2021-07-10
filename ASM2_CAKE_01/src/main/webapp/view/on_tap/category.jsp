<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- Form -->
	<form:form action="/ot/categories/index" modelAttribute="item">
		<label>ID</label>
		<form:input path="id" type="text" /><br>
		<label>NAME</label>
		<form:input path="name" type="text" /><br>
		<hr>
		<button formaction="/ot/categories/create">Thêm</button>
		<button formaction="/ot/categories/update">Cập nhật</button>
		<button formaction="/ot/categories/index">Reset</button>
	</form:form>
	<hr>
	<!-- Table -->
	<table class="table" border="1" style="width: 100%">
		<thead>
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${items}">
				<tr>
					<td>${item.id}</td>
					<td>${item.name}</td>
					<td><a href="/ot/categories/edit/${item.id}">Edit</a></td>
					<td><a href="/ot/categories/delete/${item.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>