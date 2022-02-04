package awilchermod6csc201;

import java.util.Scanner;



public class SweetsDriver {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("How many desserts are there?");
		int numDes = scan.nextInt();

		// Create an array of Dessert references.

		Sweets[] sweets = new Sweets[numDes];
		int num = 0;

		while (num < sweets.length) {
			addADessert(sweets, num);
			num++;
		}

		printSweets(sweets);

	}

	public static void addADessert(Sweets[] yum, int num) {
		Scanner scan = new Scanner(System.in);
		System.out.println(
				"What is the description of the sweet # " + (num + 1) + "? (ex red velvet cake or oreo cookies)");
		String name = scan.nextLine();

		System.out.println("How much did it cost?");
		double cost = scan.nextDouble();
		System.out.println("Is it a (1) Cookie  (2) Piece of cake  (3) Whole cake ?");
		int which = scan.nextInt();
		if (which == 1) {
			System.out.println("How many cookies in a packages?");
			int amt = scan.nextInt();
			Cookies cook = new Cookies(name, cost, amt);
			yum[num] = cook;

		} else if (which == 2) {
			System.out.println("What is the weight of the piece of cake (oz)?");
			int amt = scan.nextInt();
			Cake cake = new Cake(name, cost, amt);
			yum[num] = cake;

		} else {
			System.out.println("What is the weight of the piece of cake (oz)?");
			int amt = scan.nextInt();
			System.out.println("How many pieces of cake in the whole cake?");
			int pieces = scan.nextInt();
			WholeCake cake = new WholeCake(name, cost, amt, pieces);
			yum[num] = cake;

		}
		System.out.println(yum[num].toString());
		num++;

	}

	public static void printSweets(Sweets[] yum) {
		System.out.println("\nHere are your sweets:");
		for (int index = 0; index < yum.length; index++) {
			System.out.println(yum[index]);
			System.out.println("----------------------------");
		}
	}

}
