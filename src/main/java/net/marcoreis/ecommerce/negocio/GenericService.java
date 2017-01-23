package net.marcoreis.ecommerce.negocio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import net.marcoreis.ecommerce.util.IPersistente;
import net.marcoreis.ecommerce.util.JPAUtil;

public class GenericService implements Serializable {
    private static final long serialVersionUID = -3367294814062827212L;

    //
    public List carregarColecao(Class<?> entidade) {
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        try {
            String jpaql = "from " + entidade.getName();
            List lista = em.createQuery(jpaql).getResultList();
            return lista;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            em.close();
        }
    }

    public List carregarColecao(Class<?> entidade, String filtro,
            Object... parametros) {
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        try {
            String jpaql = "from " + entidade.getName();
            jpaql += " where " + filtro;
            Query query = em.createQuery(jpaql);
            for (int i = 0; i < parametros.length; i++) {
                query.setParameter(i + 1, parametros[i]);
            }
            List lista = query.getResultList();
            return lista;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            em.close();
        }
    }

    public void salvar(IPersistente persistente) {
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        try {
            em.getTransaction().begin();
            if (persistente.getId() != null) {
                persistente = em.merge(persistente);
            }
            em.persist(persistente);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException(e);
        } finally {
            em.close();
        }
    }

    public Object findById(Class clazz, Long id) {
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        Object obj = em.find(clazz, id);
        em.clear();
        return obj;
    }

    public void remove(IPersistente persistente) {
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        try {
            em.getTransaction().begin();
            IPersistente obj = em.merge(persistente);
            em.remove(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException(e);
        } finally {
            em.close();
        }
    }
}
