package awilcher_m6q2;

public class Auto {

	// the Auto class has two fields
	private int year;
	private String make;
	private String model;
	private String vin;
	private double miles;
	

	// empty constructor
	public Auto() {

	}

	// full constructor
	public Auto(int year, String make, String model, String vin, double miles) {
		this.year = year;
		this.make = make;
		this.model = model;
		this.vin = vin;
		this.miles = miles;
	}

	// toString method (the wording does not make sense until you realize
	// that you will be calling this after calling the customer toString method
	public String toString() {
		return "a " + year + " " + make + " " + model + " with a VIN# of " + vin + " and a mileage of " + miles;

		// return "a car with a vin of " + vin + " and a mileage of " + miles;
	}

	// getters and setters
	public double getMiles() {
		return miles;
	}

	public void setMiles(double miles) {
		this.miles = miles;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	
}
