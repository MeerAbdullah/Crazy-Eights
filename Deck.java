/**
 * @uthor Meer Abdullah 
 * @date April 13th, 2021 
 * @synopsis The Deck class creates a Deck
 * of cards, including a pile, for user to utilize in their card game.
 */
import java.util.Random;
import java.util.ArrayList;

/**
 * public class Deck - where a deck of cards are made
 */
public class Deck {

	/*
	 * Static instance variables - each instance of deck has to have the same cards
	 * and values.
	 */
	public static int MAX_SIZE = 52;
	private static ArrayList<Card> pile;
	private static ArrayList<Card> card; // pile instance variable added due to CrazyEights functionality.

	/**
	 * Resets the Deck
	 */
	public Deck() {
		reset();
	}

	/**
	 * Resets the Deck by creating a new ArrayList
	 */
	public void reset() {
		card = new ArrayList<Card>();
		pile = new ArrayList<Card>();
		addSuit(Suit.spade);
		addSuit(Suit.heart);
		addSuit(Suit.diamond);
		addSuit(Suit.club);
	}

	/**
	 * Static getter method for pile
	 * @return pile
	 */
	public static ArrayList<Card> getPile() {
		return pile;
	}

	/**
	 * Static getter method for card
	 * @return card
	 */
	public static ArrayList<Card> getCard() {
		return card;
	}

	/**
	 * Updates the Deck by removing card from the top of the Deck.
	 */
	public static void removeFromCard() {
		card.remove(card.size() - 1);
	}

	/**
	 * @param - Instance of Card Adds a card to the pile
	 */
	public void addToPile(Card card) {
		pile.add(card);
	}

	/**
	 * @param - Instance of Suit Adds a new Card to the deck
	 */
	private void addSuit(Suit suit) {
		for (int i = 1; i <= 13; i++) {
			card.add(new Card(suit, i));
		}
	}

	/**
	 * Checks to see if the deck is empty.
	 * @return Boolean
	 */
	public boolean isEmpty() {
		return card.isEmpty();
	}

	/**
	 * Checks the size of the deck.
	 * @return int
	 */
	public int size() {
		return card.size();
	}

	/**
	 * Deals a card out of the deck, and as it does this it removes that card.
	 * @return Card
	 */
	public Card deal() {
		if (isEmpty())
			return null;
		else {
			return card.remove(card.size() - 1);
		}
	}

	/**
	 * @param - number Deals multiple cards out of the 
	 * deck, and as it does this it removes those cards.
	 * @return Card[]
	 */
	public Card[] deal(int number) {
		if (number > card.size())
			return null;
		else {
			Card[] hand = new Card[number];
			for (int i = 0; i < number; i++) {
				hand[i] = deal();
			}
			return hand;
		}
	}

	/**
	 * Shuffles the deck
	 */
	public static void shuffle() {
		if (card.size() < MAX_SIZE)
			return;
		Random gen = new Random();
		Card[] array = new Card[MAX_SIZE];
		while (card.size() > 0) {
			Card sing_card = card.remove(card.size() - 1);
			int i = gen.nextInt(MAX_SIZE);
			while (array[i] != null)
				i = gen.nextInt(MAX_SIZE);
			array[i] = sing_card;
		}
		for (Card sing_card : array)
			card.add(sing_card);
	}

	/**
	 * String representation of the Deck
	 * @return String
	 */
	public String toString() {
		String result = "";
		for (Card cards : card) {
			result += cards + "\n";
		}
		return result;
	}
}
