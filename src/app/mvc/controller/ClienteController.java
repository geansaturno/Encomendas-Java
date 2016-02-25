package app.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/", "/cliente"})
public class ClienteController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String logic = request.getParameter("logic");
		
		if(logic == null)
			logic = "Lista";
		
		try {
			Class<?> classe = Class.forName("app.mvc.controller.clienteLogic." + logic + "ClienteLogic");
			Logic logica = (Logic) classe.newInstance();
			
			String pagina = logica.execute(request, response);
			
			pagina = "/WEB-INF/cliente/" + pagina;
			
			System.out.println(pagina);
			
			request.getRequestDispatcher(pagina).forward(request, response);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
