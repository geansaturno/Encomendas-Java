package app.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/", "/cliente" })
public class ClienteController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String actionRequested = request.getParameter("action");

		if (actionRequested == null)
			actionRequested = "Lista";

		try {
			Class<?> classe = Class.forName("app.mvc.controller.clienteLogic." + actionRequested + "ClienteAction");
			Action action = (Action) classe.newInstance();

			action.executeLogic(request, response);
			action.configuracaoPagina("Lista de Clientes", "../cliente/list.jsp", request);

			request.getRequestDispatcher("/WEB-INF/jsp/template.jsp").forward(request, response);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
