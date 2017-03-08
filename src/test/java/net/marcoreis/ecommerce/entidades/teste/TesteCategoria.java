package net.marcoreis.ecommerce.entidades.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import net.marcoreis.ecommerce.entidades.Categoria;
import net.marcoreis.ecommerce.util.JPAUtil;

public class TesteCategoria {

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
	public void teste1InserirCategoria() {
		Categoria c = new Categoria();
		c.setNome("Cama, mesa e banho");
		em.persist(c);
	}

	@Test
	public void teste2ConsultarTodasCategorias() {
		String jpaql = "select c from Categoria c";
		TypedQuery<Categoria> query = em.createQuery(jpaql,
				Categoria.class);
		List<Categoria> categorias = query.getResultList();
		for (Categoria c : categorias) {
			System.out.println(c.getId() + " - " + c.getNome());
		}
	}

	@Test
	public void teste3ConsultarCategoriasPorDescricao() {
		List<Categoria> categorias = em
				.createNamedQuery(
						"categoria.consultaPelaDescricao",
						Categoria.class)
				.setParameter("descricao", "%cama%")
				.getResultList();
		Assert.assertTrue(
				"Não há categorias para a descrição informada",
				categorias.size() > 0);
		for (Categoria c : categorias) {
			System.out.println(c.getId() + " - " + c.getNome());
		}
	}
}
