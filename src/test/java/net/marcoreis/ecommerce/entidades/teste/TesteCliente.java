package net.marcoreis.ecommerce.entidades.teste;

import java.util.Random;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import net.marcoreis.ecommerce.entidades.Cliente;
import net.marcoreis.ecommerce.util.JPAUtil;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TesteCliente {
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
	public void teste1InserirCliente() {
		Random r = new Random();
		Cliente cliente = new Cliente();
		cliente.setEmail("fulano@abc.net");
		cliente.setNome("Marco Reis");
		cliente.setCpfCnpj(r.nextInt() + "");
		em.persist(cliente);
		Assert.assertTrue("Cliente gravado com sucesso",
				cliente.getId() > 0);
	}

}
