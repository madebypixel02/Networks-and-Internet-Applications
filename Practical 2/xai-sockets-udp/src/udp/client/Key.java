package udp.client;

import java.io.Serializable;

/**
 * @author Joan-Manuel Marques
 *
 */
@SuppressWarnings("serial")
public class Key implements Serializable {
	private String key;
	private String server_address;
	private int server_port;
	
	public Key(String key, String server_address, int server_port) {
		this.key = key;
		this.server_address = server_address;
		this.server_port = server_port;
	}
	
	public String getKey() {
		return key;
	}

	public String getServerAddress() {
		return server_address;
	}
	
	public int getServerPort() {
		return server_port;
	}

	@Override
	public String toString() {
		return "Data [key=" + key + ", server_address=" + server_address + ", server_port=" + server_port + "]";
	}
}
