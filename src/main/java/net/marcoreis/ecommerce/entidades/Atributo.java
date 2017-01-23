package net.marcoreis.ecommerce.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import net.marcoreis.ecommerce.util.IPersistente;

@Entity
public class Atributo implements IPersistente {
	private static final long serialVersionUID = 1211598398995817325L;
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private String valor;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public Long getId() {
		return id;
	}
}
