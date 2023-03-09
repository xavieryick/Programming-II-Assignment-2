package mru.store.model;

import mru.store.controller.CustomException;

public class BoardGames extends Toy{

	private int minimumPlayerCount;
	private int maximumPlayerCount;
	private String playerCountRange;
	private String boardGameDesigners;
	
	public BoardGames(String serialNumber, String toyName, String toyBrand, double toyPrice, int availableCount, int appropriateAge, int minimumPlayerCount, int maximumPlayerCount, String boardGameDesigners) {
		super(serialNumber, toyName, toyBrand, toyPrice, availableCount, appropriateAge);
		this.minimumPlayerCount = minimumPlayerCount;
		this.maximumPlayerCount = maximumPlayerCount;
//		this.playerCountRange = playerCountRange;
		this.boardGameDesigners = boardGameDesigners;
	}
	
	public void setPlayerCountRange(String playerCountRange) {
		this.playerCountRange = playerCountRange;
	}
	public String getPlayerCountRange() {
		return playerCountRange;
	}
	
	public void setMinimumPlayerCount(int minimumPlayerCount) {
		this.minimumPlayerCount = minimumPlayerCount;
	}
	public int getMinimumPlayerCount() {
		return minimumPlayerCount;
	}
	public void setMaxPlayerCount(int maxPlayerCount) throws CustomException {
		if(minimumPlayerCount > maximumPlayerCount) {
			throw new CustomException("Max players can't be higher than minimum players needed!");
		}
		this.maximumPlayerCount = maxPlayerCount;
	}
	public int getMaxPlayerCount() {
		return maximumPlayerCount;
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
			   "\nMinimum Player Count: " + minimumPlayerCount +
			   "\nMaximum Player Count: " + maximumPlayerCount +
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
			 + minimumPlayerCount + "-" + maximumPlayerCount + ";"
			 + boardGameDesigners;
	}
}
