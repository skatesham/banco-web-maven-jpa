package br.sham.web.banco.core.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.sham.web.banco.api.dao.UsuarioDAO;
import br.sham.web.banco.api.model.Usuario;
import br.sham.web.banco.api.util.Hash;
import br.sham.web.banco.api.util.JPAUtil;

public class UsuarioDAOMysql implements UsuarioDAO {

	private static UsuarioDAOMysql uniqueInstance;

	public static UsuarioDAOMysql getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new UsuarioDAOMysql();
		}
		return uniqueInstance;
	}

	EntityManager em;

	private UsuarioDAOMysql() {
		this.em = JPAUtil.getEntityManager();
	}

	private void begin() {
		this.em.getTransaction().begin();
	}

	private void commit() {
		this.em.getTransaction().commit();
	}

	@Override
	public Usuario getUsuarioByUsuario(String usuario) {
		this.begin();
		Usuario u = null;
		String jqpl = "select u from Usuario u where u.usuario = :pUsuario";
		Query query = em.createQuery(jqpl);
		query.setParameter("pUsuario", usuario);
		u = (Usuario) query.getSingleResult();
		this.commit();
		return u;
	}

	@Override
	public Usuario createUsuario(Usuario usuario) {
		this.begin();
		usuario.setPassword(Hash.criptografar(usuario.getPassword()));
		this.em.persist(usuario);
		this.commit();
		return usuario;
	}

}
