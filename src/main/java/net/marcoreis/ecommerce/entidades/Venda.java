package net.marcoreis.ecommerce.entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import net.marcoreis.ecommerce.util.IPersistente;

@Entity
public class Venda implements IPersistente {
	private static final long serialVersionUID = -4519913495960906821L;
	@Id
	@GeneratedValue
	private Long id;
	private Date data;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getData() {
		return data;
	}

}