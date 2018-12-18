package br.sham.web.banco.core.dao;

import javax.persistence.EntityManager;

import br.sham.web.banco.api.dao.ContaDAO;
import br.sham.web.banco.api.model.Conta;
import br.sham.web.banco.api.util.JPAUtil;

public class ContaDAOMysql implements ContaDAO {
	
	private static ContaDAOMysql uniqueInstance;

	public static ContaDAOMysql getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new ContaDAOMysql();
		}
		return uniqueInstance;
	}

	EntityManager em;

	private ContaDAOMysql() {
		this.em = JPAUtil.getEntityManager();
	}

	private void begin() {
		this.em.getTransaction().begin();
	}

	private void commit() {
		this.em.getTransaction().commit();
	}

	@Override
	public Conta createConta(Conta conta) {
		this.begin();
		this.em.persist(conta);
		this.commit();
		return conta;
		
	}

	@Override
	public Conta getContaById(int id) {
		this.begin();
		Conta conta = this.em.find(Conta.class, id);
		this.commit();
		return conta;
	}

}
