package mru.store.model;

public class Puzzles extends Toy{

	private String puzzleType;
	
	public Puzzles(long serialNumber, String toyName, String toyBrand, double toyPrice, int availableCount, int appropriateAge, String puzzleType) {
		super(serialNumber, toyName, toyBrand, toyPrice, availableCount, appropriateAge);
		this.puzzleType = puzzleType;
	}
	
	public void setPuzzleType(String puzzleType) {
		this.puzzleType = puzzleType;
	}
	public String getPuzzleType() {
		return puzzleType;
	}
	
	@Override
	public String toString() {
		return "Serial Number: " + serialNumber +
			   "\nToy Name: " + toyName + 
			   "\nToy Brand: " + toyBrand +
			   "\nPrice: " + toyPrice + 
			   "\nAvailable Count: " + availableCount +
			   "\nAppropriate Age: " + appropriateAge + 
			   "\nPuzzle Type: " + puzzleType; 
	}
	
	@Override
	public String format() {
		return serialNumber + ";" 
			 + toyName + ";" 
			 + toyBrand + ";" 
			 + toyPrice + ";" 
			 + availableCount + ";" 
			 + appropriateAge + ";"
			 + puzzleType;
	}
}
