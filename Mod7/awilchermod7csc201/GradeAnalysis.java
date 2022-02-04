package awilchermod7csc201;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

import readWriteFiles.FileLoc;

public class GradeAnalysis {

	public static void main(String[] args) {
		// create AL to read grades into
		ArrayList<Integer> grades = new ArrayList<Integer>();

		// Get the filename.
		String filename = FileLoc.pickLocRead();
		// Open the file.
		File file = new File(filename);
		Scanner inputFile = null;

		try {
			inputFile = new Scanner(file);

			// read file into ArrayList
			loadArray(inputFile, grades);

			// sort grades
			Collections.sort(grades);
			// print grades
			printGrades(grades);
			// minimum, maximum, and average grade
			minMaxAvg(grades);
			// print grade distribution
			distGrades(grades);
		} catch (IOException ioe) {
			System.out.println("IO Exception.  Need to exit");
			System.exit(0);
		} finally {
			inputFile.close();
		}
		System.exit(0);
	}

	// method to load grades into ArrayList
	public static void loadArray(Scanner i, ArrayList<Integer> g) {
		while (i.hasNext()) {
			// Read the next line
			String line = i.nextLine();
			// create a StringTokenizer and break the line at the spaces
			StringTokenizer st = new StringTokenizer(line, " ");
			// while the line has more "tokens" or values
			while (st.hasMoreTokens()) {
				// get the next one and convert it to an int
				int grade = Integer.parseInt(st.nextToken().trim());
				g.add(grade);
			}
		}

	}

	// method to print out values 10 per row
	public static void printGrades(ArrayList<Integer> g) {
		int count = 0;
		if (g.get(0) < 0 || g.get(g.size() - 1) > 100) {
			System.out.println("\nThere are invalid grades in this file. This program will now end.");
			System.exit(0);
		}
		System.out.println("\nYour grades: ");
		for (int i = 0; i < g.size(); i++) {
			System.out.print(g.get(i) + " ");
			count = count + 1;
			if (count % 10 == 0) {
				System.out.println("");
			}
		}
	}

	// method to determine the minimum grade, the maximum grade, and the average
	public static void minMaxAvg(ArrayList<Integer> g) {
		DecimalFormat df = new DecimalFormat("##.0");
		int min = 101;
		int max = 0;
		double total = 0;

		for (int i = 0; i < g.size(); i++) {
			if (g.get(i) > max)
				max = g.get(i);
			if (g.get(i) < min)
				min = g.get(i);
			total = total + g.get(i);
		}

		System.out.println("\n\nThe minimum was " + min + ", the maximum was " + max + " and the average value was "
				+ df.format(total / g.size()));

	}

	// method to determine grade distribution
	public static void distGrades(ArrayList<Integer> g) {
		int a = 0; // A grades
		int b = 0; // B grades
		int c = 0; // C grades
		int d = 0; // D grades
		int f = 0; // F grades
		int score = 0; // grade holder

		// loop thru AL
		for (int i = 0; i < g.size(); i++) {
			// assign the grade to a variable
			score = g.get(i);
			if (score >= 90) // grade is an A
				a++;
			else if (score >= 80) // grade is a B
				b++;
			else if (score >= 70) // grade is a C
				c++;
			else if (score >= 60) // grade is a D
				d++;
			else// grade is a F
				f++; 
				
		}

		System.out.println("Your grade distribution:");
		System.out.println("Number of A's (90 or above): " + a);
		System.out.println("Number of B's (80-89): " + b);
		System.out.println("Number of C's (70-79): " + c);
		System.out.println("Number of D's (60-69): " + d);
		System.out.println("Number of F's (below 60): " + f);

	}
}
