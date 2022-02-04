package awilchermod4csc201;

import java.text.NumberFormat;

public class Person {
	
	private String name;
	private int amt;
	private int year;
	
	//constructors
	public Person() {
		
	}
	public Person (String n, int a, int y) {
		name = n;
		amt = a;
		year = y;
	}
	
	public String toString() {
		return name;
	}
	
	//getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAmt() {
		return amt;
	}
	public void setAmt(int amt) {
		this.amt = amt;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
}
