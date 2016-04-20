package net.marcoreis.ecommerce.entidades;

import java.sql.Timestamp;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import net.marcoreis.ecommerce.util.UltimaAtualizacaoListener;

@Entity
@EntityListeners(value = UltimaAtualizacaoListener.class)
@NamedQueries({ @NamedQuery(name = "produto.consultaTotal", query = "select count(p) from Produto p"),
	// @NamedQuery(name = "produto.consultaTotalPorCategoria", query =
	// "select count(p) from Produto p where p.categoria.id =
	// :idCategoria"),
	@NamedQuery(name = "produto.consultaPorDescricao", query = "select p from Produto p where p.descricao like :descricaoParcial"),
	@NamedQuery(name = "produto.consultaPorIntervaloPreco", query = "select p from Produto p where p.preco >= ?1 and p.preco <= ?2") })
public class Produto implements IPersistente {
    private static final long serialVersionUID = 3206252406240046848L;
    @Id
    @GeneratedValue
    private Long id;
    // TODO ManyToMany ou outra entidade???
    // @ManyToOne
    // private Categoria categoria;
    private String nome;
    private String descricao;
    private String especificacaoLoja;
    @Lob
    @Column(length = 1024 * 1024 * 5)
    private byte[] especificacaoFabricante;
    private Double preco;
    @Column(nullable = false)
    private Timestamp atualizacao;
    private Timestamp dataAtualizacao;

    private Collection<String> tamanhos;
    private Collection<String> cores;
    private Genero genero;

    //
    // Genero, custo, cor,

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
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

    public void setAtualizacao(Timestamp atualizacao) {
	this.atualizacao = atualizacao;
    }

    public Timestamp getAtualizacao() {
	return atualizacao;
    }

    public Timestamp getDataAtualizacao() {
	return dataAtualizacao;
    }

    public void setDataAtualizacao(Timestamp dataAtualizacao) {
	this.dataAtualizacao = dataAtualizacao;
    }
}
