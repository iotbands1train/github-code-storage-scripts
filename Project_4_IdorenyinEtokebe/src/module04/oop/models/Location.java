package module04.oop.models;

import module04.oop.randompms.MyRandomPersonData;

public class Location {
	private Long locationID;
	private Short streetNo;
	private String streetName;
	private String city;
	private String state;
	private Integer zip;
	public Location() {
		super();
		this.streetNo =(short) Math.abs( MyRandomPersonData.random(1, 21222) );
		this.streetName =  MyRandomPersonData.randomStreet();
		this.city =  MyRandomPersonData.randomCity();
		this.state =  MyRandomPersonData.randomState();
		this.zip = (int)Math.abs( MyRandomPersonData.random(21222, 92992) );
		//this.zip = 00_002;
		String combinedValue = streetNo + streetName + city + state + zip;
		this.locationID = charsDecimalValuesOfString(combinedValue);
	}
	public Location(Short streetNo, String streetName, String city, String state, Integer zip) {
		super();
		this.streetNo = streetNo;
		this.streetName = streetName;
		this.city = city;
		this.state = state;
		this.zip = zip;
		String combinedValue = streetNo + streetName + city + state + zip;
		this.locationID = charsDecimalValuesOfString(combinedValue);
	}
	private long charsDecimalValuesOfString(String input) {
	    long result = 0;
	    for (char c : input.toCharArray()) {
	        result += (long) c; // Adding the decimal value of the character
	    }
	    return result;
	}
	
	
	public Long getLocationID() {
		return locationID;
	}
	public void setLocationID(Long locationID) {
		this.locationID = locationID;
	}
	public Short getStreetNo() {
		return streetNo;
	}
	public void setStreetNo(Short streetNo) {
		this.streetNo = streetNo;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getZip() {
		return zip;
	}
	public void setZip(Integer zip) {
		this.zip = zip;
	}
	private String showZip() { 
		return String.format("%05d", zip); 
	}
	@Override
	public String toString() {
		return " Location [locationID=" + locationID + ", streetNo=" + streetNo + ", streetName=" + streetName
				+ ", city=" + city + ", state=" + state + ", zip=" + showZip() + "]";
	}


}
