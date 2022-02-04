package awilcher_m6q2;

public class Customer {

	// the Customer class has three fields
	private int custId;
	private String name;
	private boolean goldDude;

	// the following will be used to automatically generate customer ids
	// so they will be unique
	private static int nextNum = 100;

	// empty constructor
	public Customer() {
		custId = nextNum;
		nextNum++;
	}

	// constructor for creating a new customer where the id is
	// automatically created
	public Customer(String n) {
		name = n;
		custId = nextNum;
		nextNum++;
	}

	// full constructor
	public Customer(String n, boolean gcm) {
		custId = nextNum;
		nextNum++;
		name = n;
		goldDude = gcm;
	}

	// toString method
	public String toString() {
		return name + " (custID: " + custId + ")";
	}

	// getters and setters
	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNextNum() {
		return nextNum;
	}

	public void setNextNum(int nextNum) {
		this.nextNum = nextNum;
	}

	public boolean isGoldCardMember() {
		return goldDude;
	}

	public void setGoldCardMember(boolean goldCardMember) {
		this.goldDude = goldCardMember;
	}

}
