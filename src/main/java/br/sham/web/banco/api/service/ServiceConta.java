package br.sham.web.banco.api.service;

import br.sham.web.banco.api.model.Conta;

public interface ServiceConta {
	
	public Conta createConta(Conta conta);
	
	public Conta getContaById(int id);
}
