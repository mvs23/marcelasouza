package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ManterProdutosReiniciar implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession session = request.getSession();
		session.setAttribute("lista", null);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("ProdutoCriar.jsp");
		dispatcher.forward(request, response);
		
	}

}
