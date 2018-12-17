package br.sham.web.banco.api.service;

import br.sham.web.banco.api.model.Usuario;

public interface ServiceUsuario {
	
	public Usuario login(String username, String password);

	public Usuario getUsuarioByUsuario(String username);
	
	public Usuario createUsuario(Usuario usuario);
	
}
