package com.min.edu;

import java.util.Scanner;

/**
 * 메인 메소드 포함 대부분의 게임 로직, 등을 갖는 클래스
 * 
 * @author 이진희
 *
 */
public class Blackjack {

	public static void main(String[] args) {

		// Welcome Message
		System.out.println("Welcome to Blackjack!");

		// Create out playing deck
		Deck playingDeck = new Deck();
		playingDeck.createFullDeck();
		playingDeck.shuffle();
//		System.out.println(playingDeck);

		// Create a deck for the player
		Deck playerDeck = new Deck();

		Deck dealerDeck = new Deck();

		double playerMoney = 100.00;

		Scanner userInput = new Scanner(System.in);

		// Game Loop
		while (playerMoney > 0) {
			// Play On!
			// Take the players bet
			System.out.println("You have $" + playerMoney + ", how much would you like to bet?");
			double playerBet = userInput.nextDouble();
			if (playerBet > playerMoney) {
				System.out.println("You cannot bet mor than you have. Please leave.");
				break;
			}
			
			boolean endRound = false;

			// Start Dealing
			// Player gets two cards
			playerDeck.draw(playingDeck);
			playerDeck.draw(playingDeck);

			// Dealer gets two cards
			dealerDeck.draw(playingDeck);
			dealerDeck.draw(playingDeck);

			while (true) {
				System.out.println("Your hand:");
				System.out.println(playerDeck.toString());
				System.out.println("Your hand is valued at :" + playerDeck.cardsValue());
				
				//Display Dealer Hand
				System.out.println("Dealer Hand: " + dealerDeck.getCard(0).toString() + " and [Hidden]");
				
				//What does the player want to do?
				System.out.println("Would you like to (1) Hit or (2) Stand:?");
				int response = userInput.nextInt();
				
				//They Hit
				if(response == 1) {
					playerDeck.draw(playingDeck);
					System.out.println("You draw a " + playerDeck.getCard(playerDeck.deckSize()-1).toString());
					//bust if > 21
					if(playerDeck.cardsValue() > 21) {
						System.out.println("Bust. Currently valued at: " + playerDeck.cardsValue());
						playerMoney -= playerBet;
						endRound = true;
					}
				}
				if(response == 2) {
					break;
				}
			}
			
			//Reveal Dealer Cards
			System.out.println("Dealer Cards: " + dealerDeck.toString());
			//See if dealer has more point than player
			if((dealerDeck.cardsValue()>=17) && (dealerDeck.cardsValue() > playerDeck.cardsValue()) && endRound == false) {
				System.out.println("Dealer beats you!");
				playerMoney -= playerBet;
				endRound = true;
			}
			//Dealer Draws at 16, stand at 17
			while((dealerDeck.cardsValue() < 17) && endRound == false) {
				dealerDeck.draw(playingDeck);
				System.out.println("Dealer Draws: " + dealerDeck.getCard(dealerDeck.deckSize()-1).toString());
			}
			//Display Total Value for Dealer
			System.out.println("Dealer's Hand is valued at: " + dealerDeck.cardsValue());
			//Determine if dealer busted
			if((dealerDeck.cardsValue() > 21) && endRound == false) {
				System.out.println("Dealer busts! You win.");
				playerMoney += playerBet;
				endRound = true;
			}
			//Determine if push
			if((playerDeck.cardsValue() == dealerDeck.cardsValue()) && endRound == false) {
				System.out.println("Push");
				endRound = true;
			}
			if ((playerDeck.cardsValue() > dealerDeck.cardsValue()) && endRound == false) {
				System.out.println("You win the hand!");
				playerMoney += playerBet;
				endRound = true;
			}
			
			playerDeck.moveAllToDeck(playingDeck);
			dealerDeck.moveAllToDeck(playerDeck);
			System.out.println("End of hand.");
		}
		
		System.out.println("Game over! You are out of money :(");

	}

}
