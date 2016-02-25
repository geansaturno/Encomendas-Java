package app.mvc.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import app.mvc.model.Cliente;
import app.mvc.model.ConnectionFactory;
import app.mvc.model.Encomenda;

public class EncomendaDAO extends DAO<Encomenda>{

	private Connection connection;

	public EncomendaDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void add(Encomenda enc) {
		String sql = "insert into encenc (d_dataenc, encclien_id) values (?, ?)";

		try {
			PreparedStatement pstm = this.connection.prepareStatement(sql);

			pstm.setDate(1, new Date(enc.getDataEncomenda().getTimeInMillis()));
			pstm.setInt(2, enc.getCliente().getId());

			pstm.execute();

			pstm.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Encomenda> list() {
		ArrayList<Encomenda> encomendas = new ArrayList<>();

		String sql = "select * from encenc";

		try {
			PreparedStatement pstm = this.connection.prepareStatement(sql);

			ResultSet set = pstm.executeQuery();

			while (set.next()) {

				Encomenda enc = dataFactory(set);

				int idCliente = set.getInt("encclien_id");

				for (Encomenda encAnterior : encomendas)
					if (encAnterior.getCliente().getId() == idCliente)
						enc.setCliente(encAnterior.getCliente());

				if (enc.getCliente() == null)
					enc.setCliente(new ClienteDAO().get(idCliente));

				encomendas.add(enc);

			}

			pstm.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return encomendas;
	}

	public ArrayList<Encomenda> listEncomendasCliente(Cliente cliente) {

		ArrayList<Encomenda> encomendas = new ArrayList<>();

		String sql = "select * from encenc where encclien_id = ?";

		try {
			PreparedStatement pstm = this.connection.prepareStatement(sql);

			pstm.setInt(1, cliente.getId());

			ResultSet set = pstm.executeQuery();

			while (set.next()) {
				Encomenda enc = dataFactory(set);

				enc.setCliente(cliente);
				

				encomendas.add(enc);
			}

			pstm.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return encomendas;
	}
	
	public void delete (int id){
		
		String sql = "delete from encenc where id = ?";
		
		try {
			PreparedStatement pstm = this.connection.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			pstm.execute();
			
			pstm.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void update (Encomenda enc){
		
		String sql = "update encenc set d_dataenc = ?, encclien_id = ? where id = ?";
		
		try {
			PreparedStatement pstm = this.connection.prepareStatement(sql);
			
			pstm.setDate(1, new Date(enc.getDataEncomenda().getTimeInMillis()));
			pstm.setInt(2, enc.getCliente().getId());
			pstm.setInt(3, enc.getId());
			
			pstm.execute();
			
			pstm.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Encomenda get(int id) {

		Encomenda enc = null;

		String sql = "select * from encenc where id = ?";

		try {
			PreparedStatement pstm = this.connection.prepareStatement(sql);

			pstm.setInt(1, id);

			ResultSet set = pstm.executeQuery();

			if (set.next()) {
				enc = dataFactory(set);

				enc.setCliente(new ClienteDAO().get(set.getInt("encclien_id")));
			}

			pstm.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return enc;
	}

	@Override
	protected Encomenda dataFactory(ResultSet row) throws SQLException {
		Encomenda enc = new Encomenda();

		Calendar data = Calendar.getInstance();
		data.setTime(row.getDate("d_dataenc"));

		enc.setDataEncomenda(data);
		enc.setId(row.getInt("id"));
		
		return enc;
	}

}
