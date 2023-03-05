package mru.store.model;

public class BoardGames extends Toy{

//	private int minimumPlayerCount;
//	private int maxPlayerCount;
	private String playerCountRange;
	private String boardGameDesigners;
	
	public BoardGames(long serialNumber, String toyName, String toyBrand, double toyPrice, int availableCount, int appropriateAge, String playerCountRange, String boardGameDesigners) {
		super(serialNumber, toyName, toyBrand, toyPrice, availableCount, appropriateAge);
//		this.minimumPlayerCount = minimumPlayerCount;
//		this.maxPlayerCount = maxPlayerCount;
		this.playerCountRange = playerCountRange;
		this.boardGameDesigners = boardGameDesigners;
	}
	
	public void setPlayerCountRange(String playerCountRange) {
		this.playerCountRange = playerCountRange;
	}
	public String getPlayerCountRange() {
		return playerCountRange;
	}
	
//	public void setMinimumPlayerCount(int minimumPlayerCount) {
//		this.minimumPlayerCount = minimumPlayerCount;
//	}
//	public int getMinimumPlayerCount() {
//		return minimumPlayerCount;
//	}
//	public void setMaxPlayerCount(int maxPlayerCount) {
//		this.maxPlayerCount = maxPlayerCount;
//	}
//	public int getMaxPlayerCount() {
//		return maxPlayerCount;
//	}
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
//			   "\nMinimum Player Count: " + minimumPlayerCount +
//			   "\nMaximum Player Count: " + maxPlayerCount +
			   "\nRecommended Players" + playerCountRange +
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
//			 + minimumPlayerCount + ";"
//			 + maxPlayerCount + ";"
			 + playerCountRange + ";"
			 + boardGameDesigners;
	}
}
