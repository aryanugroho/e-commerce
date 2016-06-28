package net.marcoreis.ecommerce.entidades.teste;

import javax.persistence.EntityManager;

import net.marcoreis.ecommerce.entidades.Categoria;
import net.marcoreis.ecommerce.util.JPAUtil;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TesteInsereCategoria {

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
    public void consultarTodasCategorias() {
        Categoria c = new Categoria();
        c.setDescricao("Utensílios domésticos para cama, mesa e banho");
        c.setNome("Cama, mesa e banho");
        em.persist(c);
    }
}
