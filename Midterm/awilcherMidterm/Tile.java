package awilcherMidterm;

import java.text.NumberFormat;

public class Tile {
	
	private int length;
	private int width;
	private double costPerSqFoot;
	private static final double LABOR_COST = 15.00;
	private static final int SQFT_PERHOUR = 20;
	
	
	//constructiors
	public Tile() { 
		
	}
	
	public Tile (int len, int wid, double cost) {
		length = len;
		width = wid;
		costPerSqFoot = cost;
	}
	
	//methods
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		return "The room is " + length + " feet long, " + width + 
				" feet wide. The cost of the tile per square foot is " + nf.format(costPerSqFoot);
	}
	
	//calculate the sqaure feet of space in the room
	public int calcSquareFeet() {
		int sqft = length * width;
		return sqft;
	}
	
	//labor cost for tiling the room
	public double costLabor() {
		double labCost = LABOR_COST * ((1.0*calcSquareFeet()) / (1.0*SQFT_PERHOUR));
		return labCost;		
	}

	//cost of the tile for the room
	public double costTile() {
		double tileCost = calcSquareFeet() * costPerSqFoot;
		return tileCost;
		
	}
	
	//total cost of tile and labor
	public double totalCost() {
		double total = costLabor() + costTile();
		return total;
		
	}

	//getters and setters
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public double getCostPerSqFoot() {
		return costPerSqFoot;
	}

	public void setCostPerSqFoot(double costPerSqFoot) {
		this.costPerSqFoot = costPerSqFoot;
	}
	
	
	

}
