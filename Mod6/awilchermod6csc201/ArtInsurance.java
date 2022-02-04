package awilchermod6csc201;

import java.text.NumberFormat;

public class ArtInsurance extends Insurance {
	
	//get the art work being insured and the value of it
	private String artDescription;
	private double valueArtWork;
	
	//Full constructor
	public ArtInsurance(Customer cust, String desc, double value) {
		super(cust);
		this.artDescription = desc;
		this.valueArtWork = value;
		calcRate();
	}
	
	//empty constructor
	public ArtInsurance() {
		
	}
	
	//Constructor to read from a file
	public ArtInsurance(Customer cust, int polNum, double rate, String desc, double value) {
		super(cust, polNum, rate);
		this.artDescription = desc;
		this.valueArtWork = value;
	}
	
	//calculates rate
	public void calcRate() {
		yearlyRate = this.valueArtWork * .2;
	}
	
	//returns string to print
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		return super.toString() + " for art insurance. The art work is " + this.artDescription +", and the value is " + nf.format(this.valueArtWork)+".";
	}

	//getters and setters
	public String getArtDescription() {
		return artDescription;
	}

	public void setArtDescription(String artDescription) {
		this.artDescription = artDescription;
	}

	public double getValueArtWork() {
		return valueArtWork;
	}

	public void setValueArtWork(double valueArtWork) {
		this.valueArtWork = valueArtWork;
	}
	
	
	
	

}
