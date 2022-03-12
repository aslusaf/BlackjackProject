package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

import com.skilldistillery.cards.common.MenuBuilder;

public class BlackJackApp {

	public static void main(String[] args) {
		
		BlackJackApp bjApp = new BlackJackApp();
		MenuBuilder mb = new MenuBuilder("What would you like to do?", "M", 2);
		mb.addMenuOptions("Hit", "Stay");
		Scanner kb = new Scanner(System.in);
		bjApp.startGame();
		bjApp.playRound(kb, mb);
		
		
		
		
		
		
		
		kb.close();
		
	}
	
	public void startGame() {
		
		BlackJackTable table = new BlackJackTable();
		
	    table.dealer.getDeck().shuffleDeck();
		
	    table.dealer.getDeck().dealCard(table.dealer.getDealerHand());
	    table.dealer.getDeck().dealCard(table.player1.getPlayerHand());
	    table.dealer.getDeck().dealCard(table.dealer.getDealerHand());
	    table.dealer.getDeck().dealCard(table.player1.getPlayerHand());
	    
	    table.displayCards();
	    
	}
	
	public void playRound(Scanner kb, MenuBuilder mb) {
		
		mb.printMenu();
		int userChoice = kb.nextInt();
		kb.nextLine();
		
		switch(userChoice) {
		case (1):
		case (2):
		}
		
		
	}
	

}
