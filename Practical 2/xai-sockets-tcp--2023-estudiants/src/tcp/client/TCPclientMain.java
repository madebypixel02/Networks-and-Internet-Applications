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

import java.io.File;

import edu.uoc.dpcs.lsim.logger.LoggerManager.Level;
import lsim.library.api.LSimLogger;

/**
 * @author Joan-Manuel Marques
 *
 */

public class TCPclientMain {
	public static void main(String[] args) {
		LSimLogger.setLoggerAsLocalLogger("tcp_client", "." + File.separator + "logs" + File.separator, true);

		LSimLogger.log(Level.INFO, "start client http");

		HTTPclient http_client = new HTTPclient();
//		String response = http_client.head("localhost", 5436);
		String response = http_client.head("labxarxes.uoclabs.uoc.es", 80);
		
		LSimLogger.log(Level.INFO, response);		
	}
}
