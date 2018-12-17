package br.sham.web.banco.core.dao;

import java.nio.charset.StandardCharsets;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.google.common.hash.Hashing;

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
		String jqpl = "select u from Usuario where m.usuario = :pUsuario";
		Query query = em.createQuery(jqpl);
		query.setParameter("pUsuario", usuario);
		u = (Usuario) query.getSingleResult();
		this.commit();
		return u;
	}

	@Override
	public Usuario createUsuario(Usuario usuario) {
		this.begin();
		usuario.setPassword(this.criptografar(usuario.getPassword()));
		this.em.persist(usuario);
		this.commit();
		return usuario;
	}
	
	private String criptografar(String senha) {
		return Hashing.sha256().hashString(senha, StandardCharsets.UTF_8).toString();
		
	}

}
