<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Visualizar Produto</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<c:import url="Menu.jsp"/>
	<div class="container">
	
		<!-- Modal -->
	<div class="modal fade" id="delete-modal" role="dialog">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Excluir Produto</h4>
				</div>
				<div class="modal-body">
					<p>Deseja realmente excluir este Produto?</p>
				</div>
				<div class="modal-footer">
					<form action="ServletController.do" method="post">
						<input type="hidden" name="id" value="${produto.id}" />
						<button type="submit" class="btn btn-primary" name="acao" value="ExcluirProduto">Sim</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal -->
		<h3 class="page-header">Visualizar Produto #${produto.id}</h3>
		<fieldset disabled>
				<div class="row">
				<div class="form-group col-md-6">
					<label>Codigo do Produto</label> 
					<input type="number" class="form-control" name="codProduto" value="${produto.codProduto}">
				</div>
			</div>
			
			<div class="row">
				<div class="form-group col-md-6">
					<label>Descrição</label> 
					<input type="text" class="form-control"  name="descricao" value="${produto.descricao}">
				</div>
			</div>
			
			<div class="row">
				 <div class="form-group col-md-6">
				  	<label>Preço</label> 
	    			<div class="input-group">
	      				<div class="input-group-addon">R$</div>
	      				<input type="text" class="form-control" name="preco" value="${produto.preco}">
	    			</div>
	  			 </div>
  			</div>
			
			<div class="row">
				<div class="form-group col-md-6">
					<label>Tipo</label> 
					<input type="text" class="form-control" name="tipo" value="${produto.tipo}">
				</div>
			</div>
		</fieldset>
		
		<div id="actions" class="row">
			<div class="col-md-12">
				<a href="ServletController.do?acao=EditarProduto&id=${produto.id}" class="btn btn-primary">Editar</a>
				<a href="#" class="btn btn-danger" data-toggle="modal" data-target="#delete-modal">Excluir</a>
				<a href="ServletController.do?acao=ListarProdutos" class="btn btn-default">Voltar</a>
			</div>
		</div>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
</body>
</html>