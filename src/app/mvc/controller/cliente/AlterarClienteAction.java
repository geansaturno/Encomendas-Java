package app.mvc.controller.cliente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.mvc.controller.Action;
import app.mvc.model.Cliente;
import app.mvc.model.dao.ClienteDAO;
import app.util.PageConfigBean;

public class AlterarClienteAction extends Action {

	@Override
	public void executeLogic(HttpServletRequest req, HttpServletResponse res) {
		int id = Integer.parseInt(req.getParameter("id"));
		Cliente cliente = new ClienteDAO().get(id);
		
		req.setAttribute("cliente", cliente);

	}

	@Override
	public void configuracaoPagina(HttpServletRequest request, PageConfigBean pageConfig) {
		
		Cliente cliente = (Cliente) request.getAttribute("cliente");
		
		pageConfig.setBody("../cliente/update.jsp");
		pageConfig.setTitle("Alterar " + cliente.getNome());
		
		request.setAttribute("pageConfig", pageConfig);

	}

}
