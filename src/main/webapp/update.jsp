<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update People</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous" />

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
</head>
<body>
	<header>
		<nav class="navbar navbar-light bg-light">
			<span class="navbar-brand mb-0 h1" style="font-weight: bold;">Cadastro
				Vendedor </span><a href="main" class="btn btn-primary" role="button">Voltar
				para tela inicial</a>
		</nav>
	</header>

	<form name="form" action="update"
		class="row gy-2 gx-3 align-items-center"
		style="padding-left: 90px; padding-top: 70px;">

		<div class="col-sm-1">
			<label class="visually-hidden" for="autoSizingInput">Id</label> <input
				type="text" class="form-control" id="autoSizingInput" name="id"
				readonly="readonly" value="<%out.print(request.getAttribute("id"));%>">
		</div>


		<div class="col-sm-5">
			<label class="visually-hidden" for="autoSizingInput">Name</label> <input
				type="text" class="form-control" id="autoSizingInput" required="required"
				 name="name" value="<%out.print(request.getAttribute("name"));%>">
		</div>

		<div class="col-sm-3">
			<label class="visually-hidden" for="autoSizingInputGroup">E-mail</label>
			<div class="input-group">
				<div class="input-group-text">Email</div>
				<input type="text" class="form-control" id="autoSizingInputGroup" name="email"
				 required="required" value="<%out.print(request.getAttribute("email"));%>"/>
			</div>
		</div>
		<button type="submit" onclick="validar()" class="btn btn-primary"
			style="margin-top: 10px; margin-right: 84%; width: 20%;">Save</button>
	</form>

	<script src="scripts/validation.js"></script>


	<footer> </footer>

</body>
</html>