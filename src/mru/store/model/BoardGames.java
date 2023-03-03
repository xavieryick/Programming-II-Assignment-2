package mru.store.model;

public class BoardGames extends Toy{

	private int boardGamePlayerCount;
	private String boardGameDesigners;
	
	public BoardGames(int serialNumber, String toyName, String toyBrand, double toyPrice, int availableCount, int appropriateAge, int boardGamePlayerCount, String boardGameDesigners) {
		super(serialNumber, toyName, toyBrand, toyPrice, availableCount, appropriateAge);
		this.boardGamePlayerCount = boardGamePlayerCount;
		this.boardGameDesigners = boardGameDesigners;
	}
	
	public void setBoardGamePlayerCount(int boardGamePlayerCount) {
		this.boardGamePlayerCount = boardGamePlayerCount;
	}
	public int getBoardGamePlayerCount() {
		return boardGamePlayerCount;
	}
	
	public void setBoardGameDesigners(String boardGameDesigners) {
		this.boardGameDesigners = boardGameDesigners;
	}
	public String getBoardGameDesigners() {
		return boardGameDesigners;
	}
	
	@Override
	public String toString() {
		return "Serial Number: " + serialNumber +
			   "\nToy Name: " + toyName + 
			   "\nToy Brand: " + toyBrand +
			   "\nPrice: " + toyPrice + 
			   "\nAvailable Count: " + availableCount +
			   "\nAppropriate Age: " + appropriateAge + 
			   "\nBoard Game Player Count: " + boardGamePlayerCount +
			   "\nBoard Game Designers: " + boardGameDesigners;
	}
	
	@Override
	public String format() {
		return serialNumber + ";" 
			 + toyName + ";" 
			 + toyBrand + ";" 
			 + toyPrice + ";" 
			 + availableCount + ";" 
			 + appropriateAge + ";"
			 + boardGamePlayerCount + ";"
			 + boardGameDesigners;
	}
}
