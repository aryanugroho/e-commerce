package net.marcoreis.ecommerce.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Cliente extends Usuario {
    @Column(unique = true, nullable = false)
    private String cpfCnpj;

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }
}
