package net.marcoreis.ecommerce.entidades.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import net.marcoreis.ecommerce.entidades.Atributo;
import net.marcoreis.ecommerce.entidades.Categoria;
import net.marcoreis.ecommerce.entidades.Produto;
import net.marcoreis.ecommerce.util.JPAUtil;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TesteProduto {

	private EntityManager em;

	@Before
	public void inicializar() {
		em = JPAUtil.getInstance().getEntityManager();
		em.getTransaction().begin();
	}

	@After
	public void finalizar() {
		em.getTransaction().commit();
		em.close();
	}

	@Test
	public void teste1InserirProduto() {
		Long idCategoria = 1l;
		Categoria categoria = em.find(Categoria.class,
				idCategoria);
		if (categoria == null) {
			categoria = new Categoria();
			categoria.setDescricao(
					"Utensílios domésticos para cama, mesa e banho");
			categoria.setNome("Cama, mesa e banho");
			em.persist(categoria);
		}
		//
		Long idAtributo = 1l;
		Atributo atributo = em.find(Atributo.class, idAtributo);
		if (atributo == null) {
			atributo = new Atributo();
			atributo.setNome("Cor");
			atributo.setValor("Verde, Amarelo, Azul, Branco");
			em.persist(atributo);
		}
		//
		Produto produto = new Produto();
		produto.setDescricao(
				"Colcha para cama de solteiro 120cm x 210cm");
		produto.setNome("Colcha para cama de solteiro");
		produto.setPreco(150.00);
		produto.getCategorias().add(categoria);
		produto.getAtributos().add(atributo);
		em.persist(produto);
	}

	@Test
	public void teste2ConsultarProdutosPelaCategoria() {
		Long idCategoria = 1l;
		List<Produto> produtos = em
				.createQuery(
						"select p from Produto p join p.categorias c where c.id in (?1)")
				.setParameter(1, idCategoria).getResultList();
		for (Produto p : produtos) {
			System.out.println(p.getId() + " - " + p.getNome());
		}
	}

	// @Test
	// public void consultarTotalProdutoPelaCategoria() {
	// System.out.println("Consultar total de produtos pela categoria");
	// Query query = em.createNamedQuery("produto.consultaTotalPorCategoria");
	// Long idCategoria = 1l;
	// query.setParameter("idCategoria", idCategoria);
	// Object resultado = query.getSingleResult();
	// System.out.println("Total de produtos na categoria: " + resultado);
	// }

	@Test
	public void teste3ConsultarPorIntervaloPreco() {
		TypedQuery<Produto> query = em.createNamedQuery(
				"produto.consultaPorIntervaloPreco",
				Produto.class);
		query.setParameter(1, 150.0);
		query.setParameter(2, 249.0);
		List<Produto> produtos = query.getResultList();
		for (Produto p : produtos) {
			System.out.println(p.getId() + " - " + p.getNome()
					+ "(" + p.getPreco() + ")");
		}
	}
}
