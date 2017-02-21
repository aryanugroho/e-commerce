package net.marcoreis.ecommerce.entidades.teste;

import java.util.Date;

import javax.persistence.EntityManager;

import net.marcoreis.ecommerce.entidades.Usuario;
import net.marcoreis.ecommerce.util.JPAUtil;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
    public void alterarUsuario() {
        Long id = 1l;
        Usuario usuario = em.find(Usuario.class, id);
        Assert.assertNotNull("Usuario não cadastrado", usuario);
        usuario.setEmail("diego@lucas.net");
        usuario.setNome("Diego Lucas");
        Date data = new Date();
        usuario.setUltimoLogin(data);
        em.persist(usuario);
    }
}
