package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.ProdutoService;
import to.ProdutoTO;

public class ManterProdutos implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String pId = request.getParameter("id");
		String pCodProduto = request.getParameter("codProduto");
		String pDescricao = request.getParameter("descricao");
		String pPreco = request.getParameter("preco");
		String pTipo = request.getParameter("tipo");
		int id = -1;
		try {
			id = Integer.parseInt(pId);
		} catch (NumberFormatException e) {

		}
		
		ProdutoTO produto = new ProdutoTO();
		produto.setId(id);
		produto.setCodProduto(pCodProduto);
		produto.setDescricao(pDescricao);
		produto.setPreco(pPreco);
		produto.setTipo(pTipo);
		ProdutoService ps = new ProdutoService();
		HttpSession session = request.getSession();
		
		ps.criar(produto);
		ArrayList<ProdutoTO> lista = new ArrayList<>();
		lista.add(produto);
		session.setAttribute("lista", lista);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ProdutosListar.jsp");
		dispatcher.forward(request, response);
	}

}
