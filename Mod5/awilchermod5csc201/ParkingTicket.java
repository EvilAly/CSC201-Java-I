package awilchermod5csc201;

import java.text.NumberFormat;

public class ParkingTicket {
	
	//fields
	private int minutesOver;
	private double fine;
	private ParkedCar car;
	private PoliceOfficer po;
	
	//constructors
	public ParkingTicket() {
		
	}
	public ParkingTicket(ParkedCar pc, PoliceOfficer po, int m) {
		this.car = pc;
		this.po = po;
		this.minutesOver = m;
		setFine(m);
	}
	
	//methods
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		return ("License " + this.car.getLicenseNum() + " parked at " + this.car.getPm().getMeterNumber() + ". Fine: " + nf.format(this.fine));
	}
	
	public void reportTicket() {
		
	}
	
	public void setFine(int m) {
		double total = 0;
		
		while (m >0) {
			if (total == 0) {
				total = 25;
				m = m - 60;
			}
			else {
				total = total + 10;
				m = m - 60;
			}
			
		}
		
		this.fine = total;
			
		
	}
	//getters and setters
	public ParkedCar getCar() {
		return car;
	}
	public void setCar(ParkedCar car) {
		this.car = car;
	}
	public PoliceOfficer getPo() {
		return po;
	}
	public void setPo(PoliceOfficer po) {
		this.po = po;
	}
	public int getMinutesOver() {
		return this.minutesOver;
	}
	public void setMinutesOver(int m) {
		this.minutesOver = m;
	}
	
	

}
