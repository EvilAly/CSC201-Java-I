package awilchermod4csc201;

import java.text.NumberFormat;
import java.util.ArrayList;

public class SalaryHistoryDriver {

	public static void main(String[] args) {
		ArrayList<SalaryHistory> sh = new ArrayList<SalaryHistory>();
		loadData(sh);
		printOutput(sh);

	}

	public static void loadData(ArrayList<SalaryHistory> salaries) {
		String name = "Donald Duck";
		int[][] dSalaries = { { 2016, 23000 }, { 2017, 24000 }, { 2018, 21000 }, { 2019, 43000 } };
		SalaryHistory sh = new SalaryHistory(name, dSalaries);
		salaries.add(sh);
		String mName = "Mickey Mouse";
		int[][] mSalaries = { { 2010, 200000 }, { 2011, 210000 }, { 2012, 230000 }, { 2013, 180000 }, { 2014, 240000 },
				{ 2015, 245000 }, { 2015, 235000 }, { 2016, 185000 } };
		salaries.add(new SalaryHistory(mName, mSalaries));
		String pName = "Snow White";
		int[][] pSalaries = { { 2012, 120000 }, { 2013, 193000 }, { 2014, 285000 }, { 2015, 145000 }, { 2016, 256000 },
				{ 2017, 245000 }, { 2018, 199000 }, { 2019, 257000 } };
		salaries.add(new SalaryHistory(pName, pSalaries));
	}

	public static void printOutput(ArrayList<SalaryHistory> sal) {
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		// create array for max salaries
		Person[] p = new Person[3];
		String max;
		for (int i = 0; i < sal.size(); i++) {
			System.out.println(sal.get(i).toString());
			p[i] = sal.get(i).maxSalaryInfo();
			// calculate a print maximum salary
			System.out.println("Maximum: " + p[i].getName() + " in " + p[i].getYear() + " with an amount of "
					+ nf.format(p[i].getAmt()));
			// calculate average & print
			String average = sal.get(i).average();
			System.out.println(average + "\n" + "\n");

		}
		ultimateMax(p);
	}

	public static void ultimateMax(Person[] p) {
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		String n = "";
		int y = 0;
		int amt = 0;
		for (int i = 0; i < p.length; i++) {
			if (amt < p[i].getAmt()) {
				amt = p[i].getAmt();
				n = p[i].getName();
				y = p[i].getYear();
			}
		}
		System.out.println("The person making the most salary in any given year is: ");
		System.out.println(n + " in " + y + " with an amount of " + nf.format(amt));

	}
}
