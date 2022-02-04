package awilcher_m3w2;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class EnergyDriver {

	public static void main(String[] args) {
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		EnergyDrink ed1 = new EnergyDrink("Java Monster", 16, 160, 2.20);
		EnergyDrink ed2 = new EnergyDrink("Red Bull", 12, 111, 1.99);
		EnergyDrink ed3 = new EnergyDrink("Rockstar", 12, 160, 2.10);
		
		System.out.println(ed1.toString());
		System.out.println(ed2.toString());
		System.out.println(ed3.toString());
		
		// call the method mgPerOunce() to print out the mg per ounce for each of the drinks
		//see sample output
		mgPerOunce(ed1, ed2, ed3);
		
		// call the method bestCostPer100Mg().  It returns the instance with the lowest cost
		//print out the name and the value
		//see sample output
		EnergyDrink bestCost = bestCostPer100Mg(ed1,ed2,ed3);
		double mg = (bestCost.getMgCaffeine());
		double value = (bestCost.getCost() / (mg / 100));
		System.out.println(bestCost.getType() + " has the lowest cost per 100 mg caffeine with a value of " + nf.format(value));
	}
	
	// see UML - write a method definition named mgPerOunce()
	//Parameters are the three energy drinks from main()
	// Have the method print out the name and the mg of caffeine per ounce
	// see sample output
	public static void mgPerOunce(EnergyDrink ed1, EnergyDrink ed2, EnergyDrink ed3) {
		DecimalFormat df = new DecimalFormat("##.##");
		System.out.println(ed1.getType() + " has " + df.format(ed1.mgPerOunce()) + "mg of caffeine per ounce of drink.");
		System.out.println(ed2.getType() + " has " + df.format(ed2.mgPerOunce()) + "mg of caffeine per ounce of drink.");
		System.out.println(ed3.getType() + " has " + df.format(ed3.mgPerOunce()) + "mg of caffeine per ounce of drink.");
		
	}
	
	
	//see UML  - write a method definition named bestCostPer100Mg
	// Parameters are the three energy drinks from main()
	//Have the method return the EnergyDrink instance that has the lowest cost per 100 mg
	public static EnergyDrink bestCostPer100Mg(EnergyDrink ed1, EnergyDrink ed2, EnergyDrink ed3) {
		double oneMgPCost = ed1.getMgCaffeine()/ed1.getCost();
		double twoMgPCost = ed2.getMgCaffeine()/ed2.getCost();
		double threeMgPCost = ed3.getMgCaffeine()/ed3.getCost();
		if (oneMgPCost > twoMgPCost && oneMgPCost > threeMgPCost) {
			return ed1;
		} else if (twoMgPCost > threeMgPCost) {
			return ed2;
		}
		else {
			return ed3;
		}
		
		
	}
	
	

}
