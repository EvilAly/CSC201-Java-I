package awilchermod3csc201;

import java.util.Scanner;

//2 hours coding - stuck on .toString()
public class MonthDriver {

	public static void main(String[] args) {
		//Initialize scanner
		Scanner scan = new Scanner(System.in);
		
		//begin loop
		boolean another = true;
		while (another) {
						
			//Ask user for month
			System.out.println("Enter a month: (1-12)");
			int month = scan.nextInt();
			
			//Ask user for year
			System.out.println("Enter a four digit year: ");
			int year = scan.nextInt();
			
			//create instance
			MonthDays m1 = new MonthDays(month, year);
			
			int days = m1.getNumberOfDays();
						
			//result
			//print(m1.toString);
			System.out.println(days + " days");

			//user can end loop
			scan.nextLine();
			System.out.println("Try another? (true/false)");
			another = scan.nextBoolean();
		//end loop
		}
	}

}
