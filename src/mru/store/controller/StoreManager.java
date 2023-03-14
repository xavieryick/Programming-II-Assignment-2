package mru.store.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import mru.store.model.*;
import mru.store.view.AppMenu;

public class StoreManager {
	
	private final String FILE_PATH = "res/toys.txt";
	AppMenu appMenu;
	ArrayList<Toy> toyList;
	private Scanner input;
	
	private String serialNumber;
	private String toyName;
	private String toyBrand;
	private double toyPrice;
	private int availableCount;
	private int appropriateAge;
	
	private int minimumPlayers;
	private int maximumPlayers;
	
	private String designerNames;
	private char figureClassification;
	private String animalMaterial;
	private char animalSize;
	private char puzzleType;
	
//	private String serialNumberCheck;	//for SN check
//	private boolean firstRun = true;	// not sure if i can leave them up here
	
	Toy toy;
	
	public StoreManager() {
		appMenu = new AppMenu();
		toyList = new ArrayList<>();
		input = new Scanner(System.in);
		
		try {
			loadData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("We couldn't load the database of toys in!");
		} //ask if we need to surround this with try and catch 
		
		try {
			launchApplication();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("We couldn't launch the application!");
		}
	}
	
	public void launchApplication() throws Exception{
		appMenu.welcomeMessage();
		mainMenu(); //threw an exception here 
	}
	
	public void mainMenu() throws Exception {
		appMenu.showMainMenu();
		
		while (!input.hasNextInt()) { //this validation works
			input.nextLine();
			appMenu.invalidInput();
			appMenu.showMainMenu();
		}
		
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
			save(); //will use throw exception, might change to try catch
			appMenu.visitMessage(); // will tell user goodbye
			break;
		default:
			appMenu.invalidInput();
			mainMenu();
			break;
		}
	}
	
	public void searchInventory() throws Exception {
		appMenu.showSearchInventory();
		
		while (!input.hasNextInt()) { //this validation works
			input.nextLine();
			appMenu.invalidInput();
			appMenu.showSearchInventory();
		}
		
		int choice = input.nextInt();
		switch (choice) {
		case 1:	
		input.nextLine(); //clearing the buffer	
			do {
				appMenu.promptToySerialNumber();
				serialNumber = input.nextLine().trim();
				if (serialNumber.length() != 10) {
					appMenu.promptInvalidSerialNumber();	 
				}
			} while (serialNumber.length() != 10);
			
			searchBySerialNumber(serialNumber);
			break;
			
		case 2:
			input.nextLine(); //clearing the buffer
			appMenu.promptToyName();
			String searchToyName = input.nextLine().toLowerCase(); //got rid of trim
			
			while (searchToyName.isEmpty() || searchToyName.isBlank()) {
				 
				appMenu.invalidInput();
				appMenu.promptToyName();
				searchToyName = input.nextLine().toLowerCase();
			}
			searchByToyName(searchToyName); //doing a weird thing with needing to have to press space twice
			break;
			
		case 3:
			appMenu.promptToyType();
			
			while (!input.hasNextInt()) {
				appMenu.invalidInput();
				input.nextLine(); //clearing the buffer 
				appMenu.promptToyType();		
			}
			int searchToyType = input.nextInt();
			searchByToyType(searchToyType);
			break;
			
		case 4:
			mainMenu(); //throw exception added here too
			break;
			
		default:
			appMenu.invalidInput();
			searchInventory();
			break;
		}		
	}
	
	public void addToy() throws CustomException {
		int index = 0;
		boolean duplicate = false;
		
		serialNumber = null;
		toyName = "";
		toyBrand = "";
		toyPrice = 0;
		availableCount = 0;
		appropriateAge = 0;
		minimumPlayers = 0;
		maximumPlayers = 0;
		designerNames = null;
		figureClassification = 'x';
		animalMaterial = null;
		animalSize = 'x';
		puzzleType = 'x';
		
		appMenu.promptToySerialNumberAdd();
			input.nextLine(); // clear the buffer
		do {
			serialNumber = input.nextLine().trim();
			if (serialNumber.length() != 10) {
				appMenu.invalidInput();
				appMenu.promptToySerialNumberAdd();
			}
			else {
				// SN duplicate check finished 
				for(Toy toy: toyList) {
					String currentToy = toy.getSerialNumber();
					if (currentToy.equals(serialNumber)) {
						appMenu.duplicateSerialNumber();
						appMenu.promptToySerialNumberAdd();
						duplicate = true;
						break;
					}
					else {
						duplicate = false;
					}
				}
			}
		} while (serialNumber == null || serialNumber.length() != 10 || duplicate == true);
		
		
		// prompt toy name 
		do {
			appMenu.promptToyNameAdd();
			toyName = input.nextLine().trim();
			
			if(toyName == null || toyName == "") {
				appMenu.invalidInput();
				System.out.println("Please enter a toy name! This field can't be left blank!");
			}
			
		} while (toyName == null || toyName == "");
		
		// prompt toy brand 
		
	
		do {
			appMenu.promptToyBrand();
			toyBrand = input.nextLine().trim();
			
			if(toyBrand == null || toyBrand == "") {
				appMenu.invalidInput();
				System.out.println("Please enter a toy brand! This field can't be left blank!");
			}
			
		} while (toyBrand == null || toyBrand == "");
		
		//INSERT TRY AND CATCH HERE FOR PRICE
		//ask him about this if this is ok since he wants custom exceptions
		
		//need to do int check
		
		appMenu.promptToyPrice(); // this fully works 
		do {
		
		while (!input.hasNextInt()) { 
			input.next();
			appMenu.invalidInput();
			appMenu.promptToyPrice();
		}
		toyPrice = input.nextDouble();
		
		try {
		toy.setToyPrice(toyPrice);	
			} catch (Exception e){
			e.printStackTrace();
			appMenu.promptToyPrice();

		}	

			}while (toyPrice < 0);
		
//		do {
//			toyPrice = input.nextDouble();
//			if (toyPrice <= 0) {
//				appMenu.invalidInput();
//				appMenu.promptToyPrice();
//			}
//		} while (toyPrice <= 0);
		
		appMenu.promptAvailableCount(); //sometimes it'll print invalid twice 
		do {
			while (!input.hasNextInt()) { 
				System.out.println("Error catch 1");
				input.nextLine();
				appMenu.invalidInput();
				appMenu.promptAvailableCount();
				
			}
			
			availableCount = input.nextInt(); 
			
			if(availableCount < 0) {
				System.out.println("Error catch 2");
				input.nextLine();
					appMenu.invalidInput();
					appMenu.promptAvailableCount();
				}
			
			
//			if (availableCount <= 0) {
//				appMenu.invalidInput();
//				appMenu.promptAvailableCount();
//			}
			
		} while (availableCount < 0);
		
		appMenu.promptAppropriateAge();
		do {
			appropriateAge = input.nextInt();
			if (appropriateAge <= 0) {
				appMenu.invalidInput();
				appMenu.promptAppropriateAge();
			}
		} while (appropriateAge <= 0);
		
		//figure
		if (serialNumber.charAt(0) == '0' || serialNumber.charAt(0) == '1') {  //probably switch it to nextChar
			appMenu.promptFigureClassification();
			input.nextLine(); //clears the buffer

			do {
				figureClassification = input.nextLine().toUpperCase().charAt(0);
				if (figureClassification != 'A' && figureClassification != 'D' && figureClassification != 'H') {
					appMenu.invalidInput();
					appMenu.promptFigureClassification();
				}
			} while (figureClassification != 'A' && figureClassification != 'D' && figureClassification != 'H');
			String addFigureClassification = Character.toString(figureClassification);
			Toy addToy = new Figures(serialNumber,toyName,toyBrand,toyPrice,availableCount,appropriateAge,addFigureClassification);
			toyList.add(addToy);
		}
		
		//animal
		if (serialNumber.charAt(0) == '2' || serialNumber.charAt(0) == '3') {
			appMenu.promptAnimalMaterial();
			input.nextLine(); //clears the buffer
			
			do {
				animalMaterial = input.nextLine().trim().toUpperCase();
			} while (animalMaterial == null);	
			
//			input.nextLine(); //clears the buffer
			appMenu.promptAnimalSize();
			
			do {
				animalSize = input.nextLine().trim().toUpperCase().charAt(0);
				if (animalSize != 'S' && animalSize != 'M' && animalSize != 'L') {
					appMenu.invalidInput();
					appMenu.promptAnimalSize();
				}
			} while (animalSize != 'S' && animalSize != 'M' && animalSize != 'L');
			String addAnimalSize = Character.toString(animalSize);
			Toy addToy = new Animals(serialNumber,toyName,toyBrand,toyPrice,availableCount,appropriateAge,animalMaterial,addAnimalSize);
			toyList.add(addToy);
		}
		
		// puzzle
		if (serialNumber.charAt(0) == '4'|| serialNumber.charAt(0) == '5' || serialNumber.charAt(0) == '6') {
			appMenu.promptPuzzleType();
			input.nextLine();
			do {
				puzzleType = input.nextLine().trim().toUpperCase().charAt(0);
				if (puzzleType != 'M' && puzzleType != 'C' && puzzleType != 'L' && puzzleType != 'T' && puzzleType != 'R') {
					appMenu.invalidInput();
					appMenu.promptPuzzleType();
				}
			} 	while (puzzleType != 'M' && puzzleType != 'C' && puzzleType != 'L' && puzzleType != 'T' && puzzleType != 'R');
			String addPuzzleType = Character.toString(puzzleType);
			Toy addToy = new Puzzles(serialNumber,toyName,toyBrand,toyPrice,availableCount,appropriateAge,addPuzzleType);
			toyList.add(addToy);
		}
		
		//board games
		
		//for exception: https://www.baeldung.com/java-new-custom-exception
		//if (player count problem) 
		//throw new CustomException(error message)
		
		if (serialNumber.charAt(0) == '7' || serialNumber.charAt(0) == '8' || serialNumber.charAt(0) == '9') {
			appMenu.promptBoardGameMinimumPlayers();
			do {
				minimumPlayers = input.nextInt();
				if (minimumPlayers <= 0) {
					appMenu.invalidInput();
					appMenu.promptBoardGameMinimumPlayers();
				}
			} while (minimumPlayers <= 0);

//			appMenu.promptBoardGameMaximumPlayers();
//			do {
//				maximumPlayers = input.nextInt();
//				if (maximumPlayers < minimumPlayers) {
//					appMenu.invalidInput();
//					appMenu.promptBoardGameMaximumPlayers();
//				}
//			} while (maximumPlayers < minimumPlayers);
			// original while: maximumPlayers == 0 && maximumPlayers < minimumPlayers
			
			// ask him how to cast this 
			appMenu.promptBoardGameMaximumPlayers();
			do {
				maximumPlayers = input.nextInt();
				try {
					// print out what type of toy it is before hand 
					// need to check for toy before hand, the cast from that toy to BoardGame 
//					System.out.println("min " + minimumPlayers);
//					System.out.println("max " + maximumPlayers);

					BoardGames boardGame = (BoardGames)toy;
					
					 boardGame.setMaxPlayerCount(maximumPlayers);
				}catch (Exception e){
					e.printStackTrace();
					
					appMenu.invalidInput();
					appMenu.promptBoardGameMaximumPlayers();
				}	
			} while (maximumPlayers < minimumPlayers);
			
			
			appMenu.promptBoardGameDesigners();
			input.nextLine(); // clear buffer 
			do {
				designerNames = input.nextLine().trim();
			} while (designerNames == null);
			Toy addToy = new BoardGames(serialNumber,toyName,toyBrand,toyPrice,availableCount,appropriateAge,minimumPlayers,maximumPlayers,designerNames);
			toyList.add(addToy);
		}
		System.out.println("New toy added!\n");
		
		// saving changes
		try {
			save();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("We couldn't save your changes.");
		}
		
		// a press enter
				appMenu.pressEnter();
				String userChoice;
				do {
					userChoice = input.nextLine();
				} while (userChoice.length() != 0);
				try {
					mainMenu();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("We couldn't send you back to the main menu.");
				}
		
	}
	
	public void removeToy() {
		serialNumber = null;
		boolean currentToyFound = false;
		int index = 0;
		
		appMenu.promptToySerialNumberAdd();
		input.nextLine(); //clears the buffer
		do {
			serialNumber = input.nextLine().trim();
			if (serialNumber.length() != 10) {
				appMenu.invalidInput();
				appMenu.promptToySerialNumberAdd();
			}
		} while (serialNumber == null || serialNumber.length() != 10);
		
		if (serialNumber.length() == 10) {	
			// serialNumber is input. currentToy is serialNumber in toyList.
			for (index = 0; index < toyList.size(); index++) {
				String currentToy = toyList.get(index).getSerialNumber();
//				System.out.println(currentToy);
				if (currentToy.equals(serialNumber)) {
					System.out.println(toyList.get(index).toString());
					currentToyFound = true;
					break;
				}
				else {
					currentToyFound = false;
				}
			}
		}
		
		if (currentToyFound == true) {
			appMenu.removeMessage();
			String removeChoice = input.nextLine().toLowerCase();
			switch (removeChoice) {
			case "y":
				// remove toy
				toyList.remove(index);
//				
//				System.out.println("toy being removed is: " + toy);
//				System.out.println("testing to remove first toy in list");
//				System.out.println(toyList);
				
				appMenu.removeSuccess();
//				System.out.println(toyList);
				
				//running a save 
//				appMenu.saveMessage();
			try {
				save();
//				appMenu.backToMainMenu();
//				mainMenu();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("We couldn't save your changes.");
			}
				
				break;
			case "n":
				appMenu.removeFail();
//				try {
//					appMenu.backToMainMenu();
//					mainMenu();
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					System.out.println("We couldn't send you back to the main menu.");
//				}
				break;
				
			// user validation stuff for a non-"y/n" case
//			default:
//				appMenu.invalidInput();
//				appMenu.removeMessage();
//				removeChoice = input.nextLine().toLowerCase();
//				break;
			}
		}
		else {
			appMenu.itemNotFound();
		}
		
		// a press enter
		appMenu.pressEnter();
		String userChoice;
		do {
			userChoice = input.nextLine();
		} while (userChoice.length() != 0);
		try {
			mainMenu();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("We couldn't send you back to the main menu.");
		}
	}	
	
	private void searchBySerialNumber(String serialNumber) {		
		boolean itemFound = false;
		int index = 0;
		int toyQuantity = 0;
		
		int rewrite = 0;
		for (index = 0; index < toyList.size(); index++) {
			String currentToy = toyList.get(index).getSerialNumber();
			toyQuantity = toyList.get(index).getAvailableCount(); 
			if (currentToy.equals(serialNumber)) {
				System.out.println(toyList.get(index).toString());
		
				itemFound = true;
				break;
			}
		}
		
		if (itemFound = true) { //make a default here 
			appMenu.purchaseMessage();
			String purchaseChoice = input.nextLine().toLowerCase();
			switch (purchaseChoice) {
				case "y":
					//check quantity 
					if (toyQuantity > 0) {
						
						//debugging
//						System.out.println("We have this many in the system: " + toyQuantity);
//						System.out.println("The toy you're purchasing is: " + toy.toString());
						
						// rewrite using setter? 
						for (rewrite = 0; rewrite< toyList.size(); rewrite++) {
							String activeToy = toyList.get(rewrite).getSerialNumber();
							if (activeToy.equals(serialNumber)) {
								toyList.get(rewrite).setAvailableCount(toyQuantity - 1);
								
								//debugging 
//								int newQuantity = toyQuantity - 1;
//								System.out.println("There are only this many left: " + newQuantity); 
								appMenu.purchaseSuccess();
								
								//is now inside because if there's zero toys why rewrite file
								try {
									save();
			//						appMenu.backToMainMenu();
			//						mainMenu();
								} catch (Exception e) {
									// TODO Auto-generated catch block
									System.out.println("We couldn't save your changes.");
								}
								break; // leaving this loop once we found the toy
							}
						}
					}
					else {
						System.out.println("We're out of this toy sorry!");
					}
	
						break;
				case "n":
					appMenu.purchaseFail();
					
			}
			
		}
		
		// back to the search inventory  
		// a press enter
				appMenu.pressEnter();
				String userChoice;
				do {
					userChoice = input.nextLine();
				} while (userChoice.length() != 0);
				try {
					searchInventory();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("We couldn't send you back to the search inventory menu.");
				}
	
//		if (!itemFound) {
//				appMenu.itemNotFound();
//				appMenu.backToSearchInventory();	
//			}
	}
	
	private void searchByToyName(String searchToyName) { 	//this method fully works unless java does a thing again 
		ArrayList<Toy> searchResults = new ArrayList<>();
		
		ArrayList<Integer> options = new ArrayList<>(); //how many options we got 
		int index = 0; 				// list check when purchasing to match to SN that we need to reduce 
		int rewrite = 0; 			// rewriting the list to deduct one from toy quantity 
		int number = 1;				// displays the toys in a list order
		int toyQuantity = 0; 		// number of the toys in the system
		boolean itemFound = false;	// if item is found, we prompt purchase menu 
		
		appMenu.searchResults(); //display search results

		for (Toy toy:toyList) {
			String currentToy = toy.getToyName();		
			if (currentToy.toLowerCase().contains(searchToyName)) {
				System.out.println("\n(" + number + ") " + toy.toString());
				options.add(number);
				number ++;
				searchResults.add(toy); // works, might not need it 
			}
		}
		
		System.out.println("\n(" + number + ") " + "Back to the search main menu.");
//		input.nextLine(); // clearing buffer bc if you type multi phrase search it breaks
		appMenu.selectOption();
		
		while (!input.hasNextInt()) { //this validation works
			input.nextLine();
			appMenu.invalidInput();
			appMenu.selectOption(); 
			
		}


		int userInput = input.nextInt();
		
		// find highest option available 
		int optionLength = options.size() + 1;
		
//		System.out.println("ln 575 - option length" + optionLength);
		
		// declaring compare to outside of the if else 
		// make if loop, where if user selects back to main, we break loop 
		// MISTAKE we're calling from the whole toy list, not the specific search results list 
	
		
		if (userInput < optionLength - 1) { //IF USER IS PURCHASING EVERYTHING IS HERE, add in greater than zero
		String compareTo = searchResults.get(userInput - 1).getSerialNumber();
		//rewrite this to take from search results now main toylist 
		for (index = 0; index < toyList.size(); index ++) {
		String currentToy = toyList.get(index).getSerialNumber();
		toyQuantity = toyList.get(index).getAvailableCount();

			if (currentToy.equals(compareTo)) {
				
				//debugging
//				System.out.println("debugging... located at line 589");
//				System.out.println(compareTo);
//				System.out.println(currentToy); //it keeps calling toys not in the list, might have to make a separate lists with the choices 
//				System.out.println(toyQuantity);

					itemFound = true;
					//purchasing item so that i can access compareTo
					
					// purchasing of item happens here
		if (itemFound == true) {
			if (toyQuantity > 0) {
				
				//debugging
//				System.out.println("We have this many in the system: " + toyQuantity);
//				System.out.println("The toy you're purchasing is: "  );
				
				//double check to see if we need to change from main toy to search results list, probably don't to
				
				for(rewrite = 0; rewrite < toyList.size(); rewrite++) {
					String activeToy = toyList.get(rewrite).getSerialNumber();
//					toyQuantity = toyList.get(rewrite).getAvailableCount();

					if (activeToy.equals(compareTo)) {
						toyList.get(rewrite).setAvailableCount(toyQuantity - 1);
						appMenu.purchaseSuccess();
						
						//now we save 
						try {
							save();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							System.out.println("We couldn't save your changes.");
						}
						break;
					}
				}
			}
			else { //no more of item 
				System.out.println("We're out of this item sorry!");
			}
		}
					
				}
			}
			
		}
		else if (userInput == optionLength){ 
//			itemFound = false;
			appMenu.backToSearchInventory();
		}
		
		
		
		//back to search menu baby
		
		// a press enter
		input.nextLine(); //clears the buffer 
		appMenu.pressEnter();
		String userChoice;
		do {
			userChoice = input.nextLine();
		} while (userChoice.length() != 0);
		try {
			searchInventory();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("We couldn't send you back to the search inventory menu.");
		}
		
		// u can turn this into real code or i'll do it when i get back 
		// userChoice = next int 
		// int index = 0
		// for (Toy toy: searchResults) 
		// comparedTo = toy.get(userChoice -1).getSerialNumber 
		// 
		// for (index = 0 ; thing < list length: index ++ ) comparing search results to old list 
		// currentToy = toy.get(index).getSN 
		// if comparedTo.eqauls(currentToy)
		// take quantity test and rewrite toy list code from search by SN method and paste it here 
		// clear list at the end 
	}
	
	private void searchByToyType(int searchToyType) {
		ArrayList<Toy> searchResults = new ArrayList<>();	//search results that display to the user 
		ArrayList<Integer> options = new ArrayList<>(); //how many options we got 

		
		int index = 0; 				// list check when purchasing to match to SN that we need to reduce 
		int rewrite = 0; 			// rewriting the list to deduct one from toy quantity 
		int toyQuantity = 0; 		// number of the toys in the system
		int number = 1;				// display what number the search result is
		boolean itemFound = false;	// if item is found, we prompt purchase menu 
		
		// change this to switch cases to make my life easier for user validation
		// use same concept in search by toy name 
		switch(searchToyType) {
		
		case 1:
			appMenu.searchResults();
			for (Toy toy:toyList) {	
				if (toy.getSerialNumber().charAt(0) == '0' || toy.getSerialNumber().charAt(0) == '1') {
					//print out results 
					//then add to search results list 

					System.out.println("\n(" + number + ") " + toy.toString());
					options.add(number);
					number ++;
					searchResults.add(toy); // works, might not need it 
				
				}
			}
			System.out.println("\n(" + number + ") " + "Back to the search main menu."); //back to menu function

			break;
		case 2:
			appMenu.searchResults();
			for (Toy toy:toyList) {	
				if (toy.getSerialNumber().charAt(0) == '2' || toy.getSerialNumber().charAt(0) == '3') {

					//print out results 
					//then add to search results list 

					System.out.println("\n(" + number + ") " + toy.toString());
					options.add(number);
					number ++;
					searchResults.add(toy); // works, might not need it 
				
				}
			}
			System.out.println("\n(" + number + ") " + "Back to the search main menu."); //back to menu function
			
			

			break;
		
		case 3:
			appMenu.searchResults();
			for (Toy toy:toyList) {	
				if (toy.getSerialNumber().charAt(0) == '4' || toy.getSerialNumber().charAt(0) == '5' || toy.getSerialNumber().charAt(0) == '6') {

					//print out results 
					//then add to search results list 

					System.out.println("\n(" + number + ") " + toy.toString());
					options.add(number);
					number ++;
					searchResults.add(toy); // works, might not need it 
				
				}
			}
			System.out.println("\n(" + number + ") " + "Back to the search main menu."); //back to menu function

			break;
		
		case 4:
			appMenu.searchResults();
			for (Toy toy:toyList) {	
				if (toy.getSerialNumber().charAt(0) == '7' || toy.getSerialNumber().charAt(0) == '8' || toy.getSerialNumber().charAt(0) == '9') {

					//print out results 
					//then add to search results list 

					System.out.println("\n(" + number + ") " + toy.toString());
					options.add(number);
					number ++;
					searchResults.add(toy); // works, might not need it 
				
				}
			}
			System.out.println("\n(" + number + ") " + "Back to the search main menu."); //back to menu function

			break;
		
		default:
			appMenu.invalidInput();
			appMenu.backToSearchInventory();
			
		}
		
		//purchasing happens here
		appMenu.selectOption();
		
		//massive copy and paste
		while (!input.hasNextInt()) { //this validation works
			input.nextLine();
			appMenu.invalidInput();
			appMenu.selectOption(); 
			
		}

		int userInput = input.nextInt();
		
		// find highest option available 
		int optionLength = options.size() + 1;
		
//		System.out.println("ln 575 - option length" + optionLength);
		
		// declaring compare to outside of the if else 
		// make if loop, where if user selects back to main, we break loop 
		// MISTAKE we're calling from the whole toy list, not the specific search results list 
	
		
		if (userInput < optionLength - 1) { //IF USER IS PURCHASING EVERYTHING IS HERE, add in greater than zero
		String compareTo = searchResults.get(userInput - 1).getSerialNumber();
		//rewrite this to take from search results now main toylist 
		for (index = 0; index < toyList.size(); index ++) {
		String currentToy = toyList.get(index).getSerialNumber();
		toyQuantity = toyList.get(index).getAvailableCount();

			if (currentToy.equals(compareTo)) {
				
				//debugging
//				System.out.println("debugging... located at line 589");
//				System.out.println(compareTo);
//				System.out.println(currentToy); //it keeps calling toys not in the list, might have to make a separate lists with the choices 
//				System.out.println(toyQuantity);

					itemFound = true;
					//purchasing item so that i can access compareTo
					
					// purchasing of item happens here
		if (itemFound == true) {
			if (toyQuantity > 0) {
				
				//debugging
//				System.out.println("We have this many in the system: " + toyQuantity);
//				System.out.println("The toy you're purchasing is: "  );
				
				//double check to see if we need to change from main toy to search results list, probably don't to
				
				for(rewrite = 0; rewrite < toyList.size(); rewrite++) {
					String activeToy = toyList.get(rewrite).getSerialNumber();
//					toyQuantity = toyList.get(rewrite).getAvailableCount();

					if (activeToy.equals(compareTo)) {
						toyList.get(rewrite).setAvailableCount(toyQuantity - 1);
						appMenu.purchaseSuccess();
						
						//now we save 
						try {
							save();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							System.out.println("We couldn't save your changes.");
						}
						break;
					}
				}
			}
			else { //no more of item 
				System.out.println("We're out of this item sorry!");
			}
		}
					
				}
			}
			
		}
		else if (userInput == optionLength){ 
//			itemFound = false;
			appMenu.backToSearchInventory();
		}
		
//		try { //get rid of this since we're calling a press enter
//			System.out.println("\n");
//			searchInventory();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			System.out.println("we couldn't send you back to the search inventory menu.");
//		}
		
		// a press enter
				input.nextLine(); //clears the buffer 
				appMenu.pressEnter();
				String userChoice;
				do {
					userChoice = input.nextLine();
				} while (userChoice.length() != 0);
				try {
					searchInventory();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("We couldn't send you back to the search inventory menu.");
				}
			
	}
	
	public void save() throws Exception { //originally private
		File db = new File(FILE_PATH);
		PrintWriter printWriter = new PrintWriter(db);
		
		appMenu.saveMessage();
//		appMenu.visitMessage();
		
		for (Toy t: toyList) {
			printWriter.println(t.format());
		}
		printWriter.close();
	}
	
	private void loadData() throws Exception{
		File db = new File(FILE_PATH);
		String currentLine;
		String[] splitLine;
		
//		try {
//			File db = new File(FILE_PATH);
//		}
//		catch (FileNotFoundException e){
//			System.out.println("File not found!");
//		}
		
		if (db.exists()) {
			Scanner fileReader = new Scanner(db);
			while (fileReader.hasNextLine()) {
				currentLine = fileReader.nextLine();
//				currentLine = currentLine.toLowerCase(); //changes the file to lowercase on default
				splitLine = currentLine.split(";");
						
				String serialNumber = splitLine[0];
				String toyName = splitLine[1];
				String toyBrand = splitLine[2];
				double toyPrice = Double.parseDouble(splitLine[3]);
				int availableCount = Integer.parseInt(splitLine[4]);
				int appropriateAge = Integer.parseInt(splitLine[5]);

				if (serialNumber.charAt(0) == '0' || serialNumber.charAt(0) == '1') {
					String figureClassification = splitLine[6];
					
					toy = new Figures(serialNumber, toyName, toyBrand, toyPrice, availableCount, appropriateAge, figureClassification); 
				}
				else if (serialNumber.charAt(0) == '2' || serialNumber.charAt(0) == '3') {
					String animalMaterial = splitLine[6];
					String animalSize = splitLine[7];
					
					toy = new Animals(serialNumber, toyName, toyBrand, toyPrice, availableCount, appropriateAge, animalMaterial, animalSize);
				}
				else if (serialNumber.charAt(0) == '4' || serialNumber.charAt(0) == '5' || serialNumber.charAt(0) == '6') {
					String puzzleType = splitLine[6];
					
					toy = new Puzzles(serialNumber, toyName, toyBrand, toyPrice, availableCount, appropriateAge, puzzleType);
				}
				else if (serialNumber.charAt(0) == '7' || serialNumber.charAt(0) == '8' || serialNumber.charAt(0) == '9') {
					int minimumPlayerCount = 0;
					int maximumPlayerCount = 0;
					String boardGameDesigners;
					String checkForString = splitLine[6];
					
					// this code accounts for that players counts are now saved 
					// separately after you rewrite the file 
					if (checkForString.length()!= 1) {
						minimumPlayerCount = Character.getNumericValue(splitLine[6].charAt(0));
						maximumPlayerCount = Character.getNumericValue(splitLine[6].charAt(2));	
						boardGameDesigners = splitLine[7];
					}else {
						minimumPlayerCount = Character.getNumericValue(splitLine[6].charAt(0));
						maximumPlayerCount = Character.getNumericValue(splitLine[7].charAt(0));
						boardGameDesigners = splitLine[8];

					}
					
					toy = new BoardGames(serialNumber, toyName, toyBrand, toyPrice, availableCount, appropriateAge, minimumPlayerCount, maximumPlayerCount, boardGameDesigners);
				}
					toyList.add(toy); 
//					System.out.println(toyList);
			}
			fileReader.close();
		}
		else {
			db.createNewFile();
		}
	}
	

	
	
}
