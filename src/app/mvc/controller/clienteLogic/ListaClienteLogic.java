package app.mvc.controller.clienteLogic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.mvc.controller.Logic;
import app.mvc.model.dao.ClienteDAO;

public class ListaClienteLogic implements Logic {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) {
		
		req.setAttribute("clientes", new ClienteDAO().list());
		
		return "list.jsp";
	}

}
