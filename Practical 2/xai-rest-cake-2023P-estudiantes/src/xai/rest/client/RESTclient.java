package xai.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import edu.uoc.dpcs.lsim.logger.LoggerManager.Level;
import lsim.library.api.LSimLogger;
//import edu.uoc.dpcs.lsim.logger.LoggerManager.Level;
//import lsim.library.api.LSimLogger;
import xai.rest.jettyserver.api.Volum;

/**
 * @author Joan-Manuel Marques
 *
 */

public class RESTclient {

	public double sup(String address, int port, float value1, float value2, float value3) {
		LSimLogger.log(Level.INFO, "http://"+address+":"+port+"/cake/sup/"+value1+"/"+value2+"/"+value3);
		LSimLogger.log(Level.INFO, "media type: text/plain");

		Client client = ClientBuilder.newClient();
		Response response = client.target("http://"+address+":"+port+"/cake/sup/"+value1+"/"+value2+"/"+value3).request("text/plain").get();
		double result = Double.parseDouble(response.readEntity(String.class));
		response.close();
		
		return result;
	}
	
	public double per(String address, int port, float value1, float value2, float value3) {
		LSimLogger.log(Level.INFO, "http://"+address+":"+port+"/cake/per/"+value1+"/"+value2+"/"+value3);
		LSimLogger.log(Level.INFO, "media type: application/json");

		Client client = ClientBuilder.newClient();
		Response response = client.target("http://"+address+":"+port+"/cake/per/"+value1+"/"+value2+"/"+value3).request("application/json").get();

    	Gson gson = new Gson();
    	double result = gson.fromJson(response.readEntity(String.class), Double.class);
    	response.close();
        
    	return result;
	}

	public Volum vol(String address, int port, float value1, float value2, float value3) {
		LSimLogger.log(Level.INFO, "http://"+address+":"+port+"/cake/vol/"+value1+"/"+value2+"/"+value3);
		LSimLogger.log(Level.INFO, "media type: application/json");
		
		Client client = ClientBuilder.newClient();
		Response response = client.target("http://"+address+":"+port+"/cake/vol/"+value1+"/"+value2+"/"+value3).request("application/json").get();

		Gson gson = new Gson();
		Volum result = gson.fromJson(response.readEntity(String.class), Volum.class);
		response.close();
		
		return result;
	}

}
