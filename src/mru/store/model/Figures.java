package mru.store.model;

public class Figures extends Toy {

	private String figureClassification;

	public Figures(int serialNumber, String toyName, String toyBrand, double toyPrice, int availableCount, int appropriateAge, String figureClassification) {
		super(serialNumber, toyName, toyBrand, toyPrice, availableCount, appropriateAge);
		this.figureClassification = figureClassification;
	}
	
	public void setFigureClassification(String figureClassification) {
		this.figureClassification = figureClassification;
	}
	public String getFigureClassification() {
		return figureClassification;
	}
	
	@Override
	public String toString() {
		return "Serial Number: " + serialNumber +
			   "\nToy Name: " + toyName + 
			   "\nToy Brand: " + toyBrand +
			   "\nPrice: " + toyPrice + 
			   "\nAvailable Count: " + availableCount +
			   "\nAppropriate Age: " + appropriateAge + 
			   "\nClassification: " + figureClassification;
	}
	
}
