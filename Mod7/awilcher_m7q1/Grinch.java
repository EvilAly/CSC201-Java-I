package awilcher_m7q1;

import java.util.*;
import java.io.*;

public class Grinch {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// select file location
		String filename = FileLoc.pickLocRead();

		try {
			// open the file
			File file = new File(filename);
			Scanner inputFile = new Scanner(file);

			// Create ArrayLists to store lines
			ArrayList<String> story = new ArrayList<String>();
			ArrayList<String> tenthLines = new ArrayList<String>();

			// loop thru file adding non-blank lines
			while (inputFile.hasNext()) {
				String line = inputFile.nextLine();
				if (!line.isEmpty()) {
					story.add(line);
				}
			}
			// print number of lines
			System.out.println("\nThe Grinch has " + story.size() + " lines.\n");
			// Ask where to create new text file
			String tenth = FileLoc.pickLocOut();
			// print every 10th line into new file
			for (int i = 0; i < story.size(); i++) {
				if (i % 10 == 9) {
					String newLine = story.get(i);
					tenthLines.add(newLine);
				}
			}
			//open file
			PrintWriter tempFile =null;
			try {
				//associate temporary file with file location
				tempFile = new PrintWriter(tenth);
				//cycle thru ArrayList to add lines to file
				for (int j=0; j < tenthLines.size(); j++) 
					tempFile.println(tenthLines.get(j));				
			}
			catch (FileNotFoundException | InputMismatchException ex) {
				// Display an error message.
				System.out.println("Error processing the file.");
				System.exit(0);
			}
			

			// close files
			tempFile.close();
			inputFile.close();
		} catch (IOException ioe) {
			System.out.println("IO Exception.  Need to exit");
			System.exit(0);
		}
		// close scanner
		scan.close();
		// end program
		System.exit(0);

	}

}
