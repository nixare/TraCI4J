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

/**
 * 
 */
package it.polito.appeal.traci;

import it.polito.appeal.traci.protocol.Constants;

import java.io.DataInputStream;
import java.io.DataOutputStream;

import de.uniluebeck.itm.tcpip.Storage;

public class ChangeGlobalTravelTimeQuery extends ChangeObjectStateQuery {

	private int beginTime;
	private int endTime;
	private double travelTime;

	public ChangeGlobalTravelTimeQuery(DataInputStream dis, DataOutputStream dos,
			String edgeID) {
		super(dis, dos, Constants.CMD_SET_EDGE_VARIABLE, edgeID, Constants.VAR_EDGE_TRAVELTIME);
	}
	
	/**
	 * @param beginTime the beginTime to set
	 */
	public void setBeginTime(int beginTime) {
		this.beginTime = beginTime;
	}

	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	/**
	 * @param travelTime the travelTime to set
	 */
	public void setTravelTime(double travelTime) {
		this.travelTime = travelTime;
	}

	@Override
	protected void writeParamsTo(Storage content) {
		content.writeByte(Constants.TYPE_COMPOUND);
		content.writeInt(3);

		content.writeByte(Constants.TYPE_INTEGER);
		content.writeInt(beginTime);
		content.writeByte(Constants.TYPE_INTEGER);
		content.writeInt(endTime);
		content.writeByte(Constants.TYPE_DOUBLE);
		content.writeDouble(travelTime);
	}
}