package core;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map.Entry;

import model.Parking;

import org.json.simple.JSONValue;
import org.junit.Test;

import util.Util;

public class ParkingParseTest {
	
	@Test
	public void getDatasFromWeb(){
		ParkingParser pp = new ParkingParser();
		pp.setUrlToParse("http://carto.strasmap.eu/remote.amf.json/Parking.status");
		pp.getDatas();

	}
	
	@Test
	public void parseDatasFromWeb(){
		ParkingParser pp = new ParkingParser();
		LocationParser lp = new LocationParser();
		
		pp.setUrlToParse("http://carto.strasmap.eu/remote.amf.json/Parking.status");
		pp.getDatas();
		
		lp.setUrlToParse("http://carto.strasmap.eu/remote.amf.json/Parking.geometry");
		lp.getDatas();
		
		HashMap<Integer,Parking> parkingList = pp.parse();
		assertEquals(26, parkingList.size());
		
		HashMap<Integer,Parking> locationList = lp.parse();
		assertEquals(26, locationList.size());
		
		HashMap<Integer,Parking> finalList = Util.merge(parkingList, locationList);
		/*
		for(Entry<Integer, Parking> p : finalList.entrySet()){
			System.out.println(p.getValue().toString());
		}
		*/
		System.out.println(Util.getJSONString(finalList));
	}
}
