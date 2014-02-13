package net.marcoreis.ecommerce.teste;

import java.util.Date;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import net.marcoreis.ecommerce.entidades.Usuario;
import net.marcoreis.ecommerce.util.JPAUtil;

public class TesteAlteraUsuario {

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
    public void inserirUsuario() {
        Long id = 2l;
        Usuario usuario = em.find(Usuario.class, id);
        Assert.assertNotNull("Usuario não cadastrado", usuario);
        usuario.setEmail("diego@marcoreis.net");
        usuario.setNome("Diego");
        Date data = new Date();
        usuario.setUltimoLogin(data);
        em.persist(usuario);
    }
}
