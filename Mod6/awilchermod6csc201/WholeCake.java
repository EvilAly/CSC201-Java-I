package awilchermod6csc201;

public class WholeCake extends Cake {

	// fields
	private int numPieces;

	// constructors
	public WholeCake() {

	}

	public WholeCake(String type, double cost, int wt, int np) {
		super(type, cost, wt);
		this.numPieces = np;
	}

	// methods
	public String toString() {
		return super.toString() + ". The whole cake has " + this.numPieces + " pieces.";
	}

	public double calcCost() {
		double cost = this.cost / (this.weight * this.numPieces);
		return cost;
	}

	// getters and setters
	public int getNumPieces() {
		return this.numPieces;
	}

	public void setNumPieces(int np) {
		this.numPieces = np;
	}
}
