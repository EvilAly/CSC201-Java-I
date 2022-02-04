package awilchermod5csc201;

public class ParkedCar {

	// fields
	private String make;
	private String licenseNum;
	private int numMinutes;
	private ParkingMeter meter;

	// constructors
	public ParkedCar() {

	}

	public ParkedCar(String m, String l, int n, ParkingMeter pm) {
		this.make = m;
		this.licenseNum = l;
		this.numMinutes = n;
		this.meter = pm;
	}

	// methods
	public String toString() {
		return (make + " (license plate: " + licenseNum + ") parked for " + numMinutes + " min at " + meter.toString());
	}

	// getters & setters
	public String getLicenseNum() {
		return this.licenseNum;
	}

	public void setLicenseNum(String l) {
		this.licenseNum = l;
	}

	public String getMake() {
		return this.make;
	}

	public void setMake(String m) {
		this.make = m;
	}

	public int getNumMinutes() {
		return this.numMinutes;
	}

	public void setNumMinutes(int n) {
		this.numMinutes = n;
	}

	public ParkingMeter getPm() {
		return this.meter;
	}

	public void setPm(ParkingMeter pm) {
		this.meter = pm;
	}
}
