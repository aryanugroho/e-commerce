package net.marcoreis.ecommerce.controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import net.marcoreis.ecommerce.entidades.Usuario;
import net.marcoreis.ecommerce.util.JPAUtil;

import org.apache.log4j.Logger;

@SessionScoped
@ManagedBean
public class LoginBean extends BaseBean {
    private static final long serialVersionUID = 4169068378414919948L;
    protected static final Logger logger = Logger.getLogger(LoginBean.class);

    public String login() {
        try {
            EntityManager em = JPAUtil.getInstance().getEntityManager();
            String hql = "from Usuario u where u.email = :email";
            Query query = em.createQuery(hql);
            query.setParameter("email", getUsuario().getEmail());
            List<Usuario> usuarios = query.getResultList();
            Usuario usuario = usuarios.get(0);
            setUsuario(usuario);
            em.close();
            if (usuario != null) {
                return "inicio";
            } else {
                errorMsg("Usuário inválido");
                return null;
            }
        } catch (Exception e) {
            errorMsg("Usuário inválido");
            logger.error(e);
            return null;
        }
    }

    @PostConstruct
    public void init() {
        setUsuario(new Usuario());
    }

}
