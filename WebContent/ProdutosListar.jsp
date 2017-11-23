<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Lista de Produtos</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<c:import url="Menu.jsp" />
	<div class="container">
	<form action="ServletController.do" method="post">
		<div id="top" class="row">
			<div class="col-md-3">
				<h2>Produtos</h2>
			</div>

			<div class="col-md-6">
				<div class="input-group h2">
					<input name="data[search]" class="form-control" id="search" type="text" placeholder="Pesquisar Produtos (deixe vazio para trazer todos)">
					<span class="input-group-btn">
						<button class="btn btn-primary" type="submit" name="acao" value="ListarProdutosBuscar">
							<span class="glyphicon glyphicon-search"></span>
						</button>
					</span>
				</div>
			</div>
		</div>
	</form>
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
						<input type="hidden" name="id" id="id_excluir" />
						<button type="submit" class="btn btn-primary" name="acao" value="ExcluirProduto">Sim</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal -->

     <c:if test="${not empty lista}">
		<table class="table table-hover">
			<tbody>
				<tr class="active">
					<th>ID</th>
					<th>Codigo do Produto</th>
					<th>Descrição</th>
					<th>Preço</th>
					<th>Tipo</th>
					<th class="actions">Ações</th>
				</tr>
				<c:forEach var="produto" items="${lista}">
					<tr>
						<td><b>${produto.id}</b></td>
						<td>${produto.codProduto}</td>
						<td>${produto.descricao}</td>
						<td>${produto.preco}</td>
						<td>${produto.tipo}</td>
						<td class="actions">
							<a class="btn btn-success btn-sm" href="ServletController.do?acao=VisualizarProduto&id=${produto.id}">Visualizar</a>
                            <a class="btn btn-warning btn-sm" href="ServletController.do?acao=EditarProduto&id=${produto.id}">Editar</a>
							<button id="btn${produto.id}%>" type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#delete-modal" data-produto="${produto.id}">Excluir</button>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	 </c:if>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$("#delete-modal").on('show.bs.modal', function(event) {
			var button = $(event.relatedTarget);
			var recipient = button.data('produto');
			$("#id_excluir").val(recipient);
		});
	</script>
</body>
</html>