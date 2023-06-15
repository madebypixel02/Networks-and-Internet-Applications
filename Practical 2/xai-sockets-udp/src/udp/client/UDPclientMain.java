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

package udp.client;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.uoc.dpcs.lsim.logger.LoggerManager.Level;
import lsim.library.api.LSimLogger;
import lsim.library.api.LSimWorker;


/**
 * @author Joan-Manuel Marques
 *
 */

@SuppressWarnings("unused")
public class UDPclientMain {

	public static void main(String[] args) {
		LSimLogger.setLoggerAsLocalLogger("udp_client", "." + File.separator + "logs" + File.separator, true);

		LSimLogger.log(Level.INFO, "inici client");

		List<Key> keys = new ArrayList<Key>();
		keys.add(new Key("k1", "localhost", 5836));
		keys.add(new Key("k2", "localhost", 5838));
		keys.add(new Key("k3", "localhost", 5836));
		keys.add(new Key("k4", "localhost", 5836));
		

		RemoteMapUDPclient rm = new RemoteMapUDPclient();
		Map<String, String> map = rm.getMap(keys);

		LSimLogger.log(Level.INFO, "map: "+ map);
	}
}
