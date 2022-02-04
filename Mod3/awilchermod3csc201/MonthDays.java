package awilchermod3csc201;

public class MonthDays {
	
	private int month;
	private int year;
	
	//constructors
	public MonthDays() {
		
	}
	
	public MonthDays(int m,int y) {
		month = m;
		year = y;	
	}
	
	//define other methods
	public String toString() {
		 return ("Month " + month + " of " + year);
	}
	
	public int getNumberOfDays() {
		//calculate days
		int days;
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			days = 31;
		}
		else if (month == 4 || month == 6 || month ==9 || month == 11) {
			days = 30;
		}
		else {
			if (((year % 100 == 0) && (year % 400 == 0)) || (year % 4 == 0)) {
				days = 29;
			}
			else {
				days = 28;
			}
		}
	
		return days;
	}
	
	//getters and setters created by Eclipse
	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	

}
