package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Hand;

public class BlackJackHand extends Hand {
	
	private int handValue;

	public BlackJackHand() {
	}

	@Override
	public int getHandValue() {
		handValue = 0;
		
		if (!hand.isEmpty()) {
			for (Card card : hand) {
				handValue+=card.getValue();
			}
		}
		return handValue;
	}
	
	public boolean isBlackJack() {
		return (handValue == 21);
	}
	public boolean isBust() {
		return (handValue > 21);
	}
	
	public ArrayList<Card> getHand() {
		return hand;
	}
//	public boolean isSoft() {
//	}

}
