package app.mvc.model;

import java.util.ArrayList;
import java.util.Calendar;

public class Encomenda {
	
	private int id;
	private Calendar dataEncomenda;
	private Cliente cliente;
	
	public Encomenda() {
	}
	
	public Encomenda(Calendar dataEncomenda, Cliente cliente) {
		super();
		this.dataEncomenda = dataEncomenda;
		this.cliente = cliente;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Calendar getDataEncomenda() {
		return dataEncomenda;
	}
	public void setDataEncomenda(Calendar dataEncomenda) {
		this.dataEncomenda = dataEncomenda;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public String toString(){
		return dataEncomenda.getTime().toString();
	}
}
