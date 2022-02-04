package awilchermod1csc201;

import java.text.DecimalFormat;

public class EastCoastBaseball {

	public static void main(String[] args) {
		
		// define the following variables.  You decide
		// the data types (but remember my comments from our module 1 documentation).
		//  Write your line of code after
		// my comment and LEAVE my comments in for
		// documentation. Do this in all of your submissions
		
		// a variable named teamName that represents the first team
			String teamName	;
		// a variable named numGames that represents the number of games played by the first team
			int numGames;	
		//a variable named wins that represents the number of wins for that team 
			int wins;
		// a variable named teamName2 that represents the second team
			String teamName2;
		// a variable named numGames2 that represents the number of games played by the second team
			int numGames2;			
		//a variable named wins2 that represents the number of wins for that team 
			int wins2;
		
		
		// Set the value of the variables.  Let's do the calculation for the 
		// Washington National and the Baltimore Orioles in the 2019 baseball season.  
		//They played 162 games.  Washington won 93 and Baltimore won 54
			teamName = "Washington Nationals";
			teamName2 = "Baltimore Orioles";
			numGames = 162;
			numGames2 = 162;
			wins = 93;
			wins2 = 54;
				
		// Now create the variables named percentWins and percentWins2 and use it to store 
		// the calculation of the percentage of wins for each team
		// See the Integer division program for a discussion of integer division.
			double percentWins, percentWins2;
			percentWins = (((1.0 * wins)/numGames)*100);
			percentWins2 = (((1.0 * wins2)/numGames2)*100);
		
		// create a variable named moreWins that calculates how many more wins Washington had than Baltimore
			int moreWins;
			moreWins = (wins - wins2);
				
		// Have your program print out a statements that 
		// summarizes the above information.  It should say
		// "The Washington Nationals won 93 games in 2019.  They played 162.   
		// That gave them a winning percentage of 57%."
		// "The Baltimore Orioles won 54 games in 2019.  They played 162.   
		// That gave them a winning percentage of 33%
		// The Washington Nationals won 39 more games than the Baltimore Orioles
		// Print your answers to, at most, one decimal
			DecimalFormat df = new DecimalFormat("##.0");
		//We will address this in our formattingOutput package
			System.out.println("The " + teamName + " won " + wins + " games in 2019. They played " + numGames +".");
			System.out.println("That gave them a winning percentage of " + df.format(percentWins) + "%.");
			System.out.println("\nThe " + teamName2 + " won " + wins2 + " games in 2019. They played " + numGames2 +".");
			System.out.println("That gave them a winning percentage of " + df.format(percentWins2) + "%.");
			System.out.println("\nThe " + teamName + " won " + moreWins + " more games than the " + teamName2 + ".");
	}
}
