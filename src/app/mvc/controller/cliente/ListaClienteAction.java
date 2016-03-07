package app.mvc.controller.cliente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.mvc.controller.Action;
import app.mvc.model.dao.ClienteDAO;
import app.util.PageConfigBean;

public class ListaClienteAction extends Action {

	@Override
	public void executeLogic(HttpServletRequest req, HttpServletResponse res) {
		
		req.setAttribute("clientes", new ClienteDAO().list());
	}

	@Override
	public void configuracaoPagina(HttpServletRequest request) {
		request.setAttribute("pageConfig", new PageConfigBean("../cliente/list.jsp","Lista de Clientes"));
		
	}
}
