package br.sham.web.banco.web.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.sham.web.banco.api.web.Task;

public class Saque implements Task{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "/WEB-INF/templates/home.jsp";
	}

	
	
}
