package net.marcoreis.ecommerce.negocio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import net.marcoreis.ecommerce.entidades.Cliente;
import net.marcoreis.ecommerce.util.JPAUtil;

public class ClienteService {
	public Cliente carregarCliente(String email) {
		EntityManager em = JPAUtil.getInstance()
				.getEntityManager();
		String sql = "select c from Cliente c where email = :email";
		TypedQuery<Cliente> query = em.createQuery(sql,
				Cliente.class);
		query.setParameter("email", email);
		List<Cliente> clientes = query.getResultList();
		Cliente cliente = clientes.get(0);
		em.close();
		return cliente;
	}
}
