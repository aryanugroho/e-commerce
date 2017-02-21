package net.marcoreis.ecommerce.entidades.teste;

import javax.persistence.EntityManager;

import net.marcoreis.ecommerce.entidades.Usuario;
import net.marcoreis.ecommerce.util.JPAUtil;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TesteRemoveUsuario {

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
	public void removerUsuario() {
		Usuario usuario = new Usuario();
		usuario.setEmail("teste");
		usuario.setNome("Nome de teste");
		em.persist(usuario);
		Assert.assertNotNull("Usuario não cadastrado", usuario);
		em.remove(usuario);
	}
}
