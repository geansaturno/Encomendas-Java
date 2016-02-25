package app.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import app.mvc.model.Encomenda;
import app.mvc.model.Item;
import app.mvc.model.Produto;

public class ItemDAO extends DAO<Item> {

	public void add(Item item) {

		String sql = "insert into encitem (encprod_id, encenc_id, n_qtditem) values (?, ?, ?)";

		try {
			PreparedStatement pstm = super.connection.prepareStatement(sql);

			pstm.setInt(1, item.getProduto().getId());
			pstm.setInt(2, item.getEncomenda().getId());
			pstm.setInt(3, item.getQuantidade());

			pstm.execute();

			pstm.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Item> listItensProduto(Produto prod) {
		ArrayList<Item> itens = new ArrayList<Item>();

		String sql = "select * from encitem where encprod_id = ?";

		try {
			PreparedStatement pstm = super.connection.prepareStatement(sql);

			pstm.setInt(1, prod.getId());

			ResultSet rset = pstm.executeQuery();

			while (rset.next()) {

				Item item = dataFactory(rset);

				item.setProduto(prod);

				int encomendaId = rset.getInt("encenc_id");

				for (Item itemAnterior : itens) {
					if (itemAnterior.getEncomenda().getId() == encomendaId)
						item.setEncomenda(itemAnterior.getEncomenda());
				}

				if (item.getEncomenda() == null)
					item.setEncomenda(new EncomendaDAO().get(encomendaId));

				itens.add(item);

			}

			pstm.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return itens;
	}

	public ArrayList<Item> listItensEncomenda(Encomenda enc) {

		ArrayList<Item> itens = new ArrayList<>();

		String sql = "select * from encitem where encenc_id = ?";

		try {
			PreparedStatement pstm = super.connection.prepareStatement(sql);

			pstm.setInt(1, enc.getId());

			ResultSet rset = pstm.executeQuery();

			while (rset.next()) {

				Item item = dataFactory(rset);

				int produtoId = rset.getInt("encprod_id");

				for (Item itemAnterior : itens) {
					if (itemAnterior.getProduto().getId() == produtoId)
						item.setProduto(itemAnterior.getProduto());
				}

				if (item.getProduto() == null)
					item.setProduto(new ProdutoDAO().get(produtoId));

				item.setEncomenda(enc);

				itens.add(item);

			}

			pstm.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return itens;

	}

	@Override
	public ArrayList<Item> list() {
		ArrayList<Item> itens = new ArrayList<>();

		String sql = "select * from encitem";

		try {
			PreparedStatement pstm = super.connection.prepareStatement(sql);

			ResultSet rset = pstm.executeQuery();

			while (rset.next()) {

				Item item = dataFactory(rset);

				int produtoId = rset.getInt("encprod_id");
				int encomendaId = rset.getInt("encenc_id");

				for (Item itemAnterior : itens) {
					if (produtoId == itemAnterior.getProduto().getId())
						item.setProduto(itemAnterior.getProduto());

					if (encomendaId == itemAnterior.getEncomenda().getId())
						item.setEncomenda(itemAnterior.getEncomenda());
				}

				if (item.getEncomenda() == null)
					item.setEncomenda(new EncomendaDAO().get(encomendaId));

				if (item.getProduto() == null)
					item.setProduto(new ProdutoDAO().get(produtoId));

				itens.add(item);

			}

			pstm.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return itens;
	}

	@Override
	public Item get(int id) {
		Item item = null;

		String sql = "select* from encitem where id = ?";

		try {
			PreparedStatement pstm = super.connection.prepareStatement(sql);

			pstm.setInt(1, id);

			ResultSet rset = pstm.executeQuery();

			if (rset.next()) {
				item = dataFactory(rset);

				int encomendaId = rset.getInt("encenc_id");
				int produtoId = rset.getInt("encprod_id");

				item.setEncomenda(new EncomendaDAO().get(encomendaId));
				item.setProduto(new ProdutoDAO().get(produtoId));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return item;
	}

	@Override
	public void delete(int id) {
		String sql = "delete from encitem where id = ?";

		try {
			PreparedStatement pstm = super.connection.prepareStatement(sql);

			pstm.setInt(1, id);

			pstm.execute();

			pstm.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Item data) {

		String sql = "update encitem set encprod_id = ?, encenc_id = ?, n_qtditem = ? where id = ?";

		try {
			PreparedStatement pstm = super.connection.prepareStatement(sql);

			pstm.setInt(1, data.getProduto().getId());
			pstm.setInt(2, data.getEncomenda().getId());
			pstm.setInt(3, data.getQuantidade());
			pstm.setInt(4, data.getId());

			pstm.execute();

			pstm.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected Item dataFactory(ResultSet row) throws SQLException {
		Item item = new Item();

		item.setId(row.getInt("id"));
		item.setQuantidade(row.getInt("n_qtditem"));

		return item;
	}

}
