package app.mvc.controller.cliente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.mvc.controller.Action;
import app.mvc.model.Cliente;
import app.mvc.model.dao.ClienteDAO;
import app.util.PageConfigBean;

public class SaveClienteAction extends Action {
	
	private ListaClienteAction proximaAcao;
	
	public SaveClienteAction() {
		proximaAcao = new ListaClienteAction();
	}

	@Override
	public void executeLogic(HttpServletRequest req, HttpServletResponse res) {
		
		new ClienteDAO().add(clienteFactory(req));
		
		proximaAcao.executeLogic(req, res);

	}

	@Override
	public void configuracaoPagina(HttpServletRequest request) {
		proximaAcao.configuracaoPagina(request);
		request.setAttribute("alert", "Novo Cliente adicionado com Sucesso");

	}
	
	private Cliente clienteFactory(HttpServletRequest request){
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		
		return new Cliente(nome, telefone, email);
	}

}
