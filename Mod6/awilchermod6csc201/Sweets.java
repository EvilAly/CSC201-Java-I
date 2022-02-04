package awilchermod6csc201;

import java.text.NumberFormat;

/**
 * Sweets class used to describe a Sweet object
 */

public abstract class Sweets {
	/**
	 * Used to hold the type of sweet
	 */
	protected String type;

	/**
	 * Used to hold the cost of the sweet
	 */
	protected double cost;

	/**
	 * empty constructor
	 */
	public Sweets() {

	}

	/**
	 * Full constructor - used to create a new sweet
	 * 
	 * @param type - type of sweet
	 * @param cost - cost of sweet
	 */

	public Sweets(String type, double cost) {
		this.type = type;
		this.cost = cost;
	}

	// methods
	/**
	 * used to convert the object to a String output
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		return this.type + " costs " + nf.format(this.cost);
	}

	/**
	 * Calculates the Cost of the sweet
	 * 
	 * @return cost of sweet
	 */
	public abstract double calcCost();

	// getters and setters

	/**
	 * used to set the type of a sweet
	 * 
	 * @param type - the type of a sweet
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * used to get the type of sweet
	 * 
	 * @return the type of sweet
	 */

	public String getType() {
		return this.type;
	}

	/**
	 * used to set the cost of a sweet
	 * 
	 * @param cost - the cost of a given sweet
	 */

	public void setCost(double cost) {
		this.cost = cost;
	}

	/**
	 * used to get the cost of a sweet
	 * 
	 * @return cost of sweet
	 */

	public double getCost() {
		return this.cost;
	}

}
