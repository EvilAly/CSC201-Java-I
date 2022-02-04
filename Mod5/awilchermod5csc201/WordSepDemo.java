package awilchermod5csc201;

import java.util.*;
//1.5 hour coded - struggled with getting I to work with everything else

public class WordSepDemo {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// ask user for sentence
		System.out.println(
				"Enter a sentence with no spaces between the words and the first letter of each word capitalized.");
		System.out.println("Example: StopAndSmellTheRoses");
		String words = scan.nextLine();

		// set instance
		WordSeparator ws = new WordSeparator(words);

		// separate words
		ws.separate();

		// print results
		System.out.println(ws.toString());

	}

}
