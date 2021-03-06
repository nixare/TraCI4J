/*   
    Copyright (C) 2013 ApPeAL Group, Politecnico di Torino

    This file is part of TraCI4J.

    TraCI4J is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    TraCI4J is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with TraCI4J.  If not, see <http://www.gnu.org/licenses/>.
*/

package it.polito.appeal.traci;

import it.polito.appeal.traci.TraCIException.UnexpectedDatatype;
import it.polito.appeal.traci.protocol.Constants;
import de.uniluebeck.itm.tcpip.Storage;

public class Phase {
	private final int duration;
	private final TLState state;
	Phase(Storage content) throws UnexpectedDatatype {
		Utils.checkType(content, Constants.TYPE_INTEGER);
		duration = content.readInt();
		Utils.checkType(content, Constants.TYPE_INTEGER);
		content.readInt(); // duration 2 ignored
		Utils.checkType(content, Constants.TYPE_INTEGER);
		content.readInt(); // duration 3 ignored
		Utils.checkType(content, Constants.TYPE_STRING);
		state = new TLState(content.readStringASCII());
	}
	public Phase(final int duration, final TLState state) {
		this.duration = duration;
		this.state = state;
	}
	public int getDuration() {
		return duration;
	}
	public TLState getState() {
		return state;
	}
}