package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Deck;
import com.skilldistillery.cards.common.MenuBuilder;

public class BlackJackTable {
	Deck deck = new Deck();
	Dealer dealer = new Dealer(deck);
	Player player1 = new Player();

	public void displayCards() {
		MenuBuilder mb = new MenuBuilder();
		mb.printBanner(dealer.toString(), "XL");
		mb.printBanner(player1.toString(), "XL");
		System.out.println();

	}
}