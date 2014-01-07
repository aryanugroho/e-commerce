package net.marcoreis.ecommerce.controlador;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;

import net.marcoreis.ecommerce.entidades.Categoria;
import net.marcoreis.ecommerce.util.JPAUtil;

@ManagedBean
@RequestScoped
public class CategoriaBean extends BaseBean {
    private static final long serialVersionUID = 861905629535769221L;
    private Categoria categoria;
    private Collection<Categoria> categorias;

    public void setCategoria(Categoria categoria) {
	this.categoria = categoria;
    }

    public Categoria getCategoria() {
	return categoria;
    }

    @PostConstruct
    public void init() {
	carregarCategorias();
	categoria = new Categoria();
    }

    public void salvar() {
	try {
	    EntityManager em = JPAUtil.getInstance().getEntityManager();
	    em.getTransaction().begin();
	    em.persist(getCategoria());
	    em.getTransaction().commit();
	    em.close();
	    infoMsg("Dados gravados com sucesso");
	} catch (Exception e) {
	    errorMsg(e);
	}
    }

    public void carregarCategorias() {
	EntityManager em = JPAUtil.getInstance().getEntityManager();
	categorias = em.createQuery("from Categoria").getResultList();
	em.close();
    }

    public Collection<Categoria> getCategorias() {
	return categorias;
    }

    public String editar(Categoria categoria) {
	this.categoria = categoria;
	return "categoria";
    }
}
