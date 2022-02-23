import java.util.ArrayList;

/**
 * @author Meer Abdullah 
 * @date April 13th, 2021 
 * @synopsis The player class represents
 * the player that is playing the game in CrazyEights.
 */
public class Player {
	private String name;
	private int id;
	private Deck deck;
	private ArrayList<Card> cardInHand;

	/**
	 * Player constructor that creates an attribute of a Player, and what they need
	 * to play CrazyEights.
	 */
	public Player(String name, int id, Deck deck) {
		this.name = name;
		this.id = id;
		this.deck = deck;
		cardInHand = new ArrayList<Card>();
	}

	/**
	 * Getter method for name
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Getter method for id
	 * @return int
	 */
	public int getId() {
		return id;
	}

	/**
	 * Getter method for Deck
	 * @return Deck
	 */
	public Deck getDeck() {
		return deck;
	}

	/**
	 * Deals 5 cards, and adds it to the players hand.
	 */
	public void dealFiveCards() {
		for (int i = 0; i < 5; i++) {
			cardInHand.add(getDeck().deal());
			cardInHand.get(i).turn();
		}
	}

	/**
	 * String representations of cards in players hand.
	 * @return String
	 */
	public String cardInHandToString() {
		String str = "Hello, " + getName() + "! Your cards are ";
		for (int i = 0; i < cardInHand.size(); i++) {
			str += cardInHand.get(i).toString();
		}
		return str.substring(0, str.length() - 2) + "!";
	}

	/**
	 * @param card Places card in players hand.
	 */
	public void placeCard(Card card) {
		cardInHand.add(card);
	}

	/**
	 * @param card Removes card in players hand.
	 */
	public void removeCard(Card card) {
		cardInHand.remove(card);
	}

	/**
	 * Getter method for cards in hand.
	 * @return Card
	 */
	public ArrayList<Card> cardsInHand() {
		return cardInHand;
	}

	/**
	 * Getter method for cards not in hand.
	 * @return Card
	 */
	public ArrayList<Card> cardsInEmptyHand() {
		return new ArrayList<Card>();
	}

	/**
	 * String representation of player
	 * @return String
	 */
	public String toString() {
		return name + " " + id;
	}
}
