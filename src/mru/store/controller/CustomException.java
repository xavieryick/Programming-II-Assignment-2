package mru.store.controller;

public class CustomException extends Exception{
	//Some help: https://www.baeldung.com/java-new-custom-exception
	
	public CustomException(String errorMessage) {
		
		super(errorMessage);
	}
//	//might not need this is we can just put the message in the root spot
//	public CustomException(int price) {
//		
//		super("Prices can't be negative!");
//	}
}
