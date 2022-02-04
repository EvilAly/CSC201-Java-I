package penguinsMod8V6;

import java.io.*;
import java.time.LocalDate;


public class Reservation {

	private Customer cust;

	private LocalDate date;
	
	private String seat;

	private int resId;

	public static int num = 12500;
	
	public Reservation(LocalDate d, Customer c, String s)
	{
		date = d;
		cust = c;
		resId = num;
		seat = s;
		num += 10;
	}
	
	 public Reservation()
	{
		resId = num;
		num += 10;
	}
	
	public Reservation(LocalDate d, Customer c, String s, int idNum)
	{
		date = d;
		cust = c;
		seat = s;
		resId = idNum;	
		
	}
	
	public String toString()
	{
		return cust.toString() + " has a reservation on " + date + " in seat " + seat + 
				", reservation ID: " + resId;
	}

		public String toStringF()
	{
		return cust.toStringF() + "|" + date + "|" + seat + "|" + resId;
	}

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public int getResId() {
		return resId;
	}
}