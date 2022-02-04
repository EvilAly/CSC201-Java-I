package awilchermod5csc201;

import java.util.*;

//1.5-2 hour code

public class ParkingSimulator {

	public static void main(String[] args) {

		// create four ArrayLists. One for each class
		ArrayList<ParkingTicket> tick = new ArrayList<ParkingTicket>();
		ArrayList<ParkingMeter> pm = new ArrayList<ParkingMeter>();
		ArrayList<PoliceOfficer> po = new ArrayList<PoliceOfficer>();
		ArrayList<ParkedCar> pc = new ArrayList<ParkedCar>();

		// create random number generator that will be used to decide which officer will
		// be assigned - added method

		// load initial data by calling my method
		loadData(po, pm, pc);

		// loop through the parked cars arraylist
		for (int i = 0; i < pc.size(); i++) {
			// select a random officer
			int assign = randomAssignment(po);
			// output parked car information
			System.out.println(pc.get(i).toString());
			// calculate the number of minutes of violation (the number of minutes for the
			// car minus the maximum for the meter
			int over = pc.get(i).getNumMinutes() - pc.get(i).getPm().getNumMinutesMax();			
			// if number of minutes of violation is greater than zero
			if (over > 0) {
			// create a ticket
				tick.add(new ParkingTicket(pc.get(i), po.get(assign), over));
				
			// report ticket
				System.out.println("     Car parked illegally for " + over + " min.");}
	
			// else
			else {
			// output that there is no violation
				System.out.println("     No violation.");
			}
			// print out the officer that reported this check
			System.out.println(po.get(assign).toString());
		}
		// end loop

		// output ticket summary
		System.out.println("\nSummary of tickets:");
		// loop through the ticket arraylist and output tickets
		for (int i=0; i < tick.size(); i++ ) {
			System.out.println(tick.get(i).toString());
		}

	}

	public static void loadData(ArrayList<PoliceOfficer> po, ArrayList<ParkingMeter> pm, ArrayList<ParkedCar> pc) {

		po.add(new PoliceOfficer("Joe", "PO123"));
		po.add(new PoliceOfficer("Mike", "PO866"));
		po.add(new PoliceOfficer("Suzie", "PO956"));
		po.add(new PoliceOfficer("Sam", "PO812"));

		pm.add(new ParkingMeter(90, "PM1"));
		pm.add(new ParkingMeter(60, "PM2"));
		pm.add(new ParkingMeter(30, "PM3"));
		pm.add(new ParkingMeter(10, "PM4"));
		pm.add(new ParkingMeter(90, "PM5"));
		pm.add(new ParkingMeter(60, "PM6"));

		pc.add(new ParkedCar("VW", "N34234", 60, pm.get(0)));
		pc.add(new ParkedCar("Mazda", "234-567", 70, pm.get(1)));
		pc.add(new ParkedCar("Subaru", "HelloKitty", 45, pm.get(2)));
		pc.add(new ParkedCar("Buick", "W879HY4", 20, pm.get(3)));
		pc.add(new ParkedCar("Miata", "BG65RF7", 125, pm.get(4)));
		pc.add(new ParkedCar("Corvette", "JI9987", 10, pm.get(5)));
		pc.add(new ParkedCar("Chevy", "12AS76", 145, pm.get(1)));
		pc.add(new ParkedCar("VW", "MK987", 170, pm.get(2)));
		pc.add(new ParkedCar("Dodge", "JR4534D", 86, pm.get(3)));
		pc.add(new ParkedCar("Ford", "C56FDS", 60, pm.get(4)));

	}

	public static int randomAssignment(ArrayList<PoliceOfficer> po) {
		int assign = (int) (Math.random() * po.size());
		return assign;
	}
}
