package net.marcoreis.ecommerce.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ItemVenda {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Produto produto;
    private Double valorUnitario;
    private Double valorTotal;
    @ManyToOne
    private Venda venda;
    private Integer quantidade;

    public void setId(Long id) {
	this.id = id;
    }

    public Long getId() {
	return id;
    }

    public void setProduto(Produto produto) {
	this.produto = produto;
    }

    public Produto getProduto() {
	return produto;
    }

    public void setValorUnitario(Double valorUnitario) {
	this.valorUnitario = valorUnitario;
    }

    public Double getValorUnitario() {
	return valorUnitario;
    }

    public void setValorTotal(Double valorTotal) {
	this.valorTotal = valorTotal;
    }

    public Double getValorTotal() {
	return valorTotal;
    }

    public void setVenda(Venda venda) {
	this.venda = venda;
    }

    public Venda getVenda() {
	return venda;
    }

    public void setQuantidade(Integer quantidade) {
	this.quantidade = quantidade;
    }

    public Integer getQuantidade() {
	return quantidade;
    }
}