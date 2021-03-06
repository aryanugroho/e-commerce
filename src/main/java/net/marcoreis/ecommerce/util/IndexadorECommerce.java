package net.marcoreis.ecommerce.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.DateTools;
import org.apache.lucene.document.DateTools.Resolution;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;

import net.marcoreis.ecommerce.entidades.Atributo;
import net.marcoreis.ecommerce.entidades.Categoria;
import net.marcoreis.ecommerce.entidades.Produto;
import net.marcoreis.ecommerce.entidades.ProdutoAtributo;
import net.marcoreis.ecommerce.negocio.ProdutoService;

public class IndexadorECommerce {
	private static Logger logger = Logger
			.getLogger(IndexadorECommerce.class);
	private ProdutoService produtoService = new ProdutoService();
	private IndexWriter writer;
	private Directory diretorio;
	private Tika tika = new Tika();
	private String diretorioIndice = System.getProperty(
			"user.home") + "/livro-lucene/indice-produto";

	public void inicializar() throws IOException {
		Analyzer analyzer = new StandardAnalyzer();
		diretorio = FSDirectory.open(Paths.get(diretorioIndice));
		IndexWriterConfig conf = new IndexWriterConfig(analyzer);
		writer = new IndexWriter(diretorio, conf);
	}

	public void indexarProdutos()
			throws IOException, TikaException {
		List<Produto> produtos = produtoService
				.carregarColecao(Produto.class);
		for (Produto prod : produtos) {
			indexarProduto(prod);
		}
	}

	private void indexarProduto(Produto produto)
			throws IOException, TikaException {
		Document doc = new Document();
		StringBuilder textoCompleto = new StringBuilder();
		String especFabricante = "";
		if (produto.getEspecificacaoFabricante() != null) {
			ByteArrayInputStream bytes = new ByteArrayInputStream(
					produto.getEspecificacaoFabricante());
			especFabricante = tika.parseToString(bytes);
		}
		//
		preencherDadosProduto(produto, doc, especFabricante);
		preencherDadosCategoria(produto, doc, textoCompleto);
		preencherDadosAtributo(produto, doc, textoCompleto);
		preencherDadosTextoCompleto(produto, doc, textoCompleto,
				especFabricante);
		//
		writer.updateDocument(new Term("produto_id",
				produto.getId().toString()), doc);
	}

	private void preencherDadosTextoCompleto(Produto produto,
			Document doc, StringBuilder textoCompleto,
			String especFabricante) {
		textoCompleto.append(" ");
		textoCompleto.append(produto.getNome());
		textoCompleto.append(" ");
		textoCompleto.append(especFabricante);
		textoCompleto.append(" ");
		textoCompleto.append(produto.getDescricao());
		doc.add(new TextField("texto_completo",
				textoCompleto.toString(), Store.YES));
	}

	private void preencherDadosAtributo(Produto produto,
			Document doc, StringBuilder textoCompleto) {
		for (ProdutoAtributo pa : produto
				.getProdutoAtributos()) {
			doc.add(new TextField("atributo_nome",
					pa.getAtributo().getNome(), Store.YES));
			textoCompleto.append(" ");
			textoCompleto.append(pa.getAtributo().getNome());
			doc.add(new TextField("atributo_valor",
					pa.getValor(), Store.YES));
			textoCompleto.append(" ");
			textoCompleto.append(pa.getValor());
		}
	}

	private void preencherDadosCategoria(Produto produto,
			Document doc, StringBuilder textoCompleto) {
		for (Categoria categoria : produto.getCategorias()) {
			doc.add(new TextField("categoria_nome",
					categoria.getNome(), Store.YES));
			textoCompleto.append(" ");
			textoCompleto.append(categoria.getNome());
		}
	}

	private void preencherDadosProduto(Produto produto,
			Document doc, String especFabricante) {
		doc.add(new StringField("produto_id",
				produto.getId().toString(), Store.YES));
		String descricao = produto.getDescricao() == null ? ""
				: produto.getDescricao();
		doc.add(new TextField("produto_descricao", descricao,
				Store.YES));
		doc.add(new TextField("produto_nome", produto.getNome(),
				Store.YES));
		doc.add(new TextField("espec_fabricante",
				especFabricante, Store.YES));
		doc.add(new TextField("produto_preco",
				produto.getPreco().toString(), Store.YES));
		doc.add(new TextField("data_atualizacao",
				DateTools.dateToString(
						produto.getDataAtualizacao(),
						Resolution.MINUTE),
				Store.YES));
	}

	public void fechar() {
		try {
			writer.close();
			diretorio.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Indexa os produtos atualizados nos últimos minutos
	 * 
	 * @param tempoEmMinutos
	 * @throws IOException
	 * @throws TikaException
	 */
	public void indexarNovosProdutos(int tempoEmMinutos)
			throws IOException, TikaException {
		List<Produto> produtos = produtoService
				.consultarNovosProdutos(tempoEmMinutos);
		for (Produto produto : produtos) {
			indexarProduto(produto);
		}
		logger.info(produtos.size() + " produtos indexados");
	}

}
