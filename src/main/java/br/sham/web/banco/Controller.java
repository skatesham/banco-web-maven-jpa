package br.sham.web.banco;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.sham.web.banco.api.web.Task;

public class Controller extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Writer writer = resp.getWriter();
		writer.write("<h1>NOT SUPPORTED!</h1>");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String pacote = "br.sham.web.banco.web.servlet.";
		
		// qual tarefa quero executar?

		String tarefa = req.getParameter("task");
		if (tarefa == null) {
			throw new IllegalArgumentException("Você esqueceu de inserir uma tarefa");
		}

		String nomeDaClasse = pacote + tarefa;

		try {

			Class<?> type = Class.forName(nomeDaClasse);
			Task instancia = (Task) type.newInstance();

			// para qual página desejo ir?

			String pagina = instancia.execute(req, resp);
			req.getRequestDispatcher(pagina).forward(req, resp);

		} catch (Exception e) {
			throw new ServletException(e);
		}

	}
}
