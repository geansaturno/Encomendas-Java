package app.mvc.model;

public class Item {
	
	private int id;
	private Produto produto;
	private Encomenda encomenda;
	private int quantidade;
	
	public Item(){
	}
	
	public Item(Produto produto, Encomenda encomenda, int qtd) {
		super();
		this.produto = produto;
		this.encomenda = encomenda;
		this.quantidade = qtd;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Encomenda getEncomenda() {
		return encomenda;
	}
	public void setEncomenda(Encomenda encomenda) {
		this.encomenda = encomenda;
	}
	
	public String toString(){
		return quantidade + " X " + produto.getNome() + " - " + encomenda.getCliente().getNome();
	}
}
