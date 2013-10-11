package net.marcoreis.ecommerce.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import net.marcoreis.ecommerce.entidades.Usuario;
import net.marcoreis.ecommerce.util.JPAUtil;

@SessionScoped
@ManagedBean
public class LoginBean extends BaseBean {
    private static final long serialVersionUID = 4169068378414919948L;

    public String login() {
	try {
	    EntityManager em = JPAUtil.getInstance().getEntityManager();
	    Query query = em
		    .createQuery("from Usuario u where u.email = :email");
	    query.setParameter("email", getUsuario().getEmail());
	    Usuario usuario = (Usuario) query.getSingleResult();
	    setUsuario(usuario);
	    em.close();
	    if (usuario != null) {
		return "inicio?faces-redirect=true";
	    } else {
		errorMsg("Usuário inválido");
		return null;
	    }
	} catch (Exception e) {
	    errorMsg("Usuário inválido");
	    return null;
	}
    }
}
