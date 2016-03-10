package app.mvc.controller.cliente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.mvc.controller.Action;
import app.mvc.model.Cliente;
import app.util.PageConfigBean;

public class NovoClienteAction extends Action{
	
	@Override
	public void executeLogic(HttpServletRequest req, HttpServletResponse res) {
		req.setAttribute("cliente", new Cliente());
	}

	@Override
	public void configuracaoPagina(HttpServletRequest request, PageConfigBean pageConfig) {
		request.setAttribute("pageConfig", new PageConfigBean("../cliente/new.jsp", "Novo Cliente", "cliente"));
	}

}
