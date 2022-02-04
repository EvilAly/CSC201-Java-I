package awilchermod3csc201;

public class Insect {

	private String code;
	private String name;
	private int cost;

//constructors
	public Insect() {

	}

	public Insect(String c, String n, int m) {

		code = c;
		name = n;
		cost = m;
	}

	public String toString() {
		return ("Your " + name + " (" + code + ") snack costs " + cost + "Y");
	}

//setters and getters
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
}
