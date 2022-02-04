package awilcher_m5w2;

public class Die {
	
	//fields
	private int sides;
	private int value;
	
	//constructor
	public Die (int s) {
		this.sides = s;		
	}
	
	public void roll() {
		this.value = (int)(Math.random() * this.sides);
	}
	
	//getter & setter
	public int getSides() {
		return this.sides;
	}
	
	public int getValue() {
		return this.value;
	}

}
