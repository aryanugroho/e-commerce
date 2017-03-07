package net.marcoreis.ecommerce.entidades.teste;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.persistence.EntityManager;

import net.marcoreis.ecommerce.entidades.Atributo;
import net.marcoreis.ecommerce.entidades.Categoria;
import net.marcoreis.ecommerce.entidades.Produto;
import net.marcoreis.ecommerce.negocio.AtributoService;
import net.marcoreis.ecommerce.util.JPAUtil;

public class TesteCriacaoProdutos {
	private AtributoService service = new AtributoService();
	private List<Atributo> atributos = new ArrayList<Atributo>();
	private List<Categoria> categorias = new ArrayList<Categoria>();
	private EntityManager em;

	public TesteCriacaoProdutos() {
		atributos = service.carregarColecao(Atributo.class);
		categorias = service.carregarColecao(Categoria.class);
		em = JPAUtil.getInstance().getEntityManager();
	}

	public void criarProdutos(int total, int tempoEspera)
			throws InterruptedException {
		for (int i = 0; i < total; i++) {
			Produto p = new Produto();
			Date data = new Date();
			p.setDescricao(
					"Descrição do produto criado em " + data);
			p.setNome("Nome do produto criado em " + data);
			atribuiPreco(p);
			p.getAtributos().add(getAtributoRandomico());
			p.getCategorias().add(getCategoriaRandomica());
			//
			em.getTransaction().begin();
			em.merge(p);
			em.getTransaction().commit();
			Thread.sleep(tempoEspera);
		}
		em.close();
	}

	private void atribuiPreco(Produto p) {
		double random = ThreadLocalRandom.current()
				.nextDouble(100, 10000);
		p.setPreco(random);
	}

	private Categoria getCategoriaRandomica() {
		int random = ThreadLocalRandom.current().nextInt(0,
				categorias.size());
		return (Categoria) categorias.get(random);
	}

	private Atributo getAtributoRandomico() {
		int random = ThreadLocalRandom.current().nextInt(0,
				atributos.size());
		return (Atributo) atributos.get(random);
	}

	public static void main(String[] args)
			throws InterruptedException {
		TesteCriacaoProdutos t = new TesteCriacaoProdutos();
		t.criarProdutos(1000, 300);
	}
}
