package net.marcoreis.ecommerce.entidades.teste;

import java.util.Date;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import net.marcoreis.ecommerce.entidades.Usuario;
import net.marcoreis.ecommerce.util.JPAUtil;

public class TesteInsereUsuario {

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
        Usuario usuario = new Usuario();
        usuario.setEmail("ma@marcoreis.net");
        usuario.setNome("Marco Reis");
        Date data = new Date();
        usuario.setUltimoLogin(data);
        em.persist(usuario);
        Assert.assertTrue("Usuário gravado com sucesso", usuario.getId() > 0);
    }
}
