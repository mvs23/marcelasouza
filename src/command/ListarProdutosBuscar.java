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

public class ListarProdutosBuscar implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String chave = request.getParameter("data[search]");
		ProdutoService ps = new ProdutoService();
		ArrayList<ProdutoTO> lista = null;
		HttpSession session = request.getSession();
		if (chave != null && chave.length() > 0) {
			lista = ps.listarProdutos(chave);
		} else {
			lista = ps.listarProdutos();
		}
		session.setAttribute("lista", lista);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("ProdutosListar.jsp");
		dispatcher.forward(request, response);
		
	}

}
