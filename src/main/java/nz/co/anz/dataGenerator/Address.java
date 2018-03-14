package nz.co.anz.dataGenerator;

import java.util.concurrent.ThreadLocalRandom;

public class Address {
	private String unit;
	private String street;
	private String suburb;
	private String city;
	private String country;
	private String poBox;
	
	
	public String getUnit() {
		return unit;
	}
	
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getSuburb() {
		return suburb;
	}
	
	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getPoBox() {
		return poBox;
	}
	
	public void setPoBox(String poBox) {
		this.poBox = poBox;
	}

	public static Address address() {
		Address address = new Address();
		address.unit = getRandomUnit();
		address.street = "Lohia";
		address.suburb = "Khandallah";
		address.city = "Wellington";
		address.country = "NZ";
		address.poBox = getRandomPoBox();
		return address;
	}

	private static String getRandomUnit() {
		Integer number = ThreadLocalRandom.current().nextInt(1,1000);
		String[] suffixes = {"", "a", "b", "c", "d" };
		Integer suffixIndex = ThreadLocalRandom.current().nextInt(0, suffixes.length);
		return number + suffixes[suffixIndex];
	}
	
	private static String getRandomPoBox(){
		Integer number = ThreadLocalRandom.current().nextInt(1,1000);
		return Integer.toString(number); 
	}
	
}
