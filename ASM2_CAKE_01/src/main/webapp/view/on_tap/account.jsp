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
	<form:form action="/ot/account/index" modelAttribute="item">
		<label>USERNAME</label>
		<form:input path="username" type="text" /><br>
		<label>PASSWORD</label>
		<form:input path="password" type="text" /><br>
		<label>FULLNAME</label>
		<form:input path="fullname" type="text" /><br>
		<label>EMAIL</label>
		<form:input path="email" type="text" /><br>
		<label>PHOTO</label>
		<form:input path="photo" /><br>
		<label>ADMIN</label>
		<form:checkbox path="admin" /><br>
		<label>ACTIVATED</label>
		<form:checkbox path="activated"/><br>
		<hr>
		<button formaction="/ot/account/create">Thêm</button>
		<button formaction="/ot/account/update">Cập nhật</button>
		<button formaction="/ot/account/index">Reset</button>
	</form:form>
	<hr>
	<!-- Table -->
	<table class="table" border="1" style="width: 100%">
		<thead>
			<tr>
				<th>username</th>
				<th>password</th>
				<th>fullname</th>
				<th>email</th>
				<th>photo</th>
				<th>admin</th>
				<th>activated</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${items}">
				<tr>
					<td>${item.username}</td>
					<td>${item.password}</td>
					<td>${item.fullname}</td>
					<td>${item.email }</td>
					<td>${item.photo }</td>
					<td>${item.admin }</td>
					<td>${item.activated }</td>
					<td><a href="/ot/account/edit/${item.username}">Edit</a></td>
					<td><a href="/ot/account/delete/${item.username}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>