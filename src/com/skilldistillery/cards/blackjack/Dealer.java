package com.skilldistillery.cards.blackjack;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.skilldistillery.cards.common.Deck;
import com.skilldistillery.cards.common.MenuBuilder;

public class Dealer {

	private BlackJackHand dealerHand;
	private Deck deck;

	public Dealer(Deck deck) {
		this.deck = deck;
		dealerHand = new BlackJackHand();
	}

	public BlackJackHand getDealerHand() {
		return dealerHand;
	}

	public Deck getDeck() {
		return deck;
	}

	public boolean hitOrStay() {

		while (dealerHand.getHandValue() < 17) {
			deck.dealCard(dealerHand);
		}

		return true;

	}

	public void dealHand(Player player1) {
		getDeck().dealCard(getDealerHand());
		getDeck().dealCard(player1.getPlayerHand());
		getDeck().dealCard(getDealerHand());
		getDeck().dealCard(player1.getPlayerHand());

	}

	public boolean checkForBlackJack(Player player1) {

		return (checkCards(getDealerHand()) || checkCards(player1.getPlayerHand()));

	}

	public boolean checkCards(BlackJackHand hand) {

		hand.getHandValue();
		return hand.isBlackJack() || hand.isBust();
	}

	public String showHand() {

		StringBuilder dealerCardsToShow = new StringBuilder();

		dealerCardsToShow.append("Dealer: " + dealerHand.getHandValue() + " | ");

		for (int i = 0; i < dealerHand.getHand().size(); i++) {
			dealerCardsToShow.append(dealerHand.getHand().get(i).toString());
			String punctuation = (dealerHand.getHand().size() - 1 == i) ? "." : ", ";
			dealerCardsToShow.append(punctuation);
		}

		return dealerCardsToShow.toString();

	}

	public void declareWinner(Player player1) {
		boolean playerWins = false;
		MenuBuilder mb = new MenuBuilder();
		mb.printBanner("Winner", "L", 1);

		if (dealerHand.isBlackJack()) {

			mb.printBanner(showHand(), "L");

		} else if (player1.getPlayerHand().isBlackJack()) {

			mb.printBanner(player1.toString(), "L");
			playerWins = true;

		} else if (player1.getPlayerHand().isBust()) {

			mb.printBanner(showHand(), "L");

		} else if (!dealerHand.isBust() && dealerHand.getHandValue() >= player1.getPlayerHand().getHandValue()) {

			mb.printBanner(showHand(), "L");

		} else {

			mb.printBanner(player1.toString(), "L");
			playerWins = true;
		}

		mb.printBanner("Loser", "L");

		if (playerWins) {

			mb.printBanner(showHand(), "L");

		} else {

			mb.printBanner(player1.toString(), "L");

		}
		System.out.println();
	}

	public boolean playAgain(Scanner kb, MenuBuilder playAgainMenu) {
		boolean playAgain = false;
		boolean tryAgain;
		int userInput = 0;
		do {
			tryAgain = false;
			playAgainMenu.printMenu();
			try {
				userInput = kb.nextInt();
				System.out.println();
			} catch (InputMismatchException e) {
				userInput = 0;
			}
			kb.nextLine();
			System.out.println();
			playAgainMenu.printBreakBar("L");

			switch (userInput) {
			case (1):
				playAgain = true;
				break;
			case (2):
				break;
			default:
				if (!tryAgain) {
					System.err.println("\nInvalid selection\n");
					tryAgain = true;
				}
			}
		} while (tryAgain);

		return playAgain;

	}

	public String toString() {

		StringBuilder dealerCardsToShow = new StringBuilder();

		dealerCardsToShow.append("Dealer: ? | ");
		dealerCardsToShow.append(dealerHand.getHand().get(1).toString() + ".");

		return dealerCardsToShow.toString();

	}
}
