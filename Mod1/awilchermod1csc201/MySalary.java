package awilchermod1csc201;

import java.text.NumberFormat;

public class MySalary {

	public static void main(String[] args) {
		//Declare variables
		String myName;
		double hourlyWage;
		int hoursWorked;
		double totalSalary;
		
		//Assigns values to variables
		myName = "Aubrey";	
		hourlyWage = 21.16;	
		hoursWorked = 40;	
		totalSalary = hourlyWage * hoursWorked;		
		
		//Calculate netSalary
		double netSalary = .80 * totalSalary;
		
		//Print information for variables
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		System.out.println(myName + " worked " + hoursWorked + " hours at a rate of " + nf.format(hourlyWage) + " per hour for a total of "+
				nf.format(totalSalary) + " and a net salary of " + nf.format(netSalary));
		
	}

}
