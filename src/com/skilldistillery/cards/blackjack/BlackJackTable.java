package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Deck;

public class BlackJackTable {
	Deck deck = new Deck();
	Dealer dealer = new Dealer(deck);
	Player player1 = new Player();

	public void displayCards() {

		System.out.println(dealer.toString());
		System.out.println(player1.toString());

	}
}