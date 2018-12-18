package br.sham.web.banco.core.service;

import br.sham.web.banco.api.model.Conta;
import br.sham.web.banco.api.service.ServiceConta;
import br.sham.web.banco.core.dao.ContaDAOMysql;

public class ServiceContaImpl implements ServiceConta {
	
	private static ServiceContaImpl uniqueInstance;

	public static ServiceContaImpl getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new ServiceContaImpl();
		}
		return uniqueInstance;
	}

	ContaDAOMysql uDAO;

	private ServiceContaImpl() {
		uDAO = ContaDAOMysql.getInstance();
	}

	@Override
	public Conta createConta(Conta conta) {
		try {
			return this.uDAO.createConta(conta);
		} catch (Exception e) {
			// e.printStackTrace();
		}
		return null;
	}

	@Override
	public Conta getContaById(int id) {
		try {
			return this.uDAO.getContaById(id);
		} catch (Exception e) {
			// e.printStackTrace();
		}
		return null;
	}

}
