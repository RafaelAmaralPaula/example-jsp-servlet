<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.rafaelamaral.model.People"%>
<%@ page import="java.util.ArrayList"%>

<%
	ArrayList<People> list = (ArrayList<People>)request.getAttribute("peoples");
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
	<div class="container" style="margin-top: 150px;" >
            <div class="jumbotron">
                <h1>Course JSP & Servlet</h1>
                <p class="lead">Analise o desempenho das suas vendas por diferentes perspectivas</p>
                <hr/>
                <p>Esta aplicação consiste em exibir um dashboard a partir de dados fornecidos por um back end construído com Spring Boot.</p>
                <a class="btn btn-primary btn-lg" href="main">
                    Access Peoples
                </a>
           </div>
        </div>
</body>
</html>