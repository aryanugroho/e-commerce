package net.marcoreis.ecommerce.util;

import java.io.IOException;

import org.apache.tika.exception.TikaException;
import org.junit.Test;

public class TesteIndexadorECommerce {

	@Test
	public void testarIndexarTodosProdutos()
			throws IOException, TikaException {
		IndexadorECommerce indexador = new IndexadorECommerce();
		indexador.indexarProdutos();
		indexador.fechar();
	}
}
