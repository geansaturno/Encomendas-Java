package app.mvc.controller.cliente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.mvc.controller.Action;
import app.mvc.model.Cliente;
import app.mvc.model.dao.ClienteDAO;
import app.util.PageConfigBean;

public class MostrarClienteAction extends Action {

	@Override
	public void executeLogic(HttpServletRequest req, HttpServletResponse res) {
		int id = Integer.parseInt(req.getParameter("id"));
		
		req.setAttribute("cliente", new ClienteDAO().get(id));
	}

	@Override
	public void configuracaoPagina(HttpServletRequest request) {
		
		Cliente cliente = (Cliente) request.getAttribute("cliente");
		
		request.setAttribute("pageConfig", 
				new PageConfigBean("../cliente/show.jsp", "Cliente: " + cliente.getNome()));

	}
}
