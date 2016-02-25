package app.mvc.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import app.mvc.model.ConnectionFactory;

public abstract class DAO <T> {
	
	protected Connection connection;
	
	public DAO(){
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public abstract void add(T data);
	public abstract ArrayList<T> list();
	public abstract T get(int id);
	public abstract void delete(int id);
	public abstract void update(T data);
	
	protected abstract T dataFactory(ResultSet row) throws SQLException;
}
