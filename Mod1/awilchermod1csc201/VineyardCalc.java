package awilchermod1csc201;
import java.util.Scanner;

public class VineyardCalc {

	public static void main(String[] args) {
		//initialize scanner for input
		Scanner scan = new Scanner(System.in);
		
		//define variables
		int length;
		int endSpace;
		int vineSpace;
		int numPerRow;
		
		//Ask user for variables
		System.out.println("Let's design our vineyard!");
		System.out.println("How long are the vineyard rows (in feet)? ");
		length = scan.nextInt();
		System.out.println("How much space is needed at each end (in feet)? ");
		endSpace = scan.nextInt();
		System.out.println("And how much space do you want between vines (in feet)? ");
		vineSpace = scan.nextInt();
		
		//calculate number per row
		numPerRow = (length - (2 * endSpace))/(vineSpace);
		
		//Report answer
		System.out.println("You can plant " + numPerRow + " in each row.");

	}

}
