package mru.store.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BoardGamesTest {
	BoardGames toy;
	
	@Test
	void setBoardGamePlayerCountTest() {
		toy = new BoardGames(1234567890, "battleship", "matel", 15, 10, 5, 5, "shippers");
		toy.setBoardGamePlayerCount(5);
		int boardGamePlayerCount = toy.getBoardGamePlayerCount();
		assertEquals(boardGamePlayerCount, 5);
	}
	
	@Test
	void getBoardGamePlayerCountTest() {
		toy = new BoardGames(1234567890, "battleship", "matel", 15, 10, 5, 5, "shippers");
		int boardGamePlayerCount = toy.getBoardGamePlayerCount();
		assertEquals(boardGamePlayerCount, 5);
	}
	
	@Test
	void setBoardGameDesginersTest() {
		toy = new BoardGames(1234567890, "battleship", "matel", 15, 10, 5, 5, "shippers");
		toy.setBoardGameDesigners("shippers");
		String boardGameDesigners = toy.getBoardGameDesigners();
		assertEquals(boardGameDesigners, "shippers");
	}
	
	@Test
	void getBoardGameDesginersTest() {
		toy = new BoardGames(1234567890, "battleship", "matel", 15, 10, 5, 5, "shippers");
		String boardGameDesigners = toy.getBoardGameDesigners();
		assertEquals(boardGameDesigners, "shippers");
	}
}
