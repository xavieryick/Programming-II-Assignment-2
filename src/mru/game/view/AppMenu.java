package mru.game.view;

import java.util.Scanner;

public class AppMenu {

	Scanner input;
	private int serialNumber;
	private String toyName;
	private String toyBrand;
	private double toyPrice;
	private int availableCount;
	private int appropriateAge;
	private int minimumPlayers;
	private int maximumPlayers;
	private String designerNames;
	
	public AppMenu() {
		input = new Scanner(System.in);
	}
	
	public void mainMenu() {
		System.out.println("Welcome! \n "
				+ "How may we help you? \n"
				+ "\n"
				+ "(1) Search inventory and purchase toy \n"
				+ "(2) Add a new toy \n"
				+ "(3) Remove a toy \n"
				+ "(4) Make a gift suggestion \n"
				+ "(5) Save and exit \n"
				+ "\n"
				+ "Please enter a number: ");
		int choice = input.nextInt();
		switch (choice) {
		case 1:
			searchInventory();
			break;
		case 2:
			addToy();
			break;
		case 3:
			removeToy();
			break;
		case 4:
			giftSuggestion();
			break;
		case 5:
			saveExit();
			break;
		default:
			System.out.println("Invalid input!");
			mainMenu();
			break;
		}
	}
	
	public void searchInventory() {
		System.out.println("Find toys with: \n"
				+ "\n"
				+ "(1) Serial Number (SN) \n"
				+ "(2) Toy Name \n"
				+ "(3) Toy Type \n"
				+ "(4) Return to Main Menu"
		 		+ "\n"
		 		+ "Please enter a number: ");
		int choice = input.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Please enter a serial number: ");
//			do something with this
			break;
		case 2:
			System.out.println("Please enter a toy name: ");
//			do something with this
			break;
		case 3:
			System.out.println("Please enter a toy type: ");
//			do something with this
			break;
		case 4:
			mainMenu();
			break;
		default:
			System.out.println("Invalid input!");
			searchInventory();
			break;
		}		
	}
	
	public void addToy() {
		System.out.println("Enter serial number: ");
		do {
			serialNumber = input.nextInt();
		} while (serialNumber == 0);
		
		System.out.println("Enter toy name: ");
		do {
			toyName = input.nextLine();
		} while (toyName == null);
		
		System.out.println("Enter toy brand: ");
		do {
			toyBrand = input.nextLine();
		} while (toyBrand == null);
		
		System.out.println("Enter toy price: ");
		do {
			toyPrice = input.nextDouble();
		} while (toyPrice == 0);
		
		System.out.println("Enter available count: ");
		do {
			availableCount = input.nextInt();
		} while (availableCount == 0);
		
		System.out.println("Enter appropriate age: ");
		do {
			appropriateAge = input.nextInt();
		} while (appropriateAge == 0);
		
		System.out.println("Enter minimum number of players: ");
		do {
			minimumPlayers = input.nextInt();
		} while (minimumPlayers == 0);
		
		System.out.println("Enter maximum number of players: ");
		do {
			maximumPlayers = input.nextInt();
		} while (maximumPlayers == 0);
		
		System.out.println("Enter designer names (Use ',' to separate)");
		do {
			designerNames = input.nextLine();
		} while (designerNames == null);
		
		System.out.println("New toy added!");
	}
	
	public void removeToy() {
		System.out.println("Enter serial number: ");
		serialNumber = input.nextInt();
		
//		if serialNumber is found
//		System.out.println("toy info");
//		System.out.println("Do you want to remove it? (Y/N): ");
//		switch case with y/n
//		else
//		System.out.println("Item not found!);
	}
	
	public void giftSuggestion() {
		
	}
	
	public void saveExit() {
		
	}
}
