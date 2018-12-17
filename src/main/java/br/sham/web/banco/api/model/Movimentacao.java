package br.sham.web.banco.api.model;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public @Data class Movimentacao {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private BigDecimal valor;
	@Enumerated(EnumType.STRING)
	private TipoMovimentacao tipoMovimentacao;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar data;
	private String descricao;
	@ManyToOne
	private Conta conta;
	@ManyToMany
	private List<Categoria> categorias;
	
	public void print() {
		System.out.println(this.toString()+"\n");
	}
	
}
