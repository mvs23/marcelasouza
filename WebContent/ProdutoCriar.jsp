<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Novo Produto</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<c:import url="Menu.jsp"/>
	<div class="container">
		<h3>Novo Produto</h3>
		<form action="ServletController.do?acao=ManterProdutos" method="post">
		
			<div class="row">
				<div class="form-group col-md-6">
					<label>Codigo do Produto</label> 
					<input type="number" class="form-control" name="codProduto" required>
				</div>
			</div>
			
			<div class="row">
				<div class="form-group col-md-6">
					<label>Descrição</label> 
					<input type="text" class="form-control"  name="descricao" required>
				</div>
			</div>
			
			<div class="row">
				 <div class="form-group col-md-6">
				  	<label>Preço</label> 
	    			<div class="input-group">
	      				<div class="input-group-addon">R$</div>
	      				<input type="text" class="form-control" name="preco" required>
	    			</div>
	  			 </div>
  			</div>
			
			<div class="row">
				<div class="form-group col-md-6">
					<label>Tipo</label> 
					<input type="text" class="form-control" name="tipo" required>
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-12">
					<button type="submit" name="acao" class="btn btn-primary" value="ManterProdutos">Salvar</button>
					<a href="index.jsp" class="btn btn-default">Cancelar</a>
				</div>
			</div>
		</form>
	</div>
		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
</body>
</html>