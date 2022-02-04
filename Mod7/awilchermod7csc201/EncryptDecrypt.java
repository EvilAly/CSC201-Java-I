package awilchermod7csc201;

import java.io.*;
import java.util.*;

public class EncryptDecrypt {

	public static void main(String[] args) {
		ArrayList<String> code = new ArrayList<String>(); // for original file
		int choice = 0;
		while (choice != 9) {
			// offer menu
			choice = menu();

			// user picks option 1
			if (choice == 1) {
				code = readInFile();
				printFile(code);
				System.out.println("\nFile has been read in.\n");
			}
			// user picks option 2
			else if (choice == 2) {
				System.out.println("\nThe file reads as follows... \n");
				printFile(code);
			}
			// user picks option 3
			else if (choice == 3) {
				encryptFile(code);
				System.out.println("\nThe encrypted file reads as follows...\n");
				printFile(code);
			}
			// user picks option 4
			else if (choice == 4) {
				writeToFile(code);
			}
			// user picks option 5
			else if (choice == 5) {
				code.clear();
				System.out.println("\nData has been cleared.\n");
			}
			// user picks option 6
			else if (choice == 6) {
				code = readInFile();
				System.out.println("\nEncrypted File has been loaded.\n");
			}
			// user picks option 7
			else if (choice == 7) {
				decryptFile(code);
				System.out.println("\nEncrypted File has been decrypted.\n");

			}
			// user picks option 8
			else if (choice == 8) {
				System.out.println("\nThe decrypted file reads as follows...\n");
				printFile(code);
			}
			// user picks option 9
			else if (choice == 9) {
				System.out.println("Thank you.");
				System.exit(0);
			}
			// user picks an invalid menu option
			else {
				System.out.println("Entered choice is not available. Please choose a new number.");

			}

		}
	}

	public static int menu() {
		Scanner scan = new Scanner(System.in);
		System.out.println("\n");
		System.out.println("Please pick a menu option: ");
		System.out.println("     1.   Read in a file");
		System.out.println("     2.   Print the file to the console");
		System.out.println("     3.   Encrypt the file and write it to the console");
		System.out.println("     4.   Write out the encrypted file to a text file");
		System.out.println("     5.   Clear the data in memory");
		System.out.println("     6.   Read in an encrypted file");
		System.out.println("     7.   Decrypt the file");
		System.out.println("     8.   Write out the decrypted file to the console");
		System.out.println("     9.   End");

		// Ask for user's choice
		System.out.println("\nCHOICE: ");
		int num = scan.nextInt();

		// return choice to main program
		return num;
	}

	public static ArrayList<String> readInFile() {
		ArrayList<String> temp = new ArrayList<String>();
		// Get the filename.
		String filename = FileLoc.pickLocRead();
		// Open the file.
		File file = new File(filename);
		Scanner inputFile = null;
		try {
			inputFile = new Scanner(file);

			// Read lines from the file until no more are left.
			while (inputFile.hasNext()) {
				// Read the next line.
				String line = inputFile.nextLine();
				temp.add(line);
			}
		} catch (IOException ioe) {
			System.out.println("IO Exception.  Need to exit");
			System.exit(0);

		}
		//close file
		inputFile.close();
		return temp;

	}

	public static void printFile(ArrayList<String> f) {
		for (int i = 0; i < f.size(); i++) {
			System.out.println(f.get(i).toString());
		}

	}

	public static void encryptFile(ArrayList<String> f) {
		for (int num = 0; num < f.size(); num++) {
			String quote = f.get(num);
			String encrypt = "";
			for (int i = 0; i < quote.length(); i++) {
				char first = quote.charAt(i);
				if (first == ' ') {
					encrypt = encrypt + '*';
				} else if (i % 2 == 0) {
					char second = (char) (first + 1);
					encrypt = encrypt + second;
				} else if (i % 2 != 0) {
					char second = (char) (first - 1);
					encrypt = encrypt + second;
				}
			}
			f.set(num, encrypt);
		}

	}

	public static void writeToFile(ArrayList<String> f) {
		// Get the filename.
		String filename = FileLoc.pickLocOut();
		// Open the file.
		PrintWriter outputFile = null;

		try {
			outputFile = new PrintWriter(filename);

			// Get data and write it to the file.
			for (int i = 0; i < f.size(); i++) {
				String line = f.get(i);
				// Write each line.
				outputFile.println(line.toString());
			}

		} catch (IOException ioe) {
			System.out.println("IO Exception.  Need to exit");
			System.exit(0);

		} finally {
			// Close the file.
			outputFile.close();
		}
	}

	public static void decryptFile(ArrayList<String> f) {
		for (int num = 0; num < f.size(); num++) {
			String quote = f.get(num);
			String encrypt = "";
			for (int i = 0; i < quote.length(); i++) {
				char first = quote.charAt(i);
				if (first == '*') {
					encrypt = encrypt + ' ';
				} else if (i % 2 == 0) {
					char second = (char) (first - 1);
					encrypt = encrypt + second;
				} else if (i % 2 != 0) {
					char second = (char) (first + 1);
					encrypt = encrypt + second;
				}

			}
			f.set(num, encrypt);
		}

	}
}
