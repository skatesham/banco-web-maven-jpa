package br.sham.web.banco.web.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.sham.web.banco.api.model.Usuario;
import br.sham.web.banco.api.web.Task;

public class Home implements Task  {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		
		request.setAttribute("usuario", usuario);
		
		return "/WEB-INF/templates/home.jsp";
	}

	
	
}
