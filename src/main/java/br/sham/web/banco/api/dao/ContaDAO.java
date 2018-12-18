package br.sham.web.banco.api.dao;

import br.sham.web.banco.api.model.Conta;

public interface ContaDAO {
	
	public Conta createConta(Conta conta);
	
	public Conta getContaById(int id);

}
