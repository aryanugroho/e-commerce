package net.marcoreis.ecommerce.entidades;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;

import net.marcoreis.ecommerce.util.UltimaAtualizacaoListener;

@Entity
@EntityListeners(value = UltimaAtualizacaoListener.class)
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQuery(name = "usuario.consultaAcessoDia", query = "from Usuario where cast(ultimoLogin as date) = :data")
public class Usuario implements IPersistente {
    @Id
    @GeneratedValue
    private Long id;
    private String email;
    private String nome;
    private Date ultimoLogin;
    private Timestamp dataAtualizacao;
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

    public Timestamp getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Timestamp dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}
