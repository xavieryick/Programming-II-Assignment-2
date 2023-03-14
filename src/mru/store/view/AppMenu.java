package mru.store.view;
/**
 * This class displays the app menu. 
 * 
 * @author kaydence eng
 * @author xavier yick
 *
 */
public class AppMenu {

	public AppMenu() {}
	/**
	 * This method pints the welcome message.
	 */
	public void welcomeMessage() {
		System.out.println("*****************************\n"
						+  "* WELCOME TO THE TOY STORE! *\n"
						+  "*****************************");
	}
	/**
	 * This method prints the main menu.
	 */
	public void showMainMenu() {
		System.out.println("Hello!\n"
				+ "How may we help you? \n"
				+ "\n"
				+ "\t (1) Search inventory and purchase toy \n"
				+ "\t (2) Add a new toy \n"
				+ "\t (3) Remove a toy \n"
				+ "\t (4) Save and exit \n"
				+ "\n"
				+ "Please enter a number: ");
	}
	/**
	 * This method prints the search inventory menu.
	 */
	public void showSearchInventory() {
		System.out.println("Find toys with: \n"
				+ "\n"
				+ "\t (1) Serial Number (SN) \n"
				+ "\t (2) Toy Name \n"
				+ "\t (3) Toy Type \n"
				+ "\t (4) Return to Main Menu \n"
				+ "\n"
		 		+ "Please enter a number: ");	
	}
	
	/**
	 * This method prints a message if the user enters an invalid input
	 */
	public void invalidInput() {
		System.out.println("Invalid input!");
	}
	
	/**
	 * This method prints a message asking the user to select an option
	 */
	public void selectOption() {
		System.out.println("\nSelect an item to purchase or go back to the main menu.");
	}
	
	/**
	 * This method prints a message asking the user to press enter
	 */
	public void pressEnter() {
		System.out.println("\nPress enter to continue.");
	}
	
	/**
	 * This method prints a message if the program is going back to the search inventory menu
	 */
	public void backToSearchInventory() {
		System.out.println("Sending you back to the search inventory menu...");
	}
	
	/**
	 * This method prints a message if the program is going back to the main menu
	 */
	public void backToMainMenu() {
		System.out.println("Sending you back to the main menu...");
	}
	
	/**
	 * This method prints a message with search results
	 */
	public void searchResults() {
		System.out.println("\nHere are the search results: ");
	}
	
	/**
	 * This method prints a message asking the user for a serial number
	 */
	public void promptToySerialNumber() {
		System.out.println("Please enter a serial number: ");
	}
	
	
	/**
	 * This method prints a message if the user's serial number is invalid
	 */
	public void promptInvalidSerialNumber() {
		System.out.println("Invalid serial number, serial number must be 10 digits long!");
	}
	
	/**
	 * This method prints a message if the user's serial number is existing
	 */
	public void duplicateSerialNumber() {
		System.out.println("This serial number is already taken, enter a different one please!");
	}
	
	/**
	 * This method prints a message asking the user for a toy name
	 */
	public void promptToyName() {
		System.out.println("Please enter a toy name: ");
	}
	
	/**
	 * This method prints a message asking the user for a toy type
	 */
	public void promptToyType() {
		System.out.println("Toy Types: \n"
				+ "\n"
				+ "\t 1) Figures \n"
				+ "\t 2) Animals \n"
				+ "\t 3) Puzzles \n"
				+ "\t 4) Board Games \n"
				+ "\n"
				+ "Please enter a number: ");
	}
	
	/**
	 * This method prints a message asking the user for a new serial number
	 */
	public void promptToySerialNumberAdd() {
		System.out.println("Enter serial number: ");
	}
	
	/**
	 * This method prints a message asking the user for a new toy's name
	 */
	public void promptToyNameAdd() {
		System.out.println("Enter toy name: ");
	}
	
	/**
	 * This method prints a message asking the user for a new toy's brand
	 */
	public void promptToyBrand() {
		System.out.println("Enter toy brand: ");
	}
	
	/**
	 * This method prints a message asking the user for a new toy's price
	 */
	public void promptToyPrice() {
		System.out.println("Enter toy price: ");
	}
	
	/**
	 * This method prints a message asking the user for a new toy's available count
	 */
	public void promptAvailableCount() {
		System.out.println("Enter available count: ");
	}
	
	/**
	 * This method prints a message asking the suer for a new toy's appropriate age
	 */
	public void promptAppropriateAge() {
		System.out.println("Enter appropriate age: ");
	}
	
	/**
	 * This method prints a message asking the user for a new figure's classification
	 */
	public void promptFigureClassification() {
		System.out.println("Enter figure classification \n"
				+ "\t A) Action \n"
				+ "\t D) Doll \n"
				+ "\t H) Historic \n"
				+ "Enter a letter: ");
	}
	
	/**
	 * This method prints a message asking the user for a new animal's material
	 */
	public void promptAnimalMaterial() {
		System.out.println("Enter animal material: ");
	}
	
	/**
	 * This method prints a message asking the user for a new animal's size
	 */
	public void promptAnimalSize() {
		System.out.println("Enter animal size \n"
				+ "\t S) Small \n"
				+ "\t M) Medium \n"
				+ "\t L) Large \n"
				+ "Enter a letter: ");
	}
	
	/**
	 * This method prints a message asking the user for a new puzzle's type
	 */
	public void promptPuzzleType() {
		System.out.println("Enter puzzle type \n"
				+ "\t M) Mechanical \n"
				+ "\t C) Cryptic \n"
				+ "\t L) Logic \n"
				+ "\t T) Trivia \n"
				+ "\t R) Riddle \n"
				+ "Enter a letter: ");
	}
	
	/**
	 * This method prints a message asking for a new board game's minimum player count
	 */
	public void promptBoardGameMinimumPlayers() {
		System.out.println("Enter minimum number of players: ");
	}
	
	/**
	 * This method prints a message asking for a new board game's maximum player count
	 */
	public void promptBoardGameMaximumPlayers() {
		System.out.println("Enter maximum number of players: ");
	}
	
	/**
	 * This method prints a message asking for a new board game's designers
	 */
	public void promptBoardGameDesigners() {
		System.out.println("Enter designer names (Use ',' to separate): ");
	}
	
	/**
	 * This method prints asking the user if they want to remove a toy
	 */
	public void removeMessage() {
		System.out.println("Do you want to remove this toy? (Y/N): ");
	}
	
	/**
	 * THis method prints asking the user if they want to purchase a toy
	 */
	public void purchaseMessage() {
		System.out.println("Do you want to purchase this toy? (Y/N): ");
	}
	
	/**
	 * This method prints if a user's item is found
	 */
	public void itemFound() {
		System.out.println("\nItem Found!\n");
	}
	
	/**
	 * This method prints if a user's item is not found
	 */
	public void itemNotFound() {
		System.out.println("Item not found!");
	}
	
	/**
	 * This method prints if the user's item is sucessfully removed
	 */
	public void removeSuccess() {
		System.out.println("Item successfully removed!");
	}
	
	/**
	 * This method prints if the user's item was not removed
	 */
	public void removeFail() {
		System.out.println("Item was not removed.");
	}
	
	/**
	 * This method prints if the user's item is sucessfully purchased
	 */
	public void purchaseSuccess() {
		System.out.println("Item was successfully purchased.");
	}
	
	/**
	 * This method prints if the user's item was not purchased
	 */
	public void purchaseFail() {
		System.out.println("Item was not purchased!");
	}
	
	/**
	 * This method prints after a toy is sucessfully added to the database
	 */
	public void saveMessage() {
		System.out.println("Saving your choices into the database...\n");
	}
	
	/**
	 * This method prints thanking the user for visiting the store on close
	 */
	public void visitMessage() {
		System.out.println("********** THANKS FOR VISITING US! **********");
	}
}
