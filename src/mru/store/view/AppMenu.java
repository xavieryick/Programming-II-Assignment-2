package mru.store.view;

public class AppMenu {

	public AppMenu() {}
	
	public void welcomeMessage() {
		System.out.println("*****************************\n"
						+  "* WELCOME TO THE TOY STORE! *\n"
						+  "*****************************");
	}
	
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
	
	public void invalidInput() {
		System.out.println("Invalid input!");
	}
	
	public void selectOption() {
		System.out.println("\nSelect an item to purchase or go back to the main menu.");
	}
	
	public void pressEnter() {
		System.out.println("\nPress enter to continue.");
	}
	
	public void backToSearchInventory() {
		System.out.println("Sending you back to the search inventory menu...");
	}
	
	public void backToMainMenu() {
		System.out.println("Sending you back to the main menu...");
	}
	
	public void searchResults() {
		System.out.println("Here are the search results");
	}
	
	public void promptToySerialNumber() {
		System.out.println("Please enter a serial number: ");
	}
	
	public void promptInvalidSerialNumber() {
		System.out.println("Invalid serial number, serial number must be 10 digits long!");
	}
	
	public void promptToyName() {
		System.out.println("Please enter a toy name: ");
	}
	
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
	
	public void promptToySerialNumberAdd() {
		System.out.println("Enter serial number: ");
	}
	
	public void promptToyNameAdd() {
		System.out.println("Enter toy name: ");
	}
	
	public void promptToyBrand() {
		System.out.println("Enter toy brand: ");
	}
	
	public void promptToyPrice() {
		System.out.println("Enter toy price: ");
	}
	
	public void promptAvailableCount() {
		System.out.println("Enter available count: ");
	}
	
	public void promptAppropriateAge() {
		System.out.println("Enter appropriate age: ");
	}
	
	public void promptFigureClassification() {
		System.out.println("Enter figure classification \n"
				+ "\t A) Action \n"
				+ "\t D) Doll \n"
				+ "\t H) Historic \n"
				+ "Enter a letter: ");
	}
	
	public void promptAnimalMaterial() {
		System.out.println("Enter animal material: ");
	}
	
	public void promptAnimalSize() {
		System.out.println("Enter animal size \n"
				+ "\t S) Small \n"
				+ "\t M) Medium \n"
				+ "\t L) Large \n"
				+ "Enter a letter: ");
	}
	
	public void promptPuzzleType() {
		System.out.println("Enter puzzle type \n"
				+ "M) Mechanical \n"
				+ "C) Cryptic \n"
				+ "L) Logic \n"
				+ "T) Trivia \n "
				+ "R) Riddle \n"
				+ "Enter a letter: ");
	}
	
	public void promptBoardGameMinimumPlayers() {
		System.out.println("Enter minimum number of players: ");
	}
	
	public void promptBoardGameMaximumPlayers() {
		System.out.println("Enter maximum number of players: ");
	}
	
	public void promptBoardGameDesigners() {
		System.out.println("Enter designer names (Use ',' to separate): ");
	}
	
	public void removeMessage() {
		System.out.println("Do you want to remove this toy? (Y/N): ");
	}
	
	public void purchaseMessage() {
		System.out.println("Do you want to purchase this toy? (Y/N): ");
	}
	
	public void itemNotFound() {
		System.out.println("Item not found!");
	}
	
	public void removeSuccess() {
		System.out.println("Item successfully removed!");
	}
	
	public void removeFail() {
		System.out.println("Item was not removed.");
	}
	
	public void purchaseSuccess() {
		System.out.println("Item was successfully purchased.");
	}
	
	public void purchaseFail() {
		System.out.println("Item was not purchased!");
	}
	
	public void saveMessage() {
		System.out.println("Saving your choice into the database...\n");
	}
	
	public void visitMessage() {
		System.out.println("********** THANKS FOR VISITING US! **********");
	}
}
