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

public class ListarProdutos implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String chave = request.getParameter("data[search]");
		String acao = request.getParameter("acao");
		ProdutoService ps = new ProdutoService();
		ArrayList<ProdutoTO> lista = null;
		HttpSession session = request.getSession();
		if (acao.equals("buscar")) {
			if (chave != null && chave.length() > 0) {
				lista = ps.listarProdutos(chave);
			} else {
				lista = ps.listarProdutos();
			}
			session.setAttribute("lista", lista);
		} else if (acao.equals("reiniciar")) {
			session.setAttribute("lista", null);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("ProdutosListar.jsp");
		dispatcher.forward(request, response);
	}

}
