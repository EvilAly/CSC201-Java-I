package awilchermod5csc201;

import java.util.Scanner;

/* Demonstrate the class in a program named FamousSayingDriver that performs the following:

 a)	The user is asked to enter a string.
 b)	The program displays a menu giving the user a choice of the methods above. 
 The user should also have a choice of either entering another String or of exiting.
 c)	The program performs the operation selected by the user and repeats 
 until the user selects to exit the program.


 */

public class FamousSayingDriver {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// ask the user for a saying. Store it in a String named saying.
		System.out.println("What is your favorite famous saying? ");
		String s = scan.nextLine();
		// Create an instance of the FamousSayings class calling the full constructor. Name the
		// instance say.
		FamousSaying say = new FamousSaying(s);
		

		int choice = 0;
		while (choice != 999) {
			choice = menu();
			if (choice == 999) {
				System.out.println("Thanks for playing my game!");
				System.exit(0);
			} else if (choice == 9) {
				System.out.println("Give me a new quote to analyze");
				// ask for a new saying. Store it in a String named saying.
				// use the setter to update the value of the field in the say instance
				String saying = scan.nextLine();
				say.setSaying(saying);
				
			} else if (choice == 1) {
				System.out.println("The number of characters in the saying is " + say.numChars());
			} else if (choice == 2) {
				System.out.println("The quote in all upper case is " + say.upper());
			} else if (choice == 3) {
				System.out.println("The number of words in the saying is " + say.numWords());
			} else if (choice == 4) {
				System.out.println("The most frequent character in the saying is " + say.mostCommon());
			} else if (choice == 5) {
				System.out.println("The number of vowels in the saying is " + say.numVowels());
			} else if (choice == 6) {
				System.out.println("The number of consanants in the saying is " + say.numCons());
			} else if (choice == 7) {
				System.out.println("What character are you looking for?");
				String stWhich = scan.nextLine();
				char which = stWhich.charAt(0);
				System.out.println("The number of times the character '" + which + "' occurs in the saying is "
						+ say.numTimes(which));
			}
			else if (choice==8)
				System.out.println("Non letters replaced:  " + say.replaceNonLetters());

		}

	}

	public static int menu() {
		Scanner scan = new Scanner(System.in);
		System.out.println("\n Which of the following would you like:");
		System.out.println("1.  The number of characters in the saying");
		System.out.println("2.  The saying in all uppercase letters");
		System.out.println("3.  The number of words in the saying");
		System.out.println("4.  The most frequently occurring character in the saying");
		System.out.println("5.  The number of vowels in the string");
		System.out.println("6.  The number of consonants in the string");
		System.out.println("7.  To count the number of occurrences of a specific character in the string");
		System.out.println("8.  Print out the saying with any character that is not a letter replaces with an X");
		System.out.println("9.  Enter a new string");
		System.out.println("999.  Quit the program");

		System.out.println("CHOICE:");
		int choice = scan.nextInt();
		return choice;

	}

}
