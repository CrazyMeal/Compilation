package core;

import org.junit.Test;

public class ParkingParseTest {
	
	@Test
	public void test(){
		ParkingParser pp = new ParkingParser();
		pp.setUrlToParse("http://carto.strasmap.eu/remote.amf.json/Parking.status");
		pp.getDatas();
		pp.parse();
	}
}
