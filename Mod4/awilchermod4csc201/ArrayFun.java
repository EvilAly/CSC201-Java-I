package awilchermod4csc201;

import java.text.DecimalFormat;

//took approximately 4.5 hours to code and debug
public class ArrayFun {

	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("##.##");
		//create array
		int[] array = { 25, 35, 19, 23, 11, 5, 8, 30 };
		ArrayMethods arr = new ArrayMethods(array);
		
		//prints original array
		System.out.println("The original array: ");
		System.out.println(arr.toString());
		
		//prints the average
		System.out.println("\nThe average value of the elements in the array is " + df.format(arr.average()));
		
		//swaps first and last
		System.out.println("\nSwapping first and last: ");
		arr.swapFirstAndLast();
		System.out.println(arr.toString());
		
		//shifts all elements to the right, last becomes first
		System.out.println("\nShifting all elements to the right and the last becomes first: ");
		System.out.println("Code must have a single for loop");
		arr.shift();
		System.out.println(arr.toString());
		
		//all even values
		System.out.println("\nAll of the even values: ");
		int[] evens = arr.evens();
		String text = " ";
		for (int i=0; i<evens.length; i++) {
			text = (text + evens[i] + " ");
		}
		System.out.println(text);
		
		//array with all evens in front, odds at back
		//odds in same order as original
		System.out.println("\nA returned array that has all the evens in the front and");
		System.out.println("all odds in same order as original");
		int[] evenFronts = arr.evenToFront();
		String sort = " ";
		for (int i=0; i<evenFronts.length; i++) {
			sort = (sort + evenFronts[i] + " ");
		}
		System.out.println(sort);
		
		//check to see if array is sorted
		System.out.println("\nA check to see if the array is sorted");
		boolean order = arr.inOrder();
		if (order) {
			System.out.println("This array is in order");
		}
		
		
		//remove 2nd largest element
		System.out.println("\nRemove the second largest element of the array. You can assume no duplicates.");
		System.out.println("You are not allowed to sort the elements first");
		System.out.println("First find the element");
		int secLargest = arr.findSecondLargest();
		System.out.println("The second largest value was " + secLargest);
		System.out.println("Now remove it");
		arr.removeValue(secLargest);
		
	}
}
