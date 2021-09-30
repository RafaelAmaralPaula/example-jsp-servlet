<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.rafaelamaral.model.People"%>
<%@ page import="java.util.ArrayList"%>

<%
ArrayList<People> list = (ArrayList<People>) request.getAttribute("peoples");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Course JSP</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<header>
		<nav class="navbar navbar-light bg-light">

			
			<span class="navbar-brand mb-0 h1" style="font-weight: bold;">List
				of People </span>
			<div class="d-grid gap-2 d-md-block">
				<a class="btn btn-danger" href="index.jsp" type="button">Home</a>
				<a class="btn btn-primary" href="form.jsp" type="button">Save</a>
				<a class="btn btn-primary" href="report" type="button">Report</a>
			</div>

		</nav>
	</header>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">Id</th>
				<th scope="col">Name</th>
				<th scope="col">E-mail</th>
				<th scope="col">#</th>
				<th scope="col">#</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (int i = 0; i < list.size(); i++) {
			%>
			<tr>
				<td><%=list.get(i).getId()%></td>
				<td><%=list.get(i).getName()%></td>
				<td><%=list.get(i).getEmail()%></td>
				
				<td><a href="update">Update</a></td>
				<td><a href="javascript:confirmation(<%=list.get(i).getId()%>)">Delete</a></td>
			</tr>

			<%}%>
		</tbody>
	</table>
	<script src="scripts/confirming.js"></script>
</body>
</html>