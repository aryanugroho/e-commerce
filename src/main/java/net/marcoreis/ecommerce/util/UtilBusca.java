package net.marcoreis.ecommerce.util;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;

public class UtilBusca {
	private static Logger logger = Logger
			.getLogger(UtilBusca.class.getName());
	private Directory diretorio;
	private IndexSearcher buscador;
	private IndexReader reader;
	private long duracaoBusca;
	private Integer quantidadeLimiteRegistros = 50;

	public void reopen() {
		try {
			// diretorio = FSDirectory.open(new
			// File(Constantes.DIRETORIO_INDICE));
			// reader = DirectoryReader.open(diretorio);
			buscador = new IndexSearcher(reader);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void fecha() {
		try {
			diretorio.close();
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
		try {
			reader.close();
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
	}

	private IndexSearcher getBuscador() throws IOException {
		return buscador;
	}

	public Document doc(int docID) throws IOException {
		Document doc = getBuscador().doc(docID);
		return doc;
	}

	public long getDuracaoBusca() {
		return duracaoBusca;
	}

	public TopDocs busca(String consulta) {
		TopDocs hits = null;
		try {
			long time = System.currentTimeMillis();
			QueryParser parser = null;
			Query query = parser.parse(consulta);
			hits = getBuscador().search(query,
					quantidadeLimiteRegistros);
			duracaoBusca = System.currentTimeMillis() - time;
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
		return hits;
	}

}
