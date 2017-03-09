package net.marcoreis.ecommerce.entidades;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

import net.marcoreis.ecommerce.util.IPersistente;

@Entity
@NamedQuery(name = "categoria.consultaPeloNome", query = "select c from Categoria c where c.nome like :nome")
public class Categoria implements IPersistente {
	private static final long serialVersionUID = 6833139035296224500L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "CategoriaAtributo", joinColumns = @JoinColumn(name = "categoria_id"), inverseJoinColumns = @JoinColumn(name = "atributo_id"))
	private Set<Atributo> atributos = new HashSet<Atributo>(0);

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

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		Categoria other = (Categoria) obj;
		return getId() == other.getId();
	}

	public void setAtributos(Set<Atributo> atributos) {
		this.atributos = atributos;
	}

	public Set<Atributo> getAtributos() {
		return atributos;
	}

}
