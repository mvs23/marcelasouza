package model;

import dao.ProdutoDAO;
import to.ProdutoTO;

public class Produto {
	private int id;
	private String codProduto;
	private String descricao;
	private String tipo;
	private String preco;

	public Produto(int id, String codProduto, String descricao, String tipo, String preco) {
		this.id = id;
		this.codProduto = codProduto;
		this.descricao = descricao;
		this.tipo = tipo;
		this.preco = preco;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCodProduto() {
		return codProduto;
	}
	
	public void setCodProduto(String codProduto) {
		this.codProduto = codProduto;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getPreco() {
		return preco;
	}
	
	public void setPreco(String preco) {
		this.preco = preco;
	}
	
	public ProdutoTO getTO() {
		ProdutoTO to = new ProdutoTO();
		to.setId(id);
		to.setCodProduto(codProduto);
		to.setDescricao(descricao);
		to.setTipo(tipo);
		to.setPreco(preco);
		return to;
	}
	
	public void criar() {
		ProdutoDAO dao = new ProdutoDAO();
		ProdutoTO to = getTO();
		dao.incluir(to);
		this.id = to.getId();
	}
	
	public void atualizar() {
		ProdutoDAO dao = new ProdutoDAO();
		ProdutoTO to = getTO();
		dao.atualizar(to);
	}
	
	public void excluir(int id) {
		ProdutoDAO dao = new ProdutoDAO();
		ProdutoTO to = new ProdutoTO();
		to.setId(id);
		dao.excluir(id);
	}
	
	public void carregar(int id) {
		ProdutoDAO dao = new ProdutoDAO();
		ProdutoTO to = dao.carregar(id);
		codProduto = to.getCodProduto();
		descricao = to.getDescricao();
		tipo = to.getTipo();
		preco = to.getPreco();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (codProduto == null) {
			if (other.codProduto != null)
				return false;
		} else if (!codProduto.equals(other.codProduto))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id != other.id)
			return false;
		if (preco == null) {
			if (other.preco != null)
				return false;
		} else if (!preco.equals(other.preco))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}
}
