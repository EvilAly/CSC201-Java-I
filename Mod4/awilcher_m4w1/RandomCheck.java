package awilcher_m4w1;

import java.text.DecimalFormat;
import java.util.Random;

public class RandomCheck {

	public static void main(String[] args) {
		//create array and load random values
		int[] random;
		random = loadValues();

		//print values
		print(random);
		
		//average the numbers and print the average
		DecimalFormat df = new DecimalFormat("##.#");
		double avg = average(random);
		System.out.println("The average value is " + df.format(avg));
	}

	// creates array with 100 random values from 1-6
	public static int[] loadValues() {
		int[] a = new int[100];
		Random rn = new Random();
		for (int i = 0; i < a.length; i++) {
			a[i] = rn.nextInt(6)+1;
		}
		return a;
	}

	// prints the array
	public static void print(int[] a) {
		System.out.println("The values are: ");
		int count = 0;
		//print 20 indexes per line from the array
		for (int i = 0; i <a.length; i++) {
			System.out.print(a[i] + " ");
			count = count + 1;
			if (count % 20 == 0) {
				System.out.println("");
			}
		}
	}

	// averages the numbers in the array
	public static double average(int[] a) {
		double sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum = sum + a[i];
		}
		return (sum / a.length);
	}

}
