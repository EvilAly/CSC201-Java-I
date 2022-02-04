package awilchermod3csc201;

import java.util.Scanner;

public class GameDriver {

	public static void main(String[] args) {
		// initialize scanner
		Scanner scan = new Scanner(System.in);
		
		// ask how many games
		System.out.println("How many games? ");
		int numOfGames = scan.nextInt();
		// ask how many stores
		System.out.println("How many stores? ");
		int numOfStores = scan.nextInt();
		scan.nextLine();

		// start loop w/ games as variable
		for (int i = 0; i < numOfGames; i++) {
			Game g1 = new Game();
			// ask/set name of game
			System.out.println("Game Name: ");
			g1.setGameName(scan.nextLine());

			// ask/set price
			System.out.println("Price Each: ");
			g1.setPriceEach(scan.nextDouble());

			// begin store loop
			for (int s = 1; s <= numOfStores; s++) {
				// how many games were sold
				System.out.println("STORE " + s + " Sales");
				System.out.println("How many " + g1.getGameName() + " were sold?");
				g1.updateSales(scan.nextInt());
				// allows String entry at beginning of loop
				scan.nextLine();
			} // end store loop
				// print summary
			System.out.println(g1.toString());
		} // end game loop

	}

}
