package br.sham.web.banco.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.sham.web.banco.api.model.Conta;
import br.sham.web.banco.api.model.Usuario;
import br.sham.web.banco.api.service.ServiceConta;
import br.sham.web.banco.api.service.ServiceUsuario;
import br.sham.web.banco.core.service.ServiceContaImpl;
import br.sham.web.banco.core.service.ServiceUsuarioImpl;

public class Cadastro extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("erro", false);
		String endereço = "/WEB-INF/templates/cadastro.jsp";
		req.getRequestDispatcher(endereço).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ServiceUsuario uDAO = ServiceUsuarioImpl.getInstance();
		ServiceConta cDAO = ServiceContaImpl.getInstance();

		String username = req.getParameter("usuario");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String endereco = req.getParameter("endereco");

		Usuario usuario = new Usuario();
		usuario.setEmail(email);
		usuario.setUsuario(username);
		usuario.setPassword(password);
		usuario.setEndereco(endereco);

		usuario = uDAO.createUsuario(usuario);

		if (usuario == null) {
			req.setAttribute("erro", true);
			String endereço = "/WEB-INF/templates/cadastro.jsp";
			req.getRequestDispatcher(endereço).forward(req, resp);
			
		} else {
			Conta conta = new Conta();
			conta.setAgencia("0001");
			conta.setNumero(String.format("%05d", usuario.getId()));
			conta.setBanco("01 - Banco Sham");
			cDAO.createConta(conta);
			usuario.setConta(conta);
			uDAO.updateUsuario(usuario);
			String endereço = "/WEB-INF/templates/login.jsp";
			req.getRequestDispatcher(endereço).forward(req, resp);

		}
	}
}
