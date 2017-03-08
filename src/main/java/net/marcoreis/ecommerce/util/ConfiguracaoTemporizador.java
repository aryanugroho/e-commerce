package net.marcoreis.ecommerce.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ConfiguracaoTemporizador
		implements ServletContextListener {

	public void contextInitialized(ServletContextEvent event) {
		new TemporizadorIndice().iniciar();
	}

	public void contextDestroyed(ServletContextEvent event) {
	}

}
