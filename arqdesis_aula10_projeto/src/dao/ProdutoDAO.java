package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import to.ProdutoTO;

public class ProdutoDAO {
	public int incluir(ProdutoTO to) {
		String sqlInsert = "INSERT INTO PRODUTOS (cod_produto, descricao, tipo, preco) VALUES (?, ?, ?, ?)";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, to.getCodProduto());
			stm.setString(2, to.getDescricao());
			stm.setString(3, to.getTipo());
			stm.setString(4, to.getPreco());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); 
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					to.setId(rs.getInt(1));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return to.getId();
	}

	public void atualizar(ProdutoTO to) {
		String sqlUpdate = "UPDATE produtos SET cod_produto = ?, descricao = ?, tipo = ?, preco = ? WHERE id = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, to.getCodProduto());
			stm.setString(2, to.getDescricao());
			stm.setString(3, to.getTipo());
			stm.setString(4, to.getPreco());
			stm.setInt(5, to.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(int id) {
		String sqlDelete = "DELETE FROM produtos WHERE id = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ProdutoTO carregar(int id) {
		ProdutoTO to = new ProdutoTO();
		to.setId(id);
		String sqlSelect = "SELECT cod_produto, descricao, tipo, preco FROM produtos WHERE id = ?";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, to.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					to.setCodProduto(rs.getString("cod_produto"));
					to.setDescricao(rs.getString("descricao"));
					to.setTipo(rs.getString("tipo"));
					to.setPreco(rs.getString("preco"));
				} else {
					to.setId(-1);
					to.setCodProduto(null);
					to.setDescricao(null);
					to.setTipo(null);
					to.setPreco(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return to;
	}

	public ArrayList<ProdutoTO> listarProdutos() {
		ProdutoTO to;
		ArrayList<ProdutoTO> lista = new ArrayList<>();
		String sqlSelect = "SELECT id, cod_produto, descricao, tipo, preco FROM produtos";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				
				while (rs.next()) {
					to = new ProdutoTO();
					to.setId(rs.getInt("id"));
					to.setCodProduto(rs.getString("cod_produto"));
					to.setDescricao(rs.getString("descricao"));
					to.setTipo(rs.getString("tipo"));
					to.setPreco(rs.getString("preco"));
					lista.add(to);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.println(e1.getStackTrace());
		}
		return lista;
	}

	public ArrayList<ProdutoTO> listarProdutos(String chave) {
		ProdutoTO to;
		ArrayList<ProdutoTO> lista = new ArrayList<>();
		String sqlSelect = "SELECT id, cod_produto, descricao, tipo, preco FROM produtos where upper(descricao) like ?";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					to = new ProdutoTO();
					to.setId(rs.getInt("id"));
					to.setCodProduto(rs.getString("cod_produto"));
					to.setDescricao(rs.getString("descricao"));
					to.setTipo(rs.getString("tipo"));
					to.setPreco(rs.getString("preco"));
					lista.add(to);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.println(e1.getStackTrace());
		}
		return lista;
	}
}
