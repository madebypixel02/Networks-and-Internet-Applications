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

package udp.servidor;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import edu.uoc.dpcs.lsim.logger.LoggerManager.Level;
import lsim.library.api.LSimLogger;

/**
 * @author Joan-Manuel Marques
 *
 */

public class UDPservidorMain{
	
	public static void main(String[] args) {
		LSimLogger.setLoggerAsLocalLogger("udp_servidor", "." + File.separator + "logs" + File.separator, true);

		LSimLogger.log(Level.INFO, "inici servidor");

		@SuppressWarnings("removal")
		int port = new Integer(args[0]);

		Map<String, String> map = new HashMap<String, String>();
		
		switch(port) {
		case 5836:
			map.put("k1", "R_k1");
			map.put("k3", "R_k3");
			map.put("k4", "R_k4");
			break;
		case 5838:
			map.put("k2", "R_k2");
			break;
		}
		
		new RemoteMapUDPservidor(port, map);
	}
}
