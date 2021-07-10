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
	<form:form action="/home" modelAttribute="item">
		<label>MSV</label>
		<form:input path="masv" type="text" /><br>
		<label>NAME</label>
		<form:input path="name" type="text" /><br>
		<label>MARK</label>
		<form:input path="mark" type="text" /><br>
		<label>MAJOT</label>
		<form:input path="majot" type="text" />
		<hr>
		<button formaction="/home/create">Thêm</button>
		<button formaction="/home/update">Cập nhật</button>
		<button formaction="/home">Reset</button>
	</form:form>
	<hr>
	<!-- Table -->
	<table class="table" border="1" style="width: 100%">
		<thead>
			<tr>
				<th>masv</th>
				<th>name</th>
				<th>mark</th>
				<th>majot</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${items}">
				<tr>
					<td>${item.masv}</td>
					<td>${item.name}</td>
					<td>${item.mark}</td>
					<td>${item.majot }</td>
					<td><a href="/home/edit/${item.masv}">Edit</a></td>
					<td><a href="/home/delete/${item.masv}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>