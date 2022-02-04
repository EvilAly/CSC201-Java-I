package awilchermod2csc201;

import java.util.Scanner;

//1.5 hour code
public class FunTimes {

	public static void main(String[] args) {
		//initialize scanner and variables
		Scanner scan = new Scanner(System.in);
		StringBuilder duplicate = new StringBuilder(String.valueOf(" "));
		int input = 0;
		int remain;
		int odd = 0;
		int even = 0;
		int small = 999999999;
		int large = -999999999;
		int last = -999; // to compare to last entry
		int count = 0; // count
		int sum = 0; // total value
		
		
		// start loop
		while (input != -999) {
			// Ask for number
			System.out.println("Please enter an integer (-999 to end)");
			input = scan.nextInt();

			// check number entered for -999
			if (input == -999 && count == 0) {
				System.out.println("You did not enter any numbers.");
			} else if (input == -999) {
				System.out.println("You entered " + count + " numbers. Your lowest number was " + small
						+ " and your highest number was " + large);
				System.out.println("There were " + odd + " odd numbers and " + even + " even numbers. ");
				System.out.println("The total value is " + sum);
				System.out.println("The adjacent duplicates are " + duplicate);
			} else {
				count++;
				sum = sum + input;
				remain = input % 2;
				if (remain == 0) {
					even++;
				} else {
					odd++;
				}
				if (small > input) {
					small = input;
				}
				if (large < input) {
					large = input;
				}
				if (last == -999) {
					last = input;
				} else {
					if (last == input) {
						duplicate.append(input + "  ");
						last = input;
					} else {
						last = input;
					}
				}
				
			}
		} // end loop

	}

}
