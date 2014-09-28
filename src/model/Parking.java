package model;

public class Parking {
	private int id, avaiblePlaces, fullPlaces;
	private float longitude, latitude;
	private String name;
	private Status status;
	
	public Parking(){
		this.id = 0;
		this.avaiblePlaces = 0;
		this.fullPlaces = 0;
		this.longitude = 0;
		this.latitude = 0;
		this.name = "default";
		this.status = Status.CLOSE;
	}
	
	public Parking(int id, int avaiblePlaces, int fullPlaces, String name, String status){
		this.id = id;
		this.avaiblePlaces = avaiblePlaces;
		this.fullPlaces = fullPlaces;
		this.name = name;
		this.status = this.setStatus(status);
	}
	private Status setStatus(String status) {
		if(status.equals("status_1"))
			return this.status = Status.OPEN;
		if(status.equals("status_2"))
			return this.status = Status.FULL;
		if(status.equals("status_3"))
			return this.status = Status.UNAVAIBLE;
		if(status.equals("status_4"))
			return this.status = Status.CLOSE;
		
		return null;
	}

	public int getId() {
		return id;
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("Parking(" + this.id + "): " + this.name + "\n");
		sb.append("Avaible places: " + this.avaiblePlaces + "/" + this.fullPlaces +"\n");
		sb.append("Status: " + this.status + "\n");
		return sb.toString();
	}

	public int getAvaiblePlaces() {
		return avaiblePlaces;
	}

	public int getFullPlaces() {
		return fullPlaces;
	}

	public float getLongitude() {
		return longitude;
	}

	public float getLatitude() {
		return latitude;
	}

	public String getName() {
		return name;
	}

	public Status getStatus() {
		return status;
	}
}
