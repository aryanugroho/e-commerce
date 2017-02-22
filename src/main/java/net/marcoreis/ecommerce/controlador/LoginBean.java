package net.marcoreis.ecommerce.controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;

import net.marcoreis.ecommerce.entidades.Cliente;
import net.marcoreis.ecommerce.util.JPAUtil;

@SessionScoped
@ManagedBean
public class LoginBean extends BaseBean {
	private static final long serialVersionUID = 4169068378414919948L;
	protected static final Logger logger = Logger
			.getLogger(LoginBean.class);
	private boolean loggedIn;

	public String login() {
		try {
			EntityManager em = JPAUtil.getInstance()
					.getEntityManager();
			String sql = "select c from Cliente c where email = :email";
			TypedQuery<Cliente> query = em.createQuery(sql,
					Cliente.class);
			query.setParameter("email", getCliente().getEmail());
			List<Cliente> clientes = query.getResultList();
			Cliente cliente = clientes.get(0);
			setCliente(cliente);
			setLoggedIn(true);
			em.close();
			if (cliente != null) {
				return "inicio";
			} else {
				setLoggedIn(false);
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
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}
}
