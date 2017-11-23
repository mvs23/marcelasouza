package service;

import java.util.ArrayList;

import dao.ProdutoDAO;
import to.ProdutoTO;


public class ProdutoService {
	ProdutoDAO dao;
	
	public ProdutoService() {
		dao = new ProdutoDAO();
	}
	
	public int criar(ProdutoTO to) {
		return dao.incluir(to);
	}
	
	public void atualizar(ProdutoTO to){
		dao.atualizar(to);
	}
	
	public void excluir(int id){
		dao.excluir(id);
	}
	
	public ProdutoTO carregar(int id){
		return dao.carregar(id);
	}

	public ArrayList<ProdutoTO> listarProdutos() {
		return dao.listarProdutos();
	}
	
	public ArrayList<ProdutoTO> listarProdutos(String chave) {
		return dao.listarProdutos(chave);
	}
}
