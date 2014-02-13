package net.marcoreis.ecommerce.teste;

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
        Long id = 5l;
        Usuario usuario = em.find(Usuario.class, id);
        Assert.assertNotNull("Usuario não cadastrado", usuario);
        em.remove(usuario);
    }
}
