package net.marcoreis.ecommerce.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Produto {
    private Long id;
    private Categoria categoria;
    private String nome;
    private String descricao;
    private String especificacaoLoja;
    private byte[] especificacaoFabricante;
    private Double preco;

    @Id
    @GeneratedValue
    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    @ManyToOne
    public Categoria getCategoria() {
	return categoria;
    }

    public void setCategoria(Categoria categoria) {
	this.categoria = categoria;
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public String getDescricao() {
	return descricao;
    }

    public void setDescricao(String descricao) {
	this.descricao = descricao;
    }

    public String getEspecificacaoLoja() {
	return especificacaoLoja;
    }

    public void setEspecificacaoLoja(String especificacaoLoja) {
	this.especificacaoLoja = especificacaoLoja;
    }

    @Lob
    public byte[] getEspecificacaoFabricante() {
	return especificacaoFabricante;
    }

    public void setEspecificacaoFabricante(byte[] especificacaoFabricante) {
	this.especificacaoFabricante = especificacaoFabricante;
    }

    public Double getPreco() {
	return preco;
    }

    public void setPreco(Double preco) {
	this.preco = preco;
    }

}
