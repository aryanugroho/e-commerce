package net.marcoreis.ecommerce.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "categoria.consultaPelaDescricao", query = "from Categoria where descricao like :descricao")
public class Categoria {
    private Long id;
    private String nome;
    private String descricao;

    @Id
    @GeneratedValue
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
