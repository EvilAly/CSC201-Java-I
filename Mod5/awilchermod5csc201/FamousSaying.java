package awilchermod5csc201;

import java.util.Arrays;
//2.5 hours - beatting head against issue w/ consonants

/*Write a class named FamousSaying with a single instance variable named saying that is a String. 
 *  Write the no-argument and full constructor and the getter and setter.   
 *  
 *   Fill in the methods below

*/
public class FamousSaying {

	// put in your instance variable and two constructors here
	private String saying;

	public FamousSaying() {

	}

	public FamousSaying(String s) {
		this.saying = s;
	}

	// The following are called stub methods. They essentially have the signature
	// and a set of braces.
	// To avoid red Xs, there is a place holder return line (I am returning the data
	// type that I promised in the signature
	// remove these lines after you add your code.

	// NOTE: Look at the UML diagram for the class
	// Study how my signatures below match the UML diagram for the methods.

	// a. The number of characters in the saying
	public int numChars() {
		return this.saying.length();

	}

	// b. The saying in all uppercase letters
	public String upper() {
		return this.saying.toUpperCase();
	}

	// c. The number of words in the saying
	public int numWords() {
		String[] c = this.saying.split(" ");
		return c.length;
	}

	// d. The most common occurring character in the saying
	// HINT: I would convert it to a character array and process that but you can
	// do whatever you like
	public char[] createArray() {
		// create character array
		String lower = this.saying.toLowerCase();
		char[] ch = new char[lower.length()];
		// copy characters into array
		for (int i = 0; i < lower.length(); i++) {
			ch[i] = lower.charAt(i);
		}
		return ch;
	}

	public char mostCommon() {
		// create array & sort
		char[] c = createArray();
		Arrays.sort(c);
		char mc = 1; // most common character
		int maxNum = 0;
		for (int i = 0; i < c.length - 1; i++) {
			int count = 0;
			if (c[i] != ' ') {
				if (mc == 1) {

					mc = c[i];
				}
				for (int j = 1; j < c.length; j++) {
					if (c[i] == c[j]) {
						count++;
					}
					if (maxNum < count) {
						mc = c[i];
						maxNum = count;
					}

				}
			}
		}
		return mc;

	}

	// e. the number of vowels in the string. Assume that y is always a vowel
	public int numVowels() {
		int vowels = 0;
		char[] c = createArray();
		for (int i = 0; i < c.length; i++)
			if (c[i] == 'a' || c[i] == 'e' || c[i] == 'i' || c[i] == 'o' || c[i] == 'u')
				vowels++;
		return vowels;
	}

	// f. the number of consonants in the string.
	public int numCons() {
		int chars =  numChars();
		int vow = numVowels();
		return (chars-vow);

	}

	// g. The character is passed in. Find out how many times that character exists
	// in the saying
	public int numTimes(char what) {
		int howManyWhat = 0;
		for (int i = 0; i < saying.length(); i++)
			if (saying.charAt(i) == what) {
				howManyWhat++;
			}
		return howManyWhat;

	}

	// h. A blank StringBuffer is created and our original string is processed and
	// copied to the
	// StringBuffer
	// all non letters are replaced by an X. The StringBuffer is returned as a
	// String
	public String replaceNonLetters() {
		StringBuffer say = new StringBuffer(this.saying);
		for (int i = 0; i < say.length(); i++) {
			char c = say.charAt(i);
			if (c == ' ') {
				say.replace(i, i, "X");
			}
		}

		return say.toString();
	}

	// put your getter and setter at the bottom
	public String getSaying() {
		return saying;
	}

	public void setSaying(String saying) {
		this.saying = saying;
	}

}
