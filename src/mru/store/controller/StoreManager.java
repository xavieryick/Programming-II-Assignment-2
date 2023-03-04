package mru.store.controller;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import mru.game.model.Player;
import mru.store.model.Toy;
import mru.store.view.AppMenu;

public class StoreManager {
	
	private final String FILE_PATH = "res/toys.txt";
	AppMenu appMenu;
	ArrayList<Toy> toyList;
	
	public StoreManager() {
		appMenu = new AppMenu();
		toyList = new ArrayList<>();
	}
	
	public void save() throws Exception { //originally private
		File db = new File(FILE_PATH);
		PrintWriter printWriter = new PrintWriter(db);
		
		System.out.println("Saved! \n Have a good day!");
		
		for (Toy t: toyList) {
			printWriter.println(t.format());
		}
		printWriter.close();
	}
	
	private void loadData() throws Exception {
		File db = new File(FILE_PATH);
		String currentLine;
		String[] splitLine;
		
		if (db.exists()) {
			Scanner fileReader = new Scanner(db);
			while (fileReader.hasNextLine()) {
				currentLine = fileReader.nextLine();
				splitLine = currentLine.split(";");
				
				long serialNumber = Integer.parseInt(splitLine[0]);
				if (serialNumber >= 000000000L && serialNumber <= 1999999999L) {
					//toys are based on first two numbers in serial numbers 
					//read index 0 
				}
				else if (serialNumber >= 2000000000L && serialNumber <= 3999999999L) {
					
				}
				else if (serialNumber >= 4000000000L && serialNumber <= 6999999999L) {
					
				}
				else if (serialNumber >= 7000000000L && serialNumber <= 9999999999L) {
					
				}
				
//				Player p = new Player(splitLine[0], Integer.parseInt(splitLine[1]), Integer.parseInt(splitLine[2]));
				toyList.add(null); // add the toy somewhere
			}
			fileReader.close();
		}
		else {
			db.createNewFile();
		}
	}
}
