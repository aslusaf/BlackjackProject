package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

import com.skilldistillery.cards.common.MenuBuilder;

public class BlackJackApp {

	public static void main(String[] args) {

		BlackJackTable table = new BlackJackTable();
		MenuBuilder playAgainMenu = new MenuBuilder("Would you like to play again?", "M", 2);
		playAgainMenu.addMenuOptions("Yes", "No");
		MenuBuilder mb = new MenuBuilder("What would you like to do?", "M", 2);
		mb.addMenuOptions("Hit", "Stay");
		Scanner kb = new Scanner(System.in);

		boolean playAgain;
		do {

			boolean endGame = table.startGame();
			if (!endGame) {
				table.playGame(kb, mb);
			}

			table.endGame();

			playAgain = table.playAgain(kb, playAgainMenu);

		} while (playAgain);
		
		mb.printBanner("Goodbye!");

		kb.close();

	}

}
