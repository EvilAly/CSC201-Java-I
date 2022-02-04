package awilcher_m3w2;

import java.text.NumberFormat;

public class EnergyDrink {

	//four fields
	private String type;
	private int ounces;
	private int mgCaffeine;
	private double cost;

	
	//two constructors
	public EnergyDrink() {

	}

	public EnergyDrink(String t, int o, int mg, double c) {
		type = t;
		ounces = o;
		mgCaffeine = mg;
		cost = c;
	}

	//toString method
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		return "A " + ounces + " ounce " + type + " has " + mgCaffeine + " mg caffeine and costs " + nf.format(cost);
	}
	
// ******  you write two methods here.  Check the UML diagram for the signature of the 
	//methods.  The names are costPer100Mg() and mgPerOunce()
	//**********
	public double costPer100Mg() {
		double costPer = cost/(mgCaffeine/100);
		return costPer;
	}
	
	public double mgPerOunce() {
		double mgPer = mgCaffeine / ounces;
		return mgPer;
	}

	//getters and setters
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getOunces() {
		return ounces;
	}

	public void setOunces(int ounces) {
		this.ounces = ounces;
	}

	public int getMgCaffeine() {
		return mgCaffeine;
	}

	public void setMgCaffeine(int mg) {
		mgCaffeine = mg;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

}
