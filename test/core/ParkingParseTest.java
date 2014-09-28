package core;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map.Entry;

import model.Parking;

import org.junit.Test;

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
		pp.setUrlToParse("http://carto.strasmap.eu/remote.amf.json/Parking.status");
		pp.getDatas();
		HashMap<Integer,Parking> parkingList = pp.parse();
		assertEquals(26, parkingList.size());
		
		for(Entry<Integer, Parking> p : parkingList.entrySet()){
			System.out.println(p.toString());
		}
	}
}
