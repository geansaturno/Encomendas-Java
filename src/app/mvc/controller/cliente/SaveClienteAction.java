package app.mvc.controller.cliente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.mvc.controller.Action;
import app.mvc.model.Cliente;
import app.mvc.model.dao.ClienteDAO;
import app.util.PageConfigBean;

public class SaveClienteAction extends Action {

	private ClienteDAO cdao;

	public SaveClienteAction() {
		cdao = new ClienteDAO();
	}

	@Override
	public void executeLogic(HttpServletRequest req, HttpServletResponse res) {

		String idString = req.getParameter("id");

		if (idString != null) {
			alterarCliente(Integer.parseInt(idString), req);

		} else {
			criarCliente(req);

		}
	}

	private void criarCliente(HttpServletRequest req) {
		Cliente cliente = clienteFactory(req);

		req.setAttribute("cliente", cliente);

		cdao.add(clienteFactory(req));
		
		req.setAttribute("cliente", cliente);

	}

	private void alterarCliente(int id, HttpServletRequest req) {
		Cliente cliente = clienteFactory(req);

		cliente.setId(id);

		cdao.update(cliente);
		
		req.setAttribute("cliente", cliente);
	}

	@Override
	public void configuracaoPagina(HttpServletRequest request, PageConfigBean pageConfig) {

		Cliente cliente = (Cliente) request.getAttribute("cliente");

		pageConfig.setBody("../cliente/save.jsp");
		pageConfig.setTitle(cliente.getNome() + " Salvo");
		request.setAttribute("pageConfig", pageConfig);

	}

	private Cliente clienteFactory(HttpServletRequest request) {
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");

		return new Cliente(nome, telefone, email);
	}

}
