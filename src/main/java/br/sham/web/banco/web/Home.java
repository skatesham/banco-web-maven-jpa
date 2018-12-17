package br.sham.web.banco.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.sham.web.banco.api.model.Usuario;
import br.sham.web.banco.api.service.ServiceUsuario;
import br.sham.web.banco.api.web.Task;
import br.sham.web.banco.core.service.ServiceUsuarioImpl;

public class Home implements Task  {

	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		ServiceUsuario serviceUsuario = ServiceUsuarioImpl.getInstance();
		
		Usuario usuario = new Usuario();
		usuario.setNome("Sham Vinicius Fiorin");
		usuario.setEmail("sham.vinicius@gmail.com");
		usuario.setPassword("123");
		usuario.setUsuario("sham");
		
		serviceUsuario.cadastro(usuario);
		
		return "/WEB-INF/templates/home.jsp";
	}

	
	
}
