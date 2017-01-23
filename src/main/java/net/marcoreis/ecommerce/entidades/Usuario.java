package net.marcoreis.ecommerce.entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;

import net.marcoreis.ecommerce.util.IPersistente;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQuery(name = "usuario.consultaAcessoDia", query = "select u from Usuario u where u.ultimoLogin = :data")
public class Usuario implements IPersistente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String email;
	private String nome;
	private Date ultimoLogin;
	private static final long serialVersionUID = 8316978314047208790L;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setUltimoLogin(Date ultimoLogin) {
		this.ultimoLogin = ultimoLogin;
	}

	public Date getUltimoLogin() {
		return ultimoLogin;
	}

}
