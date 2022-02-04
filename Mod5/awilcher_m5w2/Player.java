package awilcher_m5w2;

public class Player {
	
	private String name;
	private int points;
	
	//contructors
	Player() {
		
	}
	
	Player (String n, int p) {
		this.name = n;
		this.points = p;
	}
	
	public String toString() {
		return this.name + ": " + this.points + " point(s)";
	}
	
	//getters & setters
	public String getName() {
		return this.name;
	}
	
	public int getPoints() {
		return this.points;
	}
	
	public void setName(String n) {
		this.name = n;
	}
	
	public void setPoints(int p) {
		this.points = p;
	}

}
