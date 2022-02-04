package awilchermod7csc201;

public class Customer {

	// fields
	private String firstName;
	private String lastName;
	private int custID;
	public static int num=500; //high number to make sure no overlap in customer IDs

	// empty constructor
	public Customer() {

	}
	
	//constructor to create new customer
	public Customer(String first, String last) {
		this.firstName = first;
		this.lastName = last;
		this.custID = num;
		num++;
	}

	// full constructor to read customer in from a file
	public Customer(String first, String last, int id) {
		this.firstName = first;
		this.lastName = last;
		this.custID = id;
		
	}

	// Methods
	public String toString() {
		return this.firstName + " " + this.lastName + " with an ID of " + this.custID;
	}
	
	public String toFileString() {
		return firstName + "|" + lastName + "|" + custID;
	}

	// getters and setters
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getCustID() {
		return custID;
	}

	public void setCustID(int custID) {
		this.custID = custID;
	}

}
