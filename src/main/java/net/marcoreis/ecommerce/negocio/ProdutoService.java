package net.marcoreis.ecommerce.negocio;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import net.marcoreis.ecommerce.entidades.Produto;
import net.marcoreis.ecommerce.util.JPAUtil;

public class ProdutoService extends GenericService {

	private static final long serialVersionUID = -2527941294512350117L;

	/**
	 * Retorna os registros atualizados/inseridos recentemente
	 * 
	 * @param tempo
	 *            quantidade de minutos
	 * @return lista de produtos alterados nos últimos minutos
	 */
	public List<Produto> consultarNovosProdutos(
			int tempoEmMinutos) {
		String sql = "select p from Produto where dataAtualizacao between :inicio and :fim";
		EntityManager em = JPAUtil.getInstance()
				.getEntityManager();
		TypedQuery<Produto> query = em.createQuery(sql,
				Produto.class);
		Date agora = new Date();
		Date inicio = new Date(
				agora.getTime() - tempoEmMinutos * 60 * 1000);
		query.setParameter(1, inicio);
		query.setParameter(2, agora);
		List<Produto> produtos = query.getResultList();
		em.close();
		return produtos;
	}

}
