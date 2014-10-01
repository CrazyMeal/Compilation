package core;

import java.util.HashMap;
import java.util.Map.Entry;

import model.Parking;

public class Merger {
	
	public static HashMap<Integer,Parking> merge(HashMap<Integer,Parking> parkingList, HashMap<Integer,Parking> locationList){
		HashMap<Integer,Parking> finalList = new HashMap<Integer,Parking>();
		for(Entry<Integer, Parking> p : parkingList.entrySet()){
			Parking parkingValue = p .getValue();
			Parking tmpParking = new Parking(parkingValue.getId(), 
								parkingValue.getAvaiblePlaces(),
								parkingValue.getFullPlaces(), 
								parkingValue.getName(), 
								parkingValue.getStatus(),
								locationList.get(p.getKey()).getLongitude() ,
								locationList.get(p.getKey()).getLatitude());
			finalList.put(p.getKey(), tmpParking);
		}
		return finalList;
	}
}
