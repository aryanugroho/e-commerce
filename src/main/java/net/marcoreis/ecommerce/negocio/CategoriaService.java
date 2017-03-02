package net.marcoreis.ecommerce.negocio;

import java.util.List;

import javax.persistence.EntityManager;

import net.marcoreis.ecommerce.entidades.Categoria;
import net.marcoreis.ecommerce.util.IPersistente;
import net.marcoreis.ecommerce.util.JPAUtil;

public class CategoriaService extends GenericService {

	private static final long serialVersionUID = -1661348241777102035L;

	public List<Categoria> carregarCategorias() {
		EntityManager em = JPAUtil.getInstance()
				.getEntityManager();
		List<Categoria> categorias = em
				.createQuery("select c from Categoria c",
						Categoria.class)
				.getResultList();
		em.close();
		return categorias;
	}

}
