package xai.rest.client.main;

import java.io.File;

import lsim.library.api.LSimLogger;
import xai.rest.client.RESTclient;
import xai.rest.utils.Utils;

/**
 * @author Joan-Manuel Marques
 *
 */

public class RESTclientMain {
	private static final double PI = 3.1416;
	private static final String IP_SERVIDOR = "localhost";
	private static final int PORT_SERVIDOR = 7070;
	
	public static void main(String[] args) throws Exception {
		LSimLogger.setLoggerAsLocalLogger("Rest_client", "." + File.separator + "logs" + File.separator, true);
		RESTclient rs = new RESTclient();
		
		float rad = 6.1f;
		float alt = 2.3f;
		float ang = 3.3f;
		System.out.println("per: " + Utils.formataDosDecimals(rs.sup(IP_SERVIDOR, PORT_SERVIDOR, rad, alt, ang)));
		System.out.println("sup: " + Utils.formataDosDecimals(rs.per(IP_SERVIDOR, PORT_SERVIDOR, rad, alt, ang)));
		System.out.println("volume\n: " + rs.vol(IP_SERVIDOR, PORT_SERVIDOR, rad, alt, ang));	
		
	}
}
