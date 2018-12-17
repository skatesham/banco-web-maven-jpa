package br.sham.web.banco.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Cadastro extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String endereço = "/WEB-INF/templates/cadastro.jsp";
		req.getRequestDispatcher(endereço).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String endereço = "/WEB-INF/templates/home.jsp";
		req.getRequestDispatcher(endereço).forward(req, resp);
	}

	
	
}
