package awilcher_m5w2;

import java.util.*;

public class FirstToOneGame {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String name;
		Die d = new Die(10);

		// how many players
		System.out.println("How many players (2-5)");
		int numOfPlayers = scan.nextInt();
		Player[] play = new Player[numOfPlayers];
		scan.nextLine();

		for (int i = 0; i < numOfPlayers; i++) {
			System.out.println("Name of player #" + (i + 1));
			name = scan.nextLine();
			play[i] = new Player(name, 50);
		}

		boolean winner = false;
		// play game (while loop)
		while (!winner) {
			takeTurn(play, 10, d);
			System.out.println(" ");

			// determine if game has ended
			winner = gameInPlay(play);

		}

		// who won?
		determineWinner(play);
	}

	public static boolean gameInPlay(Player[] p) {
		boolean done = false;
		for (int i = 0; i < p.length; i++)
			if (p[i].getPoints() == 1)
				done = true;
		return done;
	}

	public static void takeTurn(Player[] p, int n, Die d) {
		int roll = 0;
		for (int i = 0; i < p.length; i++) {
			d.roll();
			roll = d.getValue();
			if ((p[i].getPoints() - roll) < 1) {
				p[i].setPoints(p[i].getPoints() + roll);
				System.out.println(
						p[i].toString() + "  Roll:" + roll + "   ADDING.....     New Points:  " + p[i].getPoints());

			} else {
				p[i].setPoints(p[i].getPoints() - roll);
				System.out.println(p[i].toString() + "   Roll:" + roll + "   SUBTRACTING.....    New Points:  "
						+ p[i].getPoints());
			}
		}
	}

	public static void determineWinner(Player[] p) {
		String[] winner = new String[p.length];
		int count = 0;
		for (int i = 0; i < p.length; i++) {
			if (p[i].getPoints() == 1) {
				winner[count] = p[i].getName();
				count++;

			}
		}

		if (count == 1) {
			System.out.println("-----------------------------------------------------");
			System.out.println("The game was won by " + winner[0]);
			System.out.println("-----------------------------------------------------");
		} else {
			System.out.println("There are " + count + " winners!! Congratulations to: ");
			for (int i = 0; i < count; i++)
				System.out.print(winner[i] + " ");
			System.out.println();

		}

	}

}
