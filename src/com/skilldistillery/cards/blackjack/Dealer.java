package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Deck;

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

	public String toString() {

		StringBuilder dealerCardsToShow = new StringBuilder();
		
		dealerCardsToShow.append("Dealer: ?  | ");
//		dealerCardsToShow.append(dealerHand.getHandValue() + " | ");

		if (dealerHand.getHand().size() > 1) {
			for (int i = 1; i < dealerHand.getHand().size(); i++) {
				dealerCardsToShow.append(dealerHand.getHand().get(i).toString());
			}
		} else {
			dealerCardsToShow.append("There are no cards for the dealer to show.");
		}

		return dealerCardsToShow.toString();

	}

}
