package mru.store.view;

import java.util.Scanner;

import mru.store.model.Toy;

public class AppMenu {

	private Scanner input;
	private long serialNumber;
	private String toyName;
	private String toyBrand;
	private double toyPrice;
	private int availableCount;
	private int appropriateAge;
	private int minimumPlayers;
	private int maximumPlayers;
	private String designerNames;
	private String figureClassification;
	private String animalMaterial;
	private String animalSize;
	private String puzzleType;
	
	private String serialNumberCheck;	//for SN check
	private boolean firstRun = true;	// not sure if i can leave them up here
	
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
				+ "(4) Save and exit \n"
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
			save();
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
			//vars for sn check and boolean are located above
			do {
				if (!firstRun) {
					System.out.println("Invalid input! Serial numbers are ten digits long!");
				}
				System.out.println("Enter a serial number here: ");
				serialNumberCheck = input.nextLine();
				firstRun = false;
				
			}while (serialNumberCheck.length() != 10);
			
			long searchSerialNumber = Long.parseLong(serialNumberCheck);
			searchBySerialNumber(searchSerialNumber);
			break;
		case 2:
			System.out.println("Please enter a toy name: ");
			String searchToyName = input.nextLine();
			searchByToyName(searchToyName);
			break;
		case 3:
			System.out.println("Please enter a toy type: ");
			String searchToyType = input.nextLine();
			searchByToyType(searchToyType);
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
	
	private void searchBySerialNumber(long searchSerialNumber) {
		// TODO Auto-generated method stub
		
		// SN has 10 digits 
		
		// serial number has already been validated at this point 
		// convert to String 
		// https://www.baeldung.com/java-number-of-digits-in-int
		
		// if string.length == 10
		
	}
	
	private void searchByToyName(String searchToyName) {
		// TODO Auto-generated method stub
		
	}
	
	private void searchByToyType(String searchToyType) {
		// TODO Auto-generated method stub
		
	}

	public void addToy() {
		serialNumber = 0;
		toyName = null;
		toyBrand = null;
		toyPrice = 0;
		availableCount = 0;
		appropriateAge = 0;
		minimumPlayers = 0;
		maximumPlayers = 0;
		designerNames = null;
		figureClassification = null;
		animalMaterial = null;
		animalSize = null;
		puzzleType = null;
		
		System.out.println("Enter serial number: ");
		do {
			serialNumber = input.nextLong();
		} while (serialNumber <= 0);
		
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
		} while (toyPrice <= 0);
		
		System.out.println("Enter available count: ");
		do {
			availableCount = input.nextInt();
		} while (availableCount <= 0);
		
		System.out.println("Enter appropriate age: ");
		do {
			appropriateAge = input.nextInt();
		} while (appropriateAge <= 0);
		
		//figure
		if (serialNumber <= 0000000000L && serialNumber <= 1999999999L) {
			System.out.println("Enter figure classification \n"
					+ "A) Action \n"
					+ "D) Doll \n"
					+ "H) Historic \n"
					+ "Enter a letter: ");
			do {
				figureClassification = input.nextLine();
			} while (figureClassification != "A" && 
				 figureClassification != "D" && 
				 figureClassification != "H");
		}
		
		//animal
		if (serialNumber <= 2000000000L && serialNumber <= 3999999999L) {
			System.out.println("Enter animal material: ");
			do {
				animalMaterial = input.nextLine();
			} while (animalMaterial == null);	
			
			System.out.println("Enter animal size \n"
					+ "S) Small \n"
					+ "M) Medium \n"
					+ "L) Large \n"
					+ "Enter a letter: ");
			do {
				animalSize = input.nextLine();
			} while (animalSize != "S" && 
					animalSize != "M" && 
					animalSize != "L");
		}
		
		// puzzle
		if (serialNumber <= 4000000000L && serialNumber <= 6999999999L) {
			System.out.println("Enter puzzle type \n"
					+ "M) Mechanical \n"
					+ "C) Cryptic \n"
					+ "L) Logic \n"
					+ "T) Trivia \n "
					+ "R) Riddle \n"
					+ "Enter a letter: ");
			do {
				puzzleType = input.nextLine();
			} 	while (puzzleType != "M" &&
				   puzzleType != "C" &&
				   puzzleType != "L" &&
				   puzzleType != "T" &&
				   puzzleType != "R");
		}
		
		//board games
		if (serialNumber <= 7000000000L && serialNumber <= 9999999999L) {
			System.out.println("Enter minimum number of players: ");
			do {
				minimumPlayers = input.nextInt();
			} while (minimumPlayers == 0);
			System.out.println("Enter maximum number of players: ");
			do {
				maximumPlayers = input.nextInt();
			} while (maximumPlayers == 0 && maximumPlayers < minimumPlayers);
			System.out.println("Enter designer names (Use ',' to separate): ");
			do {
				designerNames = input.nextLine();
			} while (designerNames == null);
		}
		System.out.println("New toy added!");
	}
	
	public void removeToy() {
		serialNumber = -1;
		System.out.println("Enter serial number: ");
		do {
			serialNumber = input.nextInt();
		} while (serialNumber <= 0);
//		if serialNumber is found
//		System.out.println("toy info");
//		System.out.println("Do you want to remove it? (Y/N): ");
//		switch case with y/n
//		else
//		System.out.println("Item not found!);
	}
}
