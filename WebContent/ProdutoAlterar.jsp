<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Alterar Produto</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<c:import url="Menu.jsp"/>
	<div class="container">
		<h3 class="page-header">Alterar Produto #${produto.id}</h3>
		
		<form action="ServletController.do" method="post">
			<input type="hidden" name="id" value="${produto.id}" />
				<div class="row">
				<div class="form-group col-md-6">
					<label>Codigo do Produto</label> 
					<input type="number" class="form-control" name="codProduto" id="codProduto" value="${produto.codProduto}">
				</div>
			</div>
			
			<div class="row">
				<div class="form-group col-md-6">
					<label>Descrição</label> 
					<input type="text" class="form-control" name="descricao" id="descricao" value="${produto.descricao}">
				</div>
			</div>
			
			<div class="row">
				 <div class="form-group col-md-6">
				  	<label>Preço</label> 
	    			<div class="input-group">
	      				<div class="input-group-addon">R$</div>
	      				<input type="text" class="form-control" name="preco" id="preco" value="${produto.preco}">
	    			</div>
	  			 </div>
  			</div>
			
			<div class="row">
				<div class="form-group col-md-6">
					<label>Tipo</label> 
					<input type="text" class="form-control" name="tipo" id="tipo" value="${produto.tipo}">
				</div>
			</div>
			
			<hr/>
			<div id="actions" class="row">
				<div class="col-md-12">
					<button type="submit" class="btn btn-primary" name="acao" value="AlterarProduto">Salvar</button>
                    <a href="ServletController.do?acao=ListarProdutos" class="btn btn-default">Cancelar</a>
				</div>
			</div>
		</form>
	</div>
		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
</body>
</html>