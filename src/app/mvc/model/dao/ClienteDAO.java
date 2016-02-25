package app.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import app.mvc.model.Cliente;
import app.mvc.model.ConnectionFactory;

public class ClienteDAO extends DAO<Cliente> {

	private Connection connection;

	public ClienteDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void add(Cliente cliente) {

		String sql = "insert into encclien (c_nomecli, c_telefonecli, c_emailcli) values(?, ?, ?)";

		try {
			PreparedStatement pstm = this.connection.prepareStatement(sql);

			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getTelefone());
			pstm.setString(3, cliente.getEmail());

			pstm.execute();

			pstm.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Cliente> list() {
		ArrayList<Cliente> list = new ArrayList<>();

		String sql = "select * from encclien";

		try {
			PreparedStatement pstm = this.connection.prepareStatement(sql);

			ResultSet resultSet = pstm.executeQuery();

			while (resultSet.next()) {

				Cliente cli = dataFactory(resultSet);
				list.add(cli);

			}

			pstm.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public void delete(int id) {
		String sql = "delete from encclien where id = ?";

		try {
			PreparedStatement pstm = this.connection.prepareStatement(sql);

			pstm.setInt(1, id);

			pstm.execute();

			pstm.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(Cliente cliente) {

		String sql = "update encclien set c_nomecli = ?, c_telefonecli = ?, c_emailcli = ? where id = ?";

		try {
			PreparedStatement pstm = this.connection.prepareStatement(sql);

			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getTelefone());
			pstm.setString(3, cliente.getEmail());
			pstm.setInt(4, cliente.getId());

			pstm.execute();

			pstm.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Cliente get(int id) {

		Cliente cli = null;
		String sql = "select * from encclien where id = ?";

		try {
			PreparedStatement pstm = this.connection.prepareStatement(sql);

			pstm.setInt(1, id);

			ResultSet resultSet = pstm.executeQuery();

			if (resultSet.next()) {
				cli = dataFactory(resultSet);
			}

			pstm.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cli;
	}

	@Override
	protected Cliente dataFactory(ResultSet row) throws SQLException {
		Cliente cli = new Cliente();

		cli.setId(row.getInt("id"));
		cli.setNome(row.getString("c_nomecli"));
		cli.setTelefone(row.getString("c_telefonecli"));
		cli.setEmail(row.getString("c_emailcli"));

		return cli;
	}
}
