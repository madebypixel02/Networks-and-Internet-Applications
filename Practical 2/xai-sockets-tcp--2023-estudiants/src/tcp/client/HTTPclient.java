/*

* Copyright (c) Joan-Manuel Marques 2013. All rights reserved.
* DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
*
* This file is part of the practical assignment of Distributed Systems course.
*
* This code is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This code is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this code.  If not, see <http://www.gnu.org/licenses/>.
*/

package tcp.client;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

import edu.uoc.dpcs.lsim.logger.LoggerManager.Level;
import lsim.library.api.LSimLogger;


/**
 * @author Joan-Manuel Marques
 *
 */

public class HTTPclient {

	public HTTPclient() {
	}
			
	public String head(String http_server_address, int http_server_port){
		LSimLogger.log(Level.INFO, "start HTTPclient.head ");
		LSimLogger.log(Level.INFO, "HTTP server_address: " + http_server_address);
		LSimLogger.log(Level.INFO, "HTTP server_port: "    + http_server_port);

		/* Complete code  */
		
		String peticio = "HEAD /xai/xai.html HTTP/1.0\r\n" +
		                 "Host: labxarxes.uoclabs.uoc.es\r\n" +
		                 "Accept: */*\r\n\r\n";

	   	LSimLogger.log(Level.INFO, peticio);

	   	String resposta = "";
		Socket socket;
		try {
			socket = new Socket(http_server_address, http_server_port);
			LSimLogger.log(Level.INFO, "Socket created");
			OutputStream output = socket.getOutputStream();
		   	PrintWriter writer = new PrintWriter(output, true);
		   	writer.println(peticio);
			LSimLogger.log(Level.INFO, "Request sent");

		   	BufferedReader inputFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		   	String linia ;
		   	while ((linia = inputFromServer.readLine()) != null) {
		   		resposta += linia + "\r\n";
		   		LSimLogger.log(Level.TRACE, linia);
		   	}
		   	
		   	socket.close();

			LSimLogger.log(Level.INFO, "Response: " + resposta);
		} catch (SocketException e) {
			LSimLogger.log(Level.FATAL, e.getMessage());
			e.printStackTrace();
		} catch (UnknownHostException e) {
			LSimLogger.log(Level.FATAL, e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			LSimLogger.log(Level.FATAL, e.getMessage());
			e.printStackTrace();
		}
		
		return resposta;
	}
}
