package net.marcoreis.ecommerce.controlador;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.persistence.EntityManager;

import net.marcoreis.ecommerce.entidades.Cliente;
import net.marcoreis.ecommerce.util.JPAUtil;

@ViewScoped
@ManagedBean
public class ClienteBean extends BaseBean {
	private static final long serialVersionUID = -2658024901938874346L;
	private Collection<Cliente> clientes;

	@PostConstruct
	public void init() {
		carregarClientes();		
	}

	public void salvar() {
	}

	public void carregarClientes() {
		EntityManager em = JPAUtil.getInstance()
				.getEntityManager();
		clientes = em.createQuery("select c from Cliente",
				Cliente.class).getResultList();
		em.close();
	}

	public Collection<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Collection<Cliente> clientes) {
		this.clientes = clientes;
	}


}
