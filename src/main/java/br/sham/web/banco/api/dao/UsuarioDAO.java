package br.sham.web.banco.api.dao;

import br.sham.web.banco.api.model.Usuario;

public interface UsuarioDAO {
	
	public Usuario getUsuarioByUsuario(String usuario);
	
	public Usuario createUsuario(Usuario usuario);
	
}
