package awilcherMidterm;

import java.text.DecimalFormat;

public class Deviation {

	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("##.##");
		//create array
		int[] values = {10, 12, 23, 23, 16, 23, 21, 16};
		//call mean method
		double mean = mean(values);
		//print results
		System.out.println("The average is " + mean);
		//call deviation method
		double dev = deviation(values);
		//print results
		System.out.println("The deviation is " + df.format(dev));

	}
	
	public static double mean(int[] a) {
		//create sum  and counter variable
		int sum = 0;
		int counter = 0;		
		//start loop to add up array
		for (int i=0; i<a.length; i++) {
			sum = sum + a[i];
			counter++;
		}//end loop
		//calculate mean
		double avg = sum/counter;
		//return result
		return avg;
		
	}
	
	public static double deviation(int[] a) {
		//create variables
		double variance = 0;
		int sum = 0;
		double total = 0;
		int counter = 0;
		//avg of all numbers
		for (int i=0; i<a.length; i++) {
			sum = sum + a[i];
			counter++;
		}
		double avg = sum/counter;
		//for each number, subtract avg, then square each resulting value, adding them up
		for (int i=0; i<a.length; i++) {
			double val = (a[i]); 
			total = total + Math.pow((val - avg), 2);
		}
		//divide by n-1
		double preSqRoot = total/(counter-1);
		
		//take the square root
		double dev = Math.sqrt(preSqRoot);
		
		//return result
		return dev;
	}

}
