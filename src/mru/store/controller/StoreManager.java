package mru.store.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
	private String figureClassification;
	private String animalMaterial;
	private String animalSize;
	private String puzzleType;
	
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
	
	public void addToy() {
		serialNumber = null;
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
		
		appMenu.promptToySerialNumberAdd();
			input.nextLine(); // clear the buffer
		do {
			serialNumber = input.nextLine().trim();
			if (serialNumber.length() != 10) {
				appMenu.invalidInput();
				appMenu.promptToySerialNumberAdd();
			}
		} while (serialNumber == null || serialNumber.length() != 10);
		
		appMenu.promptToyNameAdd();
		do {
			toyName = input.nextLine().trim();
		} while (toyName == null);
		
		appMenu.promptToyBrand();
		do {
			toyBrand = input.nextLine().trim();
		} while (toyBrand == null);
		
		//INSERT TRY AND CATCH HERE FOR PRICE
		//ask him about this if this is ok since he wants custom exceptions
		appMenu.promptToyPrice();
		
		do {
		toyPrice = input.nextDouble();
		
		try {
		toy.setToyPrice(toyPrice);	
			} catch (Exception e){
			e.printStackTrace();
			
			appMenu.invalidInput();
			appMenu.promptToyPrice();
		}	
			}while (toyPrice <=0);
		
//		do {
//			toyPrice = input.nextDouble();
//			if (toyPrice <= 0) {
//				appMenu.invalidInput();
//				appMenu.promptToyPrice();
//			}
//		} while (toyPrice <= 0);
		
		appMenu.promptAvailableCount();
		do {
			availableCount = input.nextInt();
			if (availableCount <= 0) {
				appMenu.invalidInput();
				appMenu.promptAvailableCount();
			}
		} while (availableCount <= 0);
		
		appMenu.promptAppropriateAge();
		do {
			appropriateAge = input.nextInt();
			if (appropriateAge <= 0) {
				appMenu.invalidInput();
				appMenu.promptAppropriateAge();
			}
		} while (appropriateAge <= 0);
		
		//figure
		if (serialNumber.charAt(0) == '0' || serialNumber.charAt(0) == '1') {
			appMenu.promptFigureClassification();
			do {
				figureClassification = input.nextLine().toUpperCase();
				if (figureClassification != "A" && figureClassification != "D" && figureClassification != "H") {
					appMenu.invalidInput();
					appMenu.promptFigureClassification();
				}
			} while (figureClassification != "A" && figureClassification != "D" && figureClassification != "H");
		}
		
		//animal
		if (serialNumber.charAt(0) == '2' || serialNumber.charAt(0) == '3') {
			appMenu.promptAnimalMaterial();
			do {
				animalMaterial = input.nextLine().trim().toUpperCase();
			} while (animalMaterial == null);	
			
			appMenu.promptAnimalSize();
			do {
				animalSize = input.nextLine().trim().toUpperCase();
				if (animalSize != "S" && animalSize != "M" && animalSize != "L") {
					appMenu.invalidInput();
					appMenu.promptAnimalSize();
				}
			} while (animalSize != "S" && animalSize != "M" && animalSize != "L");
		}
		
		// puzzle
		if (serialNumber.charAt(0) == '4'|| serialNumber.charAt(0) == '5' || serialNumber.charAt(0) == '6') {
			appMenu.promptPuzzleType();
			do {
				puzzleType = input.nextLine().trim().toUpperCase();
				if (puzzleType != "M" && puzzleType != "C" && puzzleType != "L" && puzzleType != "T" && puzzleType != "R") {
					appMenu.invalidInput();
					appMenu.promptPuzzleType();
				}
			} 	while (puzzleType != "M" && puzzleType != "C" && puzzleType != "L" && puzzleType != "T" && puzzleType != "R");
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
					BoardGames boardGame = (BoardGames)toy;
					
					 boardGame.setMaxPlayerCount(maximumPlayers);
				}catch (Exception e){
					e.printStackTrace();
					
					appMenu.invalidInput();
					appMenu.promptBoardGameMaximumPlayers();
				}	
			} while (minimumPlayers < maximumPlayers);
			
			
			appMenu.promptBoardGameDesigners();
			input.nextLine(); // clear buffer 
			do {
				designerNames = input.nextLine().trim();
			} while (designerNames == null);
		}
		System.out.println("New toy added!");
	}
	
	public void removeToy() {
		serialNumber = null;
		boolean currentToyFound = false;
		
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
			for (Toy toy:toyList) {
				String currentToy = toy.getSerialNumber();
				if (currentToy.equals(serialNumber)) {
					System.out.println(toy.toString());
					currentToyFound = true;
				}
			}
		}
		
		if (currentToyFound == true) {
			appMenu.removeMessage();
			String removeChoice = input.nextLine().toLowerCase();
			switch (removeChoice) {
			case "y":
				// remove toy
//				toyList.remove(toy);
//				
//				System.out.println("toy being removed is: " + toy);
//				System.out.println("testing to remove first toy in list");
//				System.out.println(toyList);
				
				appMenu.removeSuccess();
			case "n":
				appMenu.removeFail();
			}
		}
		else {
			appMenu.itemNotFound();
		}
	}	
	
	private void searchBySerialNumber(String serialNumber) {		
		boolean itemFound = false;
		for (Toy toy:toyList) {
			String currentToy = toy.getSerialNumber();		
			if (currentToy.equals(serialNumber)) {
				System.out.println(toy.toString());
				itemFound = true;
			}
		}
		
		if (!itemFound) {
				appMenu.itemNotFound();
				appMenu.backToSearchInventory();	
			}
	}
	
	private void searchByToyName(String searchToyName) {
		for (Toy toy:toyList) {
			String currentToy = toy.getToyName();		
			if (currentToy.toLowerCase().contains(searchToyName)) {
				System.out.println(toy.toString());
			}
		}
	}
	
	private void searchByToyType(int searchToyType) {
		//change this to switch cases to make my life easier for user validation
		switch(searchToyType) {
		
		case 1:
			for (Toy toy:toyList) {	
				if (toy.getSerialNumber().charAt(0) == '0' || toy.getSerialNumber().charAt(0) == '1') {
					System.out.println(toy.toString());
				}
			}
			break;
		case 2:
			for (Toy toy:toyList) {	
				if (toy.getSerialNumber().charAt(0) == '2' || toy.getSerialNumber().charAt(0) == '3') {
					System.out.println(toy.toString());
				}
			}
			break;
		
		case 3:
			for (Toy toy:toyList) {	
				if (toy.getSerialNumber().charAt(0) == '4' || toy.getSerialNumber().charAt(0) == '5' || toy.getSerialNumber().charAt(0) == '6') {
					System.out.println(toy.toString());
				}
			}
			break;
		
		case 4:
			for (Toy toy:toyList) {	
				if (toy.getSerialNumber().charAt(0) == '7' || toy.getSerialNumber().charAt(0) == '8' || toy.getSerialNumber().charAt(0) == '9') {
					System.out.println(toy.toString());
				}
			}
			break;
		
		default:
			appMenu.invalidInput();
			appMenu.backToSearchInventory();
			try {
				searchInventory();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
//		if (searchToyType == 1) { // figures
//			for (Toy toy:toyList) {	
//				if (toy.getSerialNumber().charAt(0) == '0' || toy.getSerialNumber().charAt(0) == '1') {
//					System.out.println(toy.toString());
//				}
//			}
//		}
//		else if (searchToyType == 2) { // animals
//			for (Toy toy:toyList) {	
//				if (toy.getSerialNumber().charAt(0) == '2' || toy.getSerialNumber().charAt(0) == '3') {
//					System.out.println(toy.toString());
//				}
//			}
//		}
//		else if (searchToyType == 3) { // puzzles
//			for (Toy toy:toyList) {	
//				if (toy.getSerialNumber().charAt(0) == '4' || toy.getSerialNumber().charAt(0) == '5' || toy.getSerialNumber().charAt(0) == '6') {
//					System.out.println(toy.toString());
//				}
//			}
//		}
//		else if (searchToyType == 4) { // boardgames
//			for (Toy toy:toyList) {	
//				if (toy.getSerialNumber().charAt(0) == '7' || toy.getSerialNumber().charAt(0) == '8' || toy.getSerialNumber().charAt(0) == '9') {
//					System.out.println(toy.toString());
//				}
//			}
//		}
//		else {
//			appMenu.invalidInput();
//			appMenu.backToSearchInventory();
//			try {
//				searchInventory(); //something is still in the buffer and clear buffer isn't working
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		}
	}
	
	public void save() throws Exception { //originally private
		File db = new File(FILE_PATH);
		PrintWriter printWriter = new PrintWriter(db);
		
		appMenu.saveMessage();
		
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
