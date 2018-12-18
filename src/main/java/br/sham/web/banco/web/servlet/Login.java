package br.sham.web.banco.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.sham.web.banco.api.model.Usuario;
import br.sham.web.banco.api.service.ServiceUsuario;
import br.sham.web.banco.core.service.ServiceUsuarioImpl;

public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String endereço = "/WEB-INF/templates/login.jsp";
		req.getRequestDispatcher(endereço).forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("erro", false);
		ServiceUsuario uDAO = ServiceUsuarioImpl.getInstance();

		String username = req.getParameter("usuario");
		String password = req.getParameter("password");

		Usuario usuario = uDAO.login(username, password);

		if (usuario == null) {
			req.setAttribute("erro", true);
			String endereço = "/WEB-INF/templates/login.jsp";
			req.getRequestDispatcher(endereço).forward(req, resp);
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("usuario", usuario);
			req.setAttribute("usuario", usuario);
			String endereço = "/WEB-INF/templates/home.jsp";
			req.getRequestDispatcher(endereço).forward(req, resp);

		}

	}

}
