public class Suit implements Comparable<Suit> {

	public static final Suit spade = new Suit(4, "Spades");
	public static final Suit heart = new Suit(4, "Heart");
	public static final Suit diamond = new Suit(4, "Diamond");
	public static final Suit club = new Suit(4, "Club");

	private int order;
	private String name;

	public Suit(int order, String name) {
		this.order = order;
		this.name = name;
	}

	public int compareTo(Suit other) {
		if (!(other instanceof Suit))
			throw new IllegalArgumentException("Parameter must be a suit");
		Suit suit = (Suit) other;
		return order - suit.order;
	}

	public String toString() {
		return name;
	}
}
