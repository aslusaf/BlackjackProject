package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

	ArrayList<Card> deck = new ArrayList<>(52);

	public Deck() {

		for (Suit suit : Suit.values()) {

			for (Rank rank : Rank.values()) {

				deck.add(new Card(suit, rank));

			}

		}

	}

	public int checkDeckSize() {
		return deck.size();
	}

	public Card dealCard() {
		return deck.remove(0);
	}
	
	public void dealCard(Hand hand) {
		hand.addCard(deck.remove(0));
	}

	public void shuffleDeck() {
		Collections.shuffle(deck);
	}

}
