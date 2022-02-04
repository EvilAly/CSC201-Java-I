package awilcherMidterm;

import java.text.NumberFormat;
import java.util.*;


public class TileDriver {

	public static void main(String[] args) {
		//create scanner, ArrayList, and variables
		Scanner scan = new Scanner(System.in);
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		ArrayList<Tile> tiles = new ArrayList<Tile>();
		boolean more = true;
		int room = 1;
		int sqft;
		
		System.out.println("We are goign to estimate the cost to tile your home.");
		System.out.println("Are you a premier customer? (true/false)");
		boolean premier = scan.nextBoolean();
		
		//start while loop for rooms
		while (more) {
			//list room 
			System.out.println("Room #" + room);
			//get dimensions
			System.out.println("Length of floor: ");
			int len = scan.nextInt();
			System.out.println("Width of floor: ");
			int wid = scan.nextInt();
			System.out.println("Cost per square foot of tile: ");
			double cost = scan.nextDouble();
			
			Tile t = new Tile(len,wid,cost);
			tiles.add(t);
			
			//print summary of room
			System.out.println(t.toString());
			
			//calculate labor & tile cost of room
			double labor = t.costLabor();
			double costT = t.costTile();
			System.out.println("   The labor cost is " + nf.format(labor) + " and the tile cost is " + nf.format(costT));
			double total = labor + costT;
			System.out.println("The total cost for the job is " + nf.format(total));
			System.out.println("More rooms to add to the job? (true/false)");
			more = scan.nextBoolean();
			room++;
			
		}//end loop
		
		System.out.println("The total square footage of all the rooms is " + (totalSize(tiles)));
		double disc = net(totalCost(tiles), premier);
		if (disc == 0.15) {
			double due = totalCost(tiles) * 0.85;
			System.out.println("The cost with your discount is " + nf.format(due));
		}
		else if (disc == 0.10) {
			double due = totalCost(tiles) * 0.90;
			System.out.println("The cost with your discount is " + nf.format(due));
		}
		else {
			System.out.println("The cost is " + nf.format(totalCost(tiles)));
		}
		
	}
	
	public static int totalSize(ArrayList<Tile> t) {
		int total = 0;
		for (int i=0; i<t.size(); i++) {
			total = total + t.get(i).calcSquareFeet();
		}
		return total;
		
	}
	
	public static double totalCost(ArrayList<Tile> t) {
		double cost = 0;
		for (int j=0; j<t.size(); j++) {
			cost = cost + t.get(j).totalCost();
		}
		return cost;
		
	}
	
	public static double net(double a, boolean b) {
		double discount;
		if (a>3000 && b == true) 
			discount = 0.15;
		else if (a > 3000 || b == true) 
			discount = 0.10;
		else
			discount = 0;
		return discount;
	}

}
