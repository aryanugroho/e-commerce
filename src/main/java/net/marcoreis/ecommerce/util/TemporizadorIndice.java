package net.marcoreis.ecommerce.util;

import org.quartz.Job;
import org.quartz.JobExecutionContext;

/**
 * Indexa os últimos registros atualizados na base de dados
 * 
 * @author marco
 *
 */
public class TemporizadorIndice {

	public class HelloJob implements Job {
		public void execute(JobExecutionContext context) {
			try {
				IndexadorECommerce indexador = new IndexadorECommerce();
				indexador.indexarNovosProdutos(1);
				indexador.fechar();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}
}
