package awilchermod4csc201;

import java.util.ArrayList;

//1.7 hours coded
public class CookiesDriver {

	public static void main(String[] args) {

		// always make your array lists generic
		ArrayList<Cookies> candy = new ArrayList<Cookies>();
		candy.add(new Cookies("Oreos", 12, 2.50));
		candy.add(new Cookies("Macaroon", 5, 1.35));
		candy.add(new Cookies("Chocolate Chip", 12, .80));
		candy.add(new Cookies("Peanut Butter", 4, 1.90));
		candy.add(new Cookies("Macaroon", 5, 1.35)); // I know it is here multiple times
		candy.add(new Cookies("Macaroon", 5, 1.35));
		candy.add(new Cookies("Macaroon", 5, 1.35));
		candy.add(new Cookies("Biscotti", 12, 1.90));
		candy.add(new Cookies("Sugar", 16, 1.90));

		// you could use the following to print out all of the cookies
		// System.out.println(cookies);
		// but these puts the entire collection in [ ] and we do not want that
		// It is better to do it explicitly yourself!!

		// I have written a method at the bottom to print just the names so we do not
		// have to keep
		// repeating the code

		print(candy);

		// I want to add an Oatmeal Raisin at the end (the default location)
		candy.add(new Cookies("Oatmeal Raisin", 12, 2.55));

		// now add a Gingerbread cookie between the Oreos and first Macaroon
		// I use the overloaded method to tell it the location of where I want it
		candy.add(1, new Cookies("Gingerbread", 10, 2.30));

		// print the names again by calling our method
		print(candy);

		// remove the Peanut Butter. But I first have to find where it is

		// try
		Cookies c = new Cookies("Peanut Butter", 4, 1.90);
		int location = candy.indexOf(c);
		System.out.println(location);

		// but location shows as -1 which means it does not exist
		// It is looking for the object - not an object with the same values
		// for the fields. Since they are not the same object, it is not
		// found. Java returns a -1 for the location of unsuccessful searches.
		System.out.println("Removing the Peanut Butter...");
		for (int i = 0; i < candy.size(); i++) {
			c = candy.get(i);
			if (c.getType().equals("Peanut Butter"))
				candy.remove(i);
		}

		// That works!! Check it out
		print(candy);
		System.out.println();

		/////// NOW YOU FINISH THESE!!!! FIND METHODS FOR THESE!!

		System.out.println("\n\n\n****  Here is where I am starting ****");
		System.out.print("The last item in the list is ");

		// print out the toString() for the last item in the list
		int numOfItems = candy.size() - 1;
		Cookies lastItem = candy.get(numOfItems);
		System.out.println(lastItem.toString());

		// remove all of the locations of Macaroon
		for (int i = candy.size() - 1; i > -1; i--) {
			c = candy.get(i);
			if (c.getType().equals("Macaroon"))
				candy.remove(i);
		}

		// print out all of the names of the cookies
		System.out.println("With the macaroon's gone: ");
		print(candy);
		// print out how many items there are currently in the collection
		System.out.println("There are now " + candy.size() + " items in the collection.");

		// Print the name of all cookies that come by the dozen on one line - have
		// numInPck as 12
		// you need to find it first - you cannot just counts in the ArrayList to find
		// its location
		System.out.print("Those with 12 in a package:  ");
		for (int i = 0; i < candy.size(); i++) {
			c = candy.get(i);
			int num = c.getNumInPck();
			if (num == 12)
				System.out.print(candy.get(i).getType() + "  ");

		}
		System.out.println();
		// print out all of the name of cookies that start with the letter O. Print them
		// out all in capitals
		// HINT!!! There is no single method for this.
		// You will need to loop through the ArrayList getting
		// each entry's name and checking to see if the string starts with an S.
		System.out.print("Names beginning with O  ");
		for (int i = 0; i < candy.size(); i++) {
			c = candy.get(i);
			String name = c.getType();
			if (name.startsWith("O"))
				System.out.print(name.toUpperCase() + "   ");

		}
		System.out.println();

		// clear out all the members of the ArrayList
		for (int i = candy.size() - 1; i > -1; i--) {
			candy.remove(i);
		}

		// print out the ArrayList now and the size now.*/
		System.out.println("Now I remove all of the items. Here is my ArrayList and its size:");
		print(candy);

	}

	public static void print(ArrayList<Cookies> c) {
		for (int i = 0; i < c.size(); i++)
			System.out.print(c.get(i).getType() + "  ");
		System.out.println();
	}

}
