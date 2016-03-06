package app.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Action {
	
	abstract public void executeLogic(HttpServletRequest req, HttpServletResponse res);
	
	protected void configuracaoPagina(String titulo, String pagina, HttpServletRequest req){
		
		req.setAttribute("title", titulo);
		req.setAttribute("page", pagina);
		
	}

}
