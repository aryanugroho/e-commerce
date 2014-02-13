package net.marcoreis.ecommerce.teste;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import net.marcoreis.ecommerce.entidades.Usuario;
import net.marcoreis.ecommerce.util.JPAUtil;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TesteConsultaUsuarios {

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
    public void consultaTodosUsuarios() {
        String queryJPA = "from Usuario";
        Query query = em.createQuery(queryJPA);
        List<Usuario> usuarios = query.getResultList();
        for (Usuario usuario : usuarios) {
            System.out.println("Nome: " + usuario.getNome() + " ("
                    + usuario.getEmail() + ")");
        }
    }

    @Test
    public void consultaUsuriosAcessoDia() {
        em = JPAUtil.getInstance().getEntityManager();
        Query query = em.createNamedQuery("usuario.consultaAcessoDia");
        query.setParameter("data", new Date());
        List<Usuario> usuarios = query.getResultList();
        for (Usuario usuario : usuarios) {
            System.out.println("Nome/ultimo login: " + usuario.getNome()
                    + " - " + usuario.getUltimoLogin());
        }
    }
}
