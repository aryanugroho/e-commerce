package net.marcoreis.ecommerce.util;

import java.util.Date;

import net.marcoreis.ecommerce.entidades.Cliente;
import net.marcoreis.ecommerce.entidades.ItemVenda;
import net.marcoreis.ecommerce.entidades.Produto;
import net.marcoreis.ecommerce.entidades.Venda;
import net.marcoreis.ecommerce.negocio.VendaService;

/**
 * Simula a criação de vendas
 * 
 * @author marco
 *
 */
public class GeradorDeVendas {

	public void gerarVenda() {
		Venda venda = new Venda();
		Cliente cliente = null;
		venda.setCliente(cliente);
		Date data = null;
		venda.setData(data);
		//
		Produto produto = null;
		ItemVenda item = new ItemVenda();
		item.setProduto(produto);
		Integer quantidade = null;
		item.setQuantidade(quantidade);
		Double valorTotal = null;
		item.setValorTotal(valorTotal);
		Double valorUnitario = null;
		item.setValorUnitario(valorUnitario);
		item.setVenda(venda);
		//
		VendaService service = new VendaService();
	}
}
