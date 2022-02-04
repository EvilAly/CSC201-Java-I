package awilchermod4csc201;

import java.text.NumberFormat;

public class Wings {

	private String sauce;
	private boolean bones;
	private int num;
	private double costEach;

//constructors
	public Wings() {

	}

	public Wings(String s, boolean b, int n, double c) {
		sauce = s;
		bones = b;
		num = n;
		costEach = c;
	}

	public Wings(String s, boolean b) {
		sauce = s;
		bones = b;
	}

	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance(); 
		return "You bought " + num + " " + sauce + " wings which cost " + nf.format(costEach) + " each.";
		
	}

	public double totalCost() {
		double cost = costEach * num;
		return cost;
	}

	public String getSauce() {
		return sauce;
	}

	public void setSauce(String sauce) {
		this.sauce = sauce;
	}

	public boolean isBones() {
		return bones;
	}

	public void setBones(boolean bones) {
		this.bones = bones;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public double getCostEach() {
		return costEach;
	}

	public void setCostEach(double ce) {
		this.costEach = ce;
	}
}