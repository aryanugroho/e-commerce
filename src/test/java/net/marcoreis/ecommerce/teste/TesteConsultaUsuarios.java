package net.marcoreis.ecommerce.teste;

import java.util.List;

import javax.persistence.EntityManager;

import net.marcoreis.ecommerce.entidades.Usuario;
import net.marcoreis.ecommerce.util.JPAUtil;

public class TesteConsultaUsuarios {
    public static void main(String[] args) {
	EntityManager em = JPAUtil.getInstance().getEntityManager();
	List<Usuario> usuarios = em.createQuery("from Usuario").getResultList();
	for (Usuario usuario : usuarios) {
	    System.out.println("Nome: " + usuario.getNome());
	    System.out.println("Ultimo login: " + usuario.getUltimoLogin());
	}
    }
}
