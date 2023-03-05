package mru.store.controller;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import mru.store.model.*;
import mru.store.model.Toy;
import mru.store.view.AppMenu;

public class StoreManager {
	
	private final String FILE_PATH = "res/toys.txt";
	AppMenu appMenu;
	ArrayList<Toy> toyList;
	
	Toy toy;
	
	public StoreManager() throws Exception {
		appMenu = new AppMenu();
		toyList = new ArrayList<>();
		
		loadData(); //ask if we need to surround this with try and catch 
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
				
				
				// toy specific attributes will be splitLine[index]
				long serialNumber = Long.parseLong(splitLine[0]);
				String toyName = splitLine[1];
				String toyBrand = splitLine[2];
				double toyPrice = Double.parseDouble(splitLine[3]);
				int availableCount = Integer.parseInt(splitLine[4]);
				int appropriateAge = Integer.parseInt(splitLine[5]);
				
				//might have to do charAr if we have problems with leading zeroes
				if (serialNumber >= 000000000L && serialNumber <= 1999999999L) {

					//making new toy to add
					//we add toy at end of loop
					toy = new Figures(serialNumber, toyName, toyBrand, toyPrice, availableCount, appropriateAge, splitLine[6]);
				}
				else if (serialNumber >= 2000000000L && serialNumber <= 3999999999L) {
					toy = new Animals(serialNumber, toyName, toyBrand, toyPrice, availableCount, appropriateAge, splitLine[6], splitLine[7]);
				}
				else if (serialNumber >= 4000000000L && serialNumber <= 6999999999L) {
					toy = new Puzzles(serialNumber, toyName, toyBrand, toyPrice, availableCount, appropriateAge, splitLine[6]);
				}
				else if (serialNumber >= 7000000000L && serialNumber <= 9999999999L) {
					//ignore this min max stuff
					//heads up - changed player count to separate minimum and max values
//					int minimumPlayerCount = Integer.parseInt(splitLine[6]);
//					int maxPlayerCount = Integer.parseInt(splitLine[7]);
					//you can change designers if u want 
					
					//this is the only toy where specifics contain an integer
					//HEY SO PLAYER COUNTS ARE STORED AS A STRING WITH A RANGE 
					//I changed it two values: one for min players and max players
					//So, we need to change it back to one value as string
					toy = new BoardGames(serialNumber, toyName, toyBrand, toyPrice, availableCount, appropriateAge, splitLine[6], splitLine[7]);
				}
				
				//then add to array list
					toyList.add(toy);
					System.out.println(toyList);
			}
			fileReader.close();
		}
		else {
			db.createNewFile();
		}
	}
	

	
	
}
