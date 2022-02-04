package awilcher_m2w2;

import java.util.Random;

public class MonkeyWrite {

	public static void main(String[] args) {
		// code statement
		System.out.println("Monkey Write - I verify that this is my code and I got zero help in any form!");

		// initiate variables
		Random rn = new Random();
		int num;
		String word = " ";
		int count = 0;
		int total = 0;
		int attempts = 0;

		// for loop
		for (int a=0; a<5; a++) {
			attempts++;
			// while loop
			while (!word.equals(" at")) {
				word = " ";

				// generate random number and assign letter
				for (int i = 0; i < 2; i++) {
					num = rn.nextInt(26);
					char letter = (char) (num + 'a');
					word = word + letter;
				}
				count++;
				System.out.println(word);

			}
			//end while loop
			
		}
		System.out.println("I found 'at' in run # " + attempts + " after " + count + " tries");
		total = total + count;
		//end for loop
				
		//calculate average number of attempts
		int avg = total / attempts;
		System.out.println("The average number of tries that it took was " + avg);
	}
	}

