package br.sham.web.banco.core.service;

import br.sham.web.banco.api.model.Usuario;
import br.sham.web.banco.api.service.ServiceUsuario;
import br.sham.web.banco.api.util.Hash;
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
	public Usuario getUsuarioByUsuario(String username) {
		try {
			return uDAO.getUsuarioByUsuario(username);
		} catch (Exception e) {
			// e.printStackTrace();
		}
		return null;

	}

	@Override
	public Usuario createUsuario(Usuario usuario) {

		try {
			return uDAO.createUsuario(usuario);
		} catch (Exception e) {
			// e.printStackTrace();
		}
		return null;
	}

	@Override
	public Usuario login(String username, String password) {
		Usuario usuario = this.getUsuarioByUsuario(username);
		if (usuario != null) {
			password = Hash.criptografar(password);
			if (usuario.getPassword().equals(password)) {
				//usuario.setPassword(null);
				return usuario;
			}
		}

		return null;
	}

	@Override
	public Usuario updateUsuario(Usuario usuario) {
		try {
			return uDAO.updateUsuario(usuario);
		} catch (Exception e) {
			// e.printStackTrace();
		}
		return null;

	}

}
