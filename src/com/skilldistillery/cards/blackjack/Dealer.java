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

	public boolean playAgain(Scanner kb, MenuBuilder playAgainMenu) {
		boolean playAgain = false;
		boolean tryAgain;
		int userInput = 0;
		do {
			tryAgain = false;
			playAgainMenu.printMenu();
			try {
				userInput = kb.nextInt();
			} catch (InputMismatchException e) {
				userInput = 0;
			}
			kb.nextLine();

			switch (userInput) {
			case (1):
				playAgain = true;
				break;
			case (2):
				break;
			default:
				if (!tryAgain) {
					System.err.println("Invalid selection");
					tryAgain = true;
				}
			}
		} while (tryAgain);

		return playAgain;

	}
	
	public void declareWinner(Player player1) {
		boolean playerWins = false;
		MenuBuilder mb = new MenuBuilder();
		mb.printBanner("Winner", "XL", 1);

		if (dealerHand.isBlackJack()) {

			mb.printBanner(showHand(), "XL");

		} else if (player1.getPlayerHand().isBlackJack()) {

			mb.printBanner(player1.toString(), "XL");
			playerWins = true;

		} else if (player1.getPlayerHand().isBust()) {

			mb.printBanner(showHand(), "XL");

		} else if (!dealerHand.isBust() && dealerHand.getHandValue() >= player1.getPlayerHand().getHandValue()) {

			mb.printBanner(showHand(), "XL");

		} else {

			mb.printBanner(player1.toString(), "XL");
			playerWins = true;
		}

		mb.printBanner("Loser", "XL");

		if (playerWins) {

			mb.printBanner(showHand(), "XL");

		} else {

			mb.printBanner(player1.toString(), "XL");

		}
		System.out.println();
	}

	public String toString() {

		StringBuilder dealerCardsToShow = new StringBuilder();

		dealerCardsToShow.append("Dealer: ? | ");
		dealerCardsToShow.append(dealerHand.getHand().get(1).toString() + ".");

		return dealerCardsToShow.toString();

	}

}
