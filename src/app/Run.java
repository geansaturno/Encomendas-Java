package app;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import app.mvc.model.Cliente;
import app.mvc.model.ConnectionFactory;
import app.mvc.model.Encomenda;
import app.mvc.model.Item;
import app.mvc.model.Produto;
import app.mvc.model.dao.ClienteDAO;
import app.mvc.model.dao.EncomendaDAO;
import app.mvc.model.dao.ItemDAO;
import app.mvc.model.dao.ProdutoDAO;

public class Run {

	public static void main(String[] args) {

		EncomendaDAO encDao = new EncomendaDAO();
		ItemDAO itemDao = new ItemDAO();
		ProdutoDAO prodDao = new ProdutoDAO();
		ClienteDAO cliDao = new ClienteDAO();

		for (Cliente cli : cliDao.list()) {
			System.out.println(cli.toString());
			for (Encomenda enc : encDao.listEncomendasCliente(cli)) {
				System.out.println("\t * " + enc.toString());
				for (Item item : itemDao.listItensEncomenda(enc)) {
					System.out.println("\t\t * " + item.toString());
				}
			}
		}
		
		System.out.println("\n\n\n\n");
		
		for( Produto prod : prodDao.list()){
			System.out.println("Produto : " + prod.toString());
			for(Item item : itemDao.listItensProduto(prod)){
				System.out.println("\t * " + item.toString());
			}
		}

		System.out.println("Pronto!");
	}
}
