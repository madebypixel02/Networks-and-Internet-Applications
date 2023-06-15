package xai.rest.servidor.main;

import java.io.File;

import lsim.library.api.LSimLogger;
import xai.rest.jettyserver.JettyWebServer;

/**
 * 
 * @author Joan-Manuel Marques
 *
 */
public class RESTserverMain {
	public static void main(String[] args) {
		LSimLogger.setLoggerAsLocalLogger("Rest_servidor", "." + File.separator + "logs" + File.separator, true);
		JettyWebServer jws = new JettyWebServer(7070);
		jws.run();
		jws.stopJettyServerAfter(30000);
	}
}