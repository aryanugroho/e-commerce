package net.marcoreis.ecommerce.entidades.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import net.marcoreis.ecommerce.entidades.Produto;
import net.marcoreis.ecommerce.util.JPAUtil;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TesteConsultaProdutos {

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
        List<Produto> produtos = em.createQuery("from Produto").getResultList();
        for (Produto p : produtos) {
            System.out.println(p.getId() + " - " + p.getNome());
        }
    }

    @Test
    public void consultarProdutosPelaCategoria() {
        Long idCategoria = 12l;
        List<Produto> produtos = em
                .createQuery("from Produto where categoria.id = ?1")
                .setParameter(1, idCategoria).getResultList();
        for (Produto p : produtos) {
            System.out.println(p.getId() + " - " + p.getNome());
        }
    }

    @Test
    public void consultarTotalProdutoPelaCategoria() {
        System.out.println("Consultar total de produtos pela categoria");
        Query query = em.createNamedQuery("produto.consultaTotalPorCategoria");
        Long idCategoria = 12l;
        query.setParameter("idCategoria", idCategoria);
        Object resultado = query.getSingleResult();
        System.out.println("Total de produtos na categoria: " + resultado);
    }

    @Test
    public void consultarPorIntervaloPreco() {
        Query query = em.createNamedQuery("produto.consultaPorIntervaloPreco");
        query.setParameter(1, 150.0);
        query.setParameter(2, 249.0);
        List<Produto> produtos = query.getResultList();
        for (Produto p : produtos) {
            System.out.println(p.getId() + " - " + p.getNome() + "("
                    + p.getPreco() + ")");
        }
    }
}
