package com.skilldistillery.cards.blackjack;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.skilldistillery.cards.common.Deck;
import com.skilldistillery.cards.common.MenuBuilder;

public class BlackJackTable {
	Deck deck = new Deck();
	Dealer dealer = new Dealer(deck);
	Player player1 = new Player();

	public void displayCards() {
		MenuBuilder mb = new MenuBuilder();
		mb.printBanner(dealer.toString(), "L");
		mb.printBanner(player1.toString(), "L");
		System.out.println();

	}

	public boolean startGame() {

		boolean endGame = false;

		dealer.getDeck().shuffleDeck();

		dealer.getDealerHand().clear();
		player1.getPlayerHand().clear();

		dealer.dealHand(player1);

		endGame = dealer.checkForBlackJack(player1);

		if (!endGame)
			displayCards();

		return endGame;
	}

	public void playGame(Scanner kb, MenuBuilder mb) {
		int userChoice = 0;
		boolean tryAgain = false;
		boolean endGame = false;

		do {
			while (userChoice != 2 && !endGame) {
				mb.printMenu();
				try {
					tryAgain = false;
					userChoice = kb.nextInt();
				} catch (InputMismatchException e) {
					userChoice = 0;
				}
				kb.nextLine();
				System.out.println();
				mb.printBreakBar("L");

				switch (userChoice) {
				case (1):
					dealer.getDeck().dealCard(player1.getPlayerHand());
					endGame = dealer.checkCards(player1.getPlayerHand());
					break;
				case (2):
					endGame = dealer.hitOrStay();
					break;
				default:
					System.err.println("\nInvalid selection.\n");
					tryAgain = true;
				}
				if (!endGame)
					displayCards();
			}
		} while (tryAgain);

	}

	public void endGame() {
		dealer.declareWinner(player1);
	}

	public boolean playAgain(Scanner kb, MenuBuilder playAgainMenu) {
		return dealer.playAgain(kb, playAgainMenu);
	}
}