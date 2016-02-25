package app.mvc.model;

import java.util.ArrayList;

public class Produto {
	private int id;
	private String nome;
	private int quantidade;
	private String descricao;
	
	public Produto(){
	}
	
	public Produto(String nome, int quantidade, String descricao) {
		super();
		this.nome = nome;
		this.quantidade = quantidade;
		this.descricao = descricao;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String toString(){
		return this.nome + " - " + this.descricao;
	}
}
