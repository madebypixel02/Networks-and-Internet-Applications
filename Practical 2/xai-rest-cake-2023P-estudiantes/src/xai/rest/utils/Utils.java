package xai.rest.utils;

/**
 * @author Joan-Manuel Marques
 *
 */
public class Utils {
	public static double formataDosDecimals(double valor) {
		return (double) Math.round(valor * 100) / 100;
	}
}
