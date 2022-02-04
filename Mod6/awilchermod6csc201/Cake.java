package awilchermod6csc201;

import java.text.NumberFormat;

public class Cake extends Sweets {
	// fields
	protected int weight;

	// constructors
	public Cake(String type, double cost, int wt) {
		super(type, cost);
		this.weight = wt;
	}

	public Cake() {

	}

	// methods
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		return super.toString() + " and a slice weighs " + this.weight + " ounces at a cost of "
				+ nf.format(this.calcCost()) + " per ounce";
	}

	public double calcCost() {
		double cost = this.cost / this.weight;
		return cost;
	}

	// getter and setter

	public void setWeight(int wt) {
		this.weight = wt;
	}

	public int getWeight() {
		return this.weight;
	}

}
