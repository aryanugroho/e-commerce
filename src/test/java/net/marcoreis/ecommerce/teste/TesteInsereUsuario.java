package net.marcoreis.ecommerce.teste;

import java.util.Date;

import javax.persistence.EntityManager;

import net.marcoreis.ecommerce.entidades.Usuario;
import net.marcoreis.ecommerce.util.JPAUtil;

public class TesteInsereUsuario {
    public static void main(String[] args) {
	Usuario usuario = new Usuario();
	EntityManager em = JPAUtil.getInstance().getEntityManager();
	em.getTransaction().begin();
	usuario.setEmail("ma@marcoreis.net");
	usuario.setNome("Marco Reis 2");
	Date data = new Date();
	usuario.setUltimoLogin(data );
	em.persist(usuario);
	em.getTransaction().commit();
    }
}
