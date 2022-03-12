package com.skilldistillery.cards.blackjack;

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

	public void hitOrStay() {

		while (dealerHand.getHandValue() < 17) {
			deck.dealCard(dealerHand);
		}

	}

	public void declareWinner(Player player1) {
		MenuBuilder mb = new MenuBuilder();
		mb.printBanner("Winner", "XL", 1);
		mb.printBanner(showHand(), "XL");
		mb.printBanner("Loser", "XL");
		mb.printBanner(player1.toString(), "XL");
		System.out.println("Inside declare winner!");
		System.out.println();
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

	public String toString() {

		StringBuilder dealerCardsToShow = new StringBuilder();

		dealerCardsToShow.append("Dealer: ? | ");
		dealerCardsToShow.append(dealerHand.getHand().get(1).toString() + ".");

		return dealerCardsToShow.toString();

	}

}
