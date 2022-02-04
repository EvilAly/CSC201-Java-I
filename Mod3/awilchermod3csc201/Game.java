package awilchermod3csc201;

import java.text.NumberFormat;

public class Game {

	private String gameName;
	private int numSold;
	private double priceEach;

	// constructors
	public Game() {

	}

	public Game(String n, double p) {
		gameName = n;
		priceEach = p;
		numSold = 0;
	}

	//methods
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		return ("There are " + numSold + " of the game " + gameName + " sold. Each costs " + nf.format(priceEach)) +
				" for a total value of " + nf.format(priceEach * numSold);
	}

	public void updateSales(int s) {
		this.numSold = numSold + s;
	}

	public double totalValue() {
		return priceEach * numSold;
	}

	// setters and getters
	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public int getNumSold() {
		return numSold;
	}

	public void setNumSold(int numSold) {
		this.numSold = numSold;
	}

	public double getPriceEach() {
		return priceEach;
	}

	public void setPriceEach(double priceEach) {
		this.priceEach = priceEach;
	}

}
