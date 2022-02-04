package awilchermod4csc201;

import java.text.NumberFormat;

public class SalaryHistory {
	String name;
	int[][] income;

	public SalaryHistory() {

	}

	public SalaryHistory(String name, int[][] income) {
		super();
		this.name = name;
		this.income = income;
	}

	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		String out = name + " made the following: \n";
		for (int row = 0; row < income.length; row++)
			out = out + "    Year: " + income[row][0] + " Salary: " + nf.format(income[row][1]) + "\n";
		return out;

	}

	// add any other methods that you might need
	public Person maxSalaryInfo() {
		int max = 0;
		int sal;
		int y = 0;
		for (int row = 0; row < income.length; row++) {
			sal = income[row][1];
			if (sal > max) {
				max = sal;
				y = income[row][0];
			}
		}
		return new Person(name, max, y);
	}

	public String average() {
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		double total = 0;
		for (int row = 0; row < income.length; row++)
			total = total + income[row][1];
		double avg = total / income.length;
		return name + " had an average salary of " + nf.format(avg);
		
	}

	// include your getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int[][] getIncome() {
		return income;
	}

	public void setIncome(int[][] income) {
		this.income = income;
	}

}
