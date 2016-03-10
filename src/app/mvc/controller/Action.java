package app.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.util.PageConfigBean;

public abstract class Action {
	
	protected PageConfigBean pagina;
	
	public abstract void executeLogic(HttpServletRequest req, HttpServletResponse res);
	
	public abstract void configuracaoPagina(HttpServletRequest request, PageConfigBean pageConfig);

}
