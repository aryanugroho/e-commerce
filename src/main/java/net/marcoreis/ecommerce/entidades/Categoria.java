package net.marcoreis.ecommerce.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import net.marcoreis.ecommerce.util.IPersistente;

@Entity
@NamedQuery(name = "categoria.consultaPelaDescricao", query = "select c from Categoria c where c.descricao like :descricao")
public class Categoria implements IPersistente {
	private static final long serialVersionUID = 6833139035296224500L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String descricao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		Categoria other = (Categoria) obj;
		return getId() == other.getId();
	}

}
