package com.skilldistillery.cards.common;

import java.util.ArrayList;

public abstract class Hand {

	protected ArrayList<Card> hand;

	public Hand() {
		hand = new ArrayList<>();
	}

	public void addCard(Card card) {
		hand.add(card);
	}

	public void clear() {
		hand.clear();
	}

	public abstract int getHandValue();

	@Override
	public String toString() {

		StringBuilder cardsInHand = new StringBuilder();

		if (hand == null) {
			cardsInHand.append("There are no cards in the hand.");
		} else {
			for (Card card : hand) {
				card.toString();
			}
		}

		return cardsInHand.toString();
	}

}
