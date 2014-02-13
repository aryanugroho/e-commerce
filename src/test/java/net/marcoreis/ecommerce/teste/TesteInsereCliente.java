package net.marcoreis.ecommerce.teste;

import java.util.Date;

import javax.persistence.EntityManager;

import net.marcoreis.ecommerce.entidades.Cliente;
import net.marcoreis.ecommerce.entidades.Usuario;
import net.marcoreis.ecommerce.util.JPAUtil;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TesteInsereCliente {
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
    public void inserirCliente() {
        Cliente cliente = new Cliente();
        cliente.setEmail("jose@oracle.com");
        cliente.setNome("Jose Carlos");
        cliente.setCpfCnpj("123456");
        em.persist(cliente);
        Assert.assertTrue("Cliente gravado com sucesso", cliente.getId() > 0);
    }

}
