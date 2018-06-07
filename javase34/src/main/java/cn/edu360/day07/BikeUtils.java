package cn.edu360.day07;

import ch.hsr.geohash.GeoHash;

public class BikeUtils {

	public static String getOneData(double lng, double lat) {
		String data = GeoHash.withCharacterPrecision(lat, lng, 8).toBase32();
		return data;
	}

}
