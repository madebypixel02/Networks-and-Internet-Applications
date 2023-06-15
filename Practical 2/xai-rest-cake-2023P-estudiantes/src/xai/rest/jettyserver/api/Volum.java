package xai.rest.jettyserver.api;

import java.io.Serializable;

import xai.rest.utils.Utils;

/**
 * @author Joan-Manuel Marques
 *
 */
public class Volum implements Serializable{
	private static final long serialVersionUID = 1L;
	private static final double PI = 3.1416;

	float rad;
	float alt;
	float ang;
	double vol;
	
	public Volum (float rad, float alt, float ang){
		this.rad = rad;
		this.alt = alt;
		this.ang = ang;
		
		double radians = Math.toRadians(ang);
		double volume = (PI * Math.pow(rad, 2) * alt * radians) / 360;
		this.vol = Utils.formataDosDecimals(volume);  
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Volum other = (Volum) obj;
		if (alt != other.alt)
			return false;
		if (rad != other.rad)
			return false;
		if (ang != other.ang)
			return false;
		if (vol != other.vol)
			return false;
		
		return true;
	}

	@Override
	public String toString() {
		return "{rad=" + rad + ", alt=" + alt + ", ang=" + ang + ", vol="+ vol + "}";
	}
}
