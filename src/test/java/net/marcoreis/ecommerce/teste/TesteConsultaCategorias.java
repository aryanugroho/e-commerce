package net.marcoreis.ecommerce.teste;

import java.util.List;

import javax.persistence.EntityManager;

import net.marcoreis.ecommerce.entidades.Categoria;
import net.marcoreis.ecommerce.util.JPAUtil;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TesteConsultaCategorias {

    private EntityManager em;

    @Before
    public void inicializar() {
        em = JPAUtil.getInstance().getEntityManager();
    }

    @After
    public void finalizar() {
        em.close();
    }

    @Test
    public void consultarTodasCategorias() {
        List<Categoria> categorias = em.createQuery("from Categoria")
                .getResultList();
        for (Categoria c : categorias) {
            System.out.println(c.getId() + " - " + c.getNome());
        }
    }

    @Test
    public void consultarCategoriasPorDescricao() {
        List<Categoria> categorias = em
                .createNamedQuery("categoria.consultaPelaDescricao")
                .setParameter("descricao", "%cama%").getResultList();
        Assert.assertTrue("Não há categorias para a descrição informada",
                categorias.size() > 0);
        for (Categoria c : categorias) {
            System.out.println(c.getId() + " - " + c.getNome());
        }
    }
}
