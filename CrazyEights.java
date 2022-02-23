/**
 * @author Meer Abdullah 
 * @date April 13th, 2021
 * @synopsis The CrazyEights class is a
 * class that allows players to play the Crazy Eight card game.
 */
import java.util.Scanner;

/**
 * CrazyEights Class - where the card game Crazy8's is played!
 */
public class CrazyEights {
	Scanner scan = new Scanner(System.in);
	private Player[] player;
	private Deck deck;

	/**
	 * Initialization of CrazyEights. Intro to 
	 * the game, and starts the CrazyEights game.
	 * @param deck
	 */
	public CrazyEights(Deck deck) {
		int players;
		String y_or_n;
		String name;
		System.out.println("Hey! How many players are going to play Crazy Eights? (2 to 8 people)");
		do {
			players = scan.nextInt();
			if (players <= 0) {
				if (Math.abs(players) <= 8 && Math.abs(players) >= 2) {
					System.out.println(
							"You can't have a negative amount of players. Did you mean " + Math.abs(players) + "?");
					System.out.println("(Enter 'y' for yes, and anything else for no)");
					y_or_n = scan.next();
					if (y_or_n.equals("y")) {
						players = Math.abs(players);
						System.out.println("Alright! The total player count is now " + Math.abs(players) + "!");
						break;
					} else {
						System.out.println("Alright! Enter a valid amount of players!");
					}
				} else if (players == 0) {
					System.out.println("You can't have 0 players. Enter the total players again");
				} else {
					System.out.println("You can't have a negative amount of players. Enter the total players again");
				}
			} else if (players == 1) {
				System.out.println("You can't play Crazy 8's with just yourself! Enter a valid amount of players");
			} else if (players > 8) {
				System.out.println(players + " players is too much! Pick a fewer amount of players!");
			} else {
				break;
			}
		} while (true);
		player = new Player[players + 1];
		System.out.println("Enter the " + players + " player names");
		for (int i = 0; i <= players; i++) {
			name = scan.nextLine();
			player[i] = new Player(name, i + 1, deck);
		}
		this.deck = deck;
		play();
	}

	/**
	 * Plays the CrazyEights game.
	 */
	public void play() {
		int cardNumber = 0, winner = 0;
		Deck.shuffle(); // shuffles deck
		/*
		 * Tells the player to draw 5 cards.
		 */
		for (int i = 1; i < player.length; i++) {
			System.out.println("Hello, " + player[i].getName() + "! Draw 5 cards (you basically just did).");
			player[i].dealFiveCards();
		}
		System.out.println("Which player are you? Enter your name");
		String name = scan.nextLine();
		for (int i = 1; i < player.length; i++) {
			if (player[i].getName().equals(name)) {
				System.out.println(player[i].cardInHandToString());
				break;
			}
		}
		/*
		 * Tells user to look through their cards, and add a card to the pile, if none
		 * of the cards can work, they take a pile from the deck until the deck is
		 * empty.
		 */
		System.out.println("What cards do you want to add to the pile, " + player[1].getName()
				+ "? Enter a number from 1 to " + player[1].cardsInHand().size());
		cardNumber = scan.nextInt();
		player[1].getDeck().addToPile(player[1].cardsInHand().get(0));
		player[1].removeCard(player[1].cardsInHand().get(0));
		for (int i = 2; i < player.length; i++) {
			System.out.println(player[i].cardInHandToString());
			System.out.println("What cards do you want to add to the pile, " + player[i].getName()
					+ "? Enter a number from 1 to " + player[i].cardsInHand().size());
			cardNumber = scan.nextInt();
			if (player[i].cardsInHand().get(cardNumber - 1).getSuit().toString()
					.equals(Deck.getPile().get(Deck.getPile().size() - 1).getSuit().toString())
					|| player[i].cardsInHand().get(cardNumber - 1).getRank() == Deck.getPile()
							.get(Deck.getPile().size() - 1).getRank()
					|| player[i].cardsInHand().get(cardNumber - 1).getRank() == 8) {
				player[i].getDeck().addToPile(player[i].cardsInHand().get(cardNumber - 1));
				player[i].removeCard(player[i].cardsInHand().get(0));
			} else {
				player[i].placeCard(Deck.getCard().get(Deck.getCard().size() - 1));
				Deck.removeFromCard();
			}
		}
		do {
			/*
			 * Checks if the card on top of the pile is equal in terms of domination or suit
			 * to the players chosen card.
			 */
			for (int i = 1; i < player.length; i++) {
				System.out.println(player[i].cardInHandToString());
				System.out.println("What cards do you want to add to the pile, " + player[i].getName()
						+ "? Enter a number from 1 to " + player[i].cardsInHand().size());
				cardNumber = scan.nextInt();
				if (player[i].cardsInHand().get(cardNumber - 1).getSuit().toString()
						.equals(Deck.getPile().get(Deck.getPile().size() - 1).getSuit().toString())
						|| player[i].cardsInHand().get(cardNumber - 1).getRank() == Deck.getPile()
								.get(Deck.getPile().size() - 1).getRank()
						|| player[i].cardsInHand().get(cardNumber - 1).getRank() == 8) {
					player[i].getDeck().addToPile(player[i].cardsInHand().get(cardNumber - 1));
					player[i].removeCard(player[i].cardsInHand().get(0));
				} else {
					player[i].placeCard(Deck.getCard().get(Deck.getCard().size() - 1));
					Deck.removeFromCard();
				}

				if (player[i].cardsInHand().size() == 0) {
					winner = i;
					System.out.println("Congratulations on " + player[winner].getName()
							+ " for winning the Crazy Eights Card Game ! I hope you had a lot of fun ! You can also try to play again !");
					return;
				}
			}
		} while (!deck.isEmpty());

		/*
		 * Runs until broken out of loop. Deck is empty, so we have to check for other
		 * conditions, such as if the players cards in hand is 0, then they become the
		 * winner.
		 */
		while (true) {
			for (int i = 1; i < player.length; i++) {
				System.out.println(player[i].cardInHandToString());
				System.out.println("What cards do you want to add to the pile, " + player[i].getName()
						+ "? Enter a number from 1 to " + player[i].cardsInHand().size());
				cardNumber = scan.nextInt();
				if (player[i].cardsInHand().get(cardNumber - 1).getSuit().toString()
						.equals(Deck.getPile().get(Deck.getPile().size() - 1).getSuit().toString())
						|| player[i].cardsInHand().get(cardNumber - 1).getRank() == Deck.getPile()
								.get(Deck.getPile().size() - 1).getRank()
						|| player[i].cardsInHand().get(cardNumber - 1).getRank() == 8) {
					player[i].getDeck().addToPile(player[i].cardsInHand().get(cardNumber - 1));
					player[i].removeCard(player[i].cardsInHand().get(0));
				}

				if (player[i].cardsInHand().size() == 0) {
					winner = i;
					System.out.println("Congratulations on " + player[winner].getName()
							+ " for winning the Crazy Eights Card Game ! I hope you had a lot of fun ! You can also try to play again !");
					break;
				}
			}
		}
	}
}
