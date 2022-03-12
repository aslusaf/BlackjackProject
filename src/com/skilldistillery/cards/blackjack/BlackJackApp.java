package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

import com.skilldistillery.cards.common.MenuBuilder;

public class BlackJackApp {

	public static void main(String[] args) {

		BlackJackApp bjApp = new BlackJackApp();
		BlackJackTable table = new BlackJackTable();
		MenuBuilder mb = new MenuBuilder("What would you like to do?", "M", 2);
		mb.addMenuOptions("Hit", "Stay");
		Scanner kb = new Scanner(System.in);
		boolean endGame = bjApp.startGame(table);
		if (!endGame) {
			bjApp.playGame(kb, table, mb);
		}

		bjApp.endGame(table);

		kb.close();

	}

	public boolean startGame(BlackJackTable table) {

		boolean endGame = false;

		table.dealer.getDeck().shuffleDeck();

		table.dealer.getDeck().dealCard(table.dealer.getDealerHand());
		table.dealer.getDeck().dealCard(table.player1.getPlayerHand());
		table.dealer.getDeck().dealCard(table.dealer.getDealerHand());
		table.dealer.getDeck().dealCard(table.player1.getPlayerHand());

		if (checkCards(table.player1.getPlayerHand())) {
			endGame = true;
		}
		if (!endGame)
			table.displayCards();

		return endGame;
	}

	public boolean checkCards(BlackJackHand hand) {
		
		hand.getHandValue();
		return hand.isBlackJack() || hand.isBust();
	}

	public void playGame(Scanner kb, BlackJackTable table, MenuBuilder mb) {
		int userChoice = 0;
		boolean endGame = false;
		while (userChoice != 2 && !endGame) {
			mb.printMenu();
			userChoice = kb.nextInt();
			kb.nextLine();

			switch (userChoice) {
			case (1):
				table.dealer.getDeck().dealCard(table.player1.getPlayerHand());
				endGame = checkCards(table.player1.getPlayerHand());
				break;
			case (2):
				table.dealer.hitOrStay();
				break;
			default:
				System.out.println("Invalid selection.");
			}
			if (!endGame)
				table.displayCards();
		}

	}

	public void endGame(BlackJackTable table) {
		table.dealer.declareWinner(table.player1);
	}

}
