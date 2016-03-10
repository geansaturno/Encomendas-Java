package app.mvc.controller.cliente;

import java.io.IOException;

import javax.servlet.ServletException;
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
		
		Cliente cliente = clienteFactory(req);
		
		req.setAttribute("cliente", cliente);
		
		new ClienteDAO().add(clienteFactory(req));
		
	}

	@Override
	public void configuracaoPagina(HttpServletRequest request , PageConfigBean pageConfig) {
		
		Cliente cliente = (Cliente) request.getAttribute("cliente");
		
		pageConfig.setBody("../cliente/save.jsp");
		pageConfig.setTitle(cliente.getNome() + " Salvo");
		
		//proximaAcao.configuracaoPagina(request, pageConfig);
		
		//request.setAttribute("alert", "Novo Cliente adicionado com Sucesso");
		request.setAttribute("pageConfig", pageConfig);

	}
	
	private Cliente clienteFactory(HttpServletRequest request){
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		
		return new Cliente(nome, telefone, email);
	}

}
