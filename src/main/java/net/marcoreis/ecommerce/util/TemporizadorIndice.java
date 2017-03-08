package net.marcoreis.ecommerce.util;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

/**
 * Indexa os últimos registros atualizados na base de dados
 * 
 * @author marco
 *
 */
public class TemporizadorIndice implements Runnable {
	private static Logger logger = Logger
			.getLogger(TemporizadorIndice.class);

	private final ScheduledExecutorService scheduler = Executors
			.newScheduledThreadPool(1);

	public void iniciar() {
		scheduler.scheduleAtFixedRate(this, 1, 30,
				TimeUnit.SECONDS);
	}

	public void run() {
		IndexadorECommerce indexador = new IndexadorECommerce();
		try {
			indexador.inicializar();
			indexador.indexarNovosProdutos(1);
		} catch (Exception e) {
			logger.error(e);
		} finally {
			indexador.fechar();
		}
	}

	public static void main(String[] args) {
		new TemporizadorIndice().iniciar();
	}

}
