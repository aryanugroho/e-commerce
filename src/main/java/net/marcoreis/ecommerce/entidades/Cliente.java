package net.marcoreis.ecommerce.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Cliente extends Usuario {
	private static final long serialVersionUID = 5073165906294726127L;
	@Column(unique = true, nullable = false)
	private String cpfCnpj;

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}
}
