package awilchermod4csc201;

import java.util.Arrays;

import mod4CSC201ArraysPrimitive.InsertionSort;

public class ArrayMethods {

	private int[] values;

//constructors
	public ArrayMethods() {

	}

	public ArrayMethods(int[] v) {
		this.values = v;
	}

//prints array on one line
	public String toString() {
		String text = " ";
		for (int i = 0; i < values.length; i++) {
			text = (text + values[i] + " ");
		}
		return text;
	}

//average values of the elements in array
	public double average() {
		double sum = 0;
		for (int i = 0; i < values.length; i++) {
			sum = sum + values[i];
		}
		return (sum / values.length);

	}

//swaps first and last element
	public void swapFirstAndLast() {
		int holder = values[0];
		int last = values.length - 1;
		values[0] = values[last];
		values[last] = holder;
	}

//shifts all elements right, last becomes first
	public void shift() {
		int holder = values[values.length - 1];
		for (int i = values.length - 1; i > 0; i--)
			values[i] = values[i - 1];
		values[0] = holder;

	}

//returns array with only even values
	public int[] evens() {
		int[] placeHolder = new int[100];
		int count = 0;
		for (int temp : values) {
			if (temp % 2 == 0) {
				placeHolder[count] = temp;
				count++;
			}
		}
		int[] even = new int[count];
		for (int i = 0; i < even.length; i++) {
			even[i] = placeHolder[i];
		}
		return even;
	}

//arranges evens to front, odds in back
	public int[] evenToFront() {
		int index = 0;
		int[] sort = new int[values.length];
		for (int i = 0; i < values.length; i++) {
			if (values[i] % 2 == 0) {
				sort[index] = values[i];
				index++;
			}
		}
		for (int i = 0; i < values.length; i++) {
			if (values[i] % 2 == 1) {
				sort[index] = values[i];
				index++;
			}
		}

		return sort;
	}

//is array sorted
//returns boolean
//prints where unsorted elements appear
	public boolean inOrder() {
		boolean order = true;
		int current;
		int last = 0;
		for (int i = 0; i < values.length; i++) {
			if (i == 0)
				last = values[i];
			else if (i != 0) {
				current = values[i];
				if (last > current) {
					System.out.println("The problem occurred first with " + last + " and " + current);
					return false;
				} else {
					last = current;
				}

			} else
				order = true;
		}
		return order;

	}

//returns 2nd largest value
//assumes no duplicates
	public int findSecondLargest() {
		int largest = values[0];
		int secondLargest = values[0];
		int thirdLargest = values[0];
		for (int i = 1; i < values.length; i++) {
			if (largest < values[i]) {
				thirdLargest = secondLargest;
				secondLargest = largest;
				largest = values[i];
			} else if (largest > values[i] && values[i] > secondLargest) {
				thirdLargest = secondLargest;
				secondLargest = values[i];
			} else if (secondLargest > values[i] && values[i] > thirdLargest) {
				thirdLargest = values[i];
			}
		}
		return secondLargest;
	}

//removes 2nd largest value
	public void removeValue(int value) {
		String edit = "";
		for (int i = 0; i < values.length; i++) {
			if (values[i] != value) {
				edit = edit + values[i] + " ";
			}
		}
		System.out.println(edit);
	}

//setters and getters
	public int[] getValues() {
		return values;
	}

	public void setValues(int[] values) {
		this.values = values;
	}
}
