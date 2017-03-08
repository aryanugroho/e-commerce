package net.marcoreis.ecommerce.entidades.teste;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import javax.persistence.EntityManager;

import net.marcoreis.ecommerce.entidades.Atributo;
import net.marcoreis.ecommerce.entidades.Categoria;
import net.marcoreis.ecommerce.entidades.Produto;
import net.marcoreis.ecommerce.negocio.AtributoService;
import net.marcoreis.ecommerce.negocio.CategoriaService;
import net.marcoreis.ecommerce.util.JPAUtil;

public class TesteCriacaoProdutos {
	private AtributoService atributoService = new AtributoService();
	private CategoriaService categoriaService = new CategoriaService();
	private List<Atributo> atributos = new ArrayList<Atributo>();
	private List<Categoria> categorias = new ArrayList<Categoria>();
	private EntityManager em;

	public TesteCriacaoProdutos() {
		atributos = atributoService
				.carregarColecao(Atributo.class);
		categorias = categoriaService
				.carregarColecao(Categoria.class);
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
			byte[] especificacaoTeste = ("Especificação de teste do fabricante em "
					+ data).getBytes();
			p.setEspecificacaoFabricante(especificacaoTeste);
			atribuiPreco(p);
			preencherCategorias(p);
			preencherAtributos(p);
			p.setDataAtualizacao(data);
			//
			em.getTransaction().begin();
			em.merge(p);
			em.getTransaction().commit();
			Thread.sleep(tempoEspera);
		}
		em.close();
	}

	private void preencherAtributos(Produto p) {
		int random = ThreadLocalRandom.current().nextInt(1, 5);
		Set<Atributo> atributosAleatorios = new HashSet<Atributo>();
		for (int i = 0; i < random; i++) {
			atributosAleatorios.add(getAtributoRandomico());
		}
		p.getAtributos().addAll(atributosAleatorios);
	}

	/**
	 * Seleciona até 5 categorias aleatórias para cada produto
	 * 
	 * @param p
	 *            O produto que será associado às categorias
	 */
	private void preencherCategorias(Produto p) {
		int random = ThreadLocalRandom.current().nextInt(1, 5);
		Set<Categoria> categoriasAleatorias = new HashSet<Categoria>();
		for (int i = 0; i < random; i++) {
			categoriasAleatorias.add(getCategoriaRandomica());
		}
		p.getCategorias().addAll(categoriasAleatorias);
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
		t.criarProdutos(10000, 1000);
	}
}
