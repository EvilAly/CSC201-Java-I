package awilcher_m6q2;

public class SuperCar extends Auto {
	// fields to determine if car is a Sports Car and the max speed
	private boolean sportsCar;
	private int maxSpeed;

	// blank constructor
	public SuperCar() {

	}

	// full constructor
	public SuperCar(int year, String make, String model, String vin, double miles, boolean sports, int speed) {
		super(year, make, model, vin, miles);
		this.sportsCar = sports;
		this.maxSpeed = speed;
	}

	// to string
	public String toString() {
		return super.toString() + " has a max speed of " + this.maxSpeed;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	public boolean getSportsCar() {
		return this.sportsCar;
	}
	
	public void setSportsCar(boolean sports) {
		this.sportsCar = sports;
	}

}
