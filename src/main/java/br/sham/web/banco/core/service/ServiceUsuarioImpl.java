package br.sham.web.banco.core.service;

import br.sham.web.banco.api.model.Usuario;
import br.sham.web.banco.api.service.ServiceUsuario;
import br.sham.web.banco.core.dao.UsuarioDAOMysql;

public class ServiceUsuarioImpl implements ServiceUsuario {

	private static ServiceUsuarioImpl uniqueInstance;

	public static ServiceUsuarioImpl getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new ServiceUsuarioImpl();
		}
		return uniqueInstance;
	}

	UsuarioDAOMysql uDAO;

	private ServiceUsuarioImpl() {
		uDAO = UsuarioDAOMysql.getInstance();
	}

	@Override
	public Usuario login(String username) {
		return uDAO.getUsuarioByUsuario(username);
	}

	@Override
	public Usuario cadastro(Usuario usuario) {
		return uDAO.createUsuario(usuario);
	}

}
