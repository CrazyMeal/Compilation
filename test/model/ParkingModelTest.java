package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class ParkingModelTest {
	
	@Test
	public void testParkingCreation(){
		Parking p = new Parking();	
		assertEquals(0, p.getId());
		assertEquals(0, p.getAvaiblePlaces());
		assertEquals(0, p.getFullPlaces());
		assertEquals(Status.CLOSE, p.getStatus());
		
		Parking p2 = new Parking(0, 0, 0, "default", "status_4");	
		assertEquals(0, p2.getId());
		assertEquals(0, p2.getAvaiblePlaces());
		assertEquals(0, p2.getFullPlaces());
		assertEquals(Status.CLOSE, p2.getStatus());
	}
}
