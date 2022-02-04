package awilchermod5csc201;

public class PoliceOfficer {
	
	//fields
	private String name;
	private String badgeNum;
	
	//constructor
	public PoliceOfficer() {
		
	}
	
	public PoliceOfficer(String n, String b) {
		this.name = n;
		this.badgeNum = b;
	}
	
	//methods
	public String toString() {
		return ("     Reported by Police Officer " + this.name + "(badge# " + this.badgeNum + ")");
	}

	//getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBadgeNum() {
		return badgeNum;
	}

	public void setBadgeNum(String badgeNum) {
		this.badgeNum = badgeNum;
	}
	
	
	

}
