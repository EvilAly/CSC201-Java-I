package awilchermod2csc201;
import java.util.Scanner;

//1 hour coded

public class RightTriangle {

	public static void main(String[] args) {
		// initialize scanner
		Scanner scan = new Scanner (System.in);
		
		//declare variables
		int sideA;
		int sideB;
		int sideC;
		int right = 0;
		boolean again = true;
		
		
		//Loop to count right triangles
		while (again) {
			
			boolean yes = false;
			//get sideA
			System.out.println("What is the length of your first side? ");
			sideA = scan.nextInt();
			if (sideA < 1) {
				System.out.println("This is not a positive integer. What is the length of your first side? ");
				sideA = scan.nextInt();
			}
			
			//get sideB
			System.out.println("What is the length of your second side? ");
			sideB = scan.nextInt();
			if (sideB < 1) {
				System.out.println("This is not a positive integer. What is the length of your second side? ");
				sideB = scan.nextInt();
			}
			
			//get sideC
			System.out.println("What is the length of your third side? ");
			sideC = scan.nextInt();
			if (sideC < 1) {
				System.out.println("This is not a positive integer. What is the length of your third side? ");
				sideC = scan.nextInt();
			}
			
			scan.nextLine();
			//determine longest side & if sides fit right triangle
			if (sideA > sideB && sideA > sideC) {
				if (((sideC * sideC) + (sideB * sideB)) == (sideA * sideA)) {
					yes = true;
					right = right + 1;
				}
			}
			else if (sideB > sideA && sideB > sideC) {
				if (((sideA * sideA) + (sideC * sideC)) == (sideB * sideB)) {
					yes = true;
					right = right + 1; 
				}
			}
			else if (sideC > sideA && sideC > sideB) {
				if (((sideA * sideA) + (sideB * sideB)) == (sideC * sideC)) {
					yes = true;
					right = right +1;
				}
			}
			if (yes) {
				System.out.println("This is a right triangle");
			}
			else {
				System.out.println("This is not a right triangle.");
				
			}
			
			//should the loop continue
			System.out.println("Do you want to continue? (yes or no) ");
			String ans = scan.nextLine();
			ans = ans.toUpperCase();
			again = (ans.equals("YES"));		
		
		}
		System.out.println("You have " + right + " right triangles.");

	}

}
