package br.sham.web.banco.core.dao;

import java.security.MessageDigest;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.sham.web.banco.api.dao.UsuarioDAO;
import br.sham.web.banco.api.model.Usuario;
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
		String jqpl = "select u from Usuario where m.usuario = " + usuario;
		Query query = em.createQuery(jqpl);
		u = (Usuario) query.getSingleResult();
		this.commit();
		return u;
	}

	@Override
	public Usuario createUsuario(Usuario usuario) {
		this.begin();
		this.em.persist(usuario);
		this.commit();
		return usuario;
	}
	
	private String criptografar(String senha) {
		MessageDigest algorithym = MessageDigest.getInstance("SHA-256");
	}

}
