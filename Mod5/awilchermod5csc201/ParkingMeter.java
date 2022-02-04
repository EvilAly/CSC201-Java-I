package awilchermod5csc201;

public class ParkingMeter {

	// fields
	private int numMinutesMax;
	private String meterNumber;

	// constructor
	public ParkingMeter() {

	}

	public ParkingMeter(int n, String m) {
		this.numMinutesMax = n;
		this.meterNumber = m;
	}

	// methods
	public String toString() {
		return (this.meterNumber + "(Max time allowed: " + this.numMinutesMax + " min)");
	}

	// setters and getters
	public int getNumMinutesMax() {
		return numMinutesMax;
	}

	public void setNumMinutesMax(int numMinutesMax) {
		this.numMinutesMax = numMinutesMax;
	}

	public String getMeterNumber() {
		return meterNumber;
	}

	public void setMeterNumber(String meterNumber) {
		this.meterNumber = meterNumber;
	}

}
