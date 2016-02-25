package app.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import app.mvc.model.ConnectionFactory;
import app.mvc.model.Item;
import app.mvc.model.Produto;

public class ProdutoDAO extends DAO<Produto> {

	public void add(Produto prod) {
		String sql = "insert into encprod (c_nomeprod, n_qtdprod, c_descricaoprod) values (?, ?, ?)";

		try {
			PreparedStatement pstm = super.connection.prepareStatement(sql);

			pstm.setString(1, prod.getNome());
			pstm.setInt(2, prod.getQuantidade());
			pstm.setString(3, prod.getDescricao());

			pstm.execute();

			pstm.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(int id) {

		String sql = "delete from encprod where id = ?";

		try {
			PreparedStatement pstm = this.connection.prepareStatement(sql);

			pstm.setInt(1, id);

			pstm.execute();

			pstm.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(Produto prod) {
		String sql = "update encprod set c_nomeprod = ?, n_qtdprod  = ?, c_descricaoprod = ? where id = ?";

		try {
			PreparedStatement pstm = this.connection.prepareStatement(sql);

			pstm.setString(1, prod.getNome());
			pstm.setInt(2, prod.getQuantidade());
			pstm.setString(3, prod.getDescricao());
			pstm.setInt(4, prod.getId());

			pstm.execute();

			pstm.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Produto> list() {
		ArrayList<Produto> produtos = new ArrayList<>();

		String sql = "select * from encprod";

		try {
			PreparedStatement pstm = this.connection.prepareStatement(sql);

			ResultSet resultSet = pstm.executeQuery();

			while (resultSet.next()) {
				produtos.add(dataFactory(resultSet));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return produtos;
	}

	@Override
	public Produto get(int id) {
		Produto prod = null;
		String sql = "select * from encprod where id = ?";

		try {
			PreparedStatement pstm = this.connection.prepareStatement(sql);

			pstm.setInt(1, id);

			ResultSet result = pstm.executeQuery();
			if (result.next()) {
				prod = dataFactory(result);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return prod;
	}
	
	public Produto get(int id, Item item){
		
		Produto prod = null;
		String sql = "select * from encprod where id = ?";

		try {
			PreparedStatement pstm = this.connection.prepareStatement(sql);

			pstm.setInt(1, id);

			ResultSet result = pstm.executeQuery();
			if (result.next()) {
				prod = dataFactory(result);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return prod;
	}

	@Override
	protected Produto dataFactory(ResultSet row) throws SQLException {
		Produto prod = new Produto();

		prod.setId(row.getInt("id"));
		prod.setNome(row.getString("c_nomeprod"));
		prod.setQuantidade(row.getInt("n_qtdprod"));
		prod.setDescricao(row.getString("c_descricaoprod"));

		return prod;
	}
}
