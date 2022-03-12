package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.MenuBuilder;

public class Player {

	private BlackJackHand playerHand;

	public Player() {
		playerHand = new BlackJackHand();
	}

	public BlackJackHand getPlayerHand() {
		return playerHand;
	}

	public String toString() {

		StringBuilder playerCardsToShow = new StringBuilder();
		
		playerCardsToShow.append("Player: ");
		playerCardsToShow.append(playerHand.getHandValue() + " | ");

		if (playerHand.getHand().size() > 1) {
			for (int i = 0; i < playerHand.getHand().size(); i++) {
				playerCardsToShow.append(playerHand.getHand().get(i).toString());
				String punctuation = (playerHand.getHand().size()-1 == i) ? "." : ", ";
				playerCardsToShow.append(punctuation);
			}
		} else {
			playerCardsToShow.append("There are no cards for the player to show.");
		}

		return playerCardsToShow.toString();

	}

}
