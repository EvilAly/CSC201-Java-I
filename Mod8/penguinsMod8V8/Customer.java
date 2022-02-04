package penguinsMod8V8;



public class Customer {

	private String last;

	private String first;

	private int id;

	public static int num = 250;
	
	public Customer(String custLast, String custFirst)
	{
		last=custLast;
		first=custFirst;
		id = num;
		num += 2;
	}
	
	 public Customer()
	{
		id = num;
		num += 2;
	}
	
	public Customer(String custL, String custF, int idNum)
	{
		last=custL;
		first=custF;
		id = idNum;	
		
	}

	public String toString()
	{
		return first + " " + last + ", with a ID of: " + id;
	}

		public String toStringF()
	{
		return first + "|" + last +"|" + id;
	}

	public static int getNum() {
		return num;
	}

	public String getFirst() {
		return first;
	}

	public int getId() {
		return id;
	}

	public String getLast() {
		return last;
	}

	public static void setNum(int i) {
		num = i;
	}

	public void setFirst(String string) {
		first = string;
	}

	public void setLast(String string) {
		last = string;
	}	
}	

	