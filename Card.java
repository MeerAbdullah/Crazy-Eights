/**
* Author: Meer Abdullah
* Date: 4/13/2021
* Synopsis: The Card class creates one card out of a stack of 52 to create a Deck of cards.
* @version %i%
*/
public class Card implements Comparable<Card>{

  private Suit suit;
  private int rank;
  private boolean faceUp;

  /**
  * Suit and a rank is needed top create a Card object.
  */
  public Card(Suit suit, int rank){
    this.suit = suit;
    this.rank = rank;
    faceUp = false;
  }

  /**
  * @param - other
  * Checks to see if 2 cards equal eachother
  * @return boolean
  */
  public boolean equals(Object other){
    if(this == other)
      return true;
    else if(!(other instanceof Card))
      return false;
    else{
      Card otherCard = (Card)other;
      return rank == otherCard.rank;
    }
  }

  /**
  * @param - other
  * Compares cards using Comparable<T> interface
  * @return int
  */
  public int compareTo(Card other){
    if(!(other instanceof Card))
      throw new IllegalArgumentException("Parameter must be a Card");
    else{
      Card card = (Card)other;
      return rank - card.rank;
    }
  }

  /**
  * Getter method for the rank
  * @return int
  */
  public int getRank(){
    return rank;
  }

  /**
  * Getter method for the Suit
  * @return Suit
  */
  public Suit getSuit(){
    return suit;
  }
  
  /**
  * Getter method for faceUp
  * @return boolean
  */
  public boolean isFaceUp(){
    return faceUp;
  }

  /**
  * Checks to see if the current card is red.
  * @return boolean
  */
  public boolean isRed(){
    return suit == Suit.heart || suit == Suit.diamond;
  }

  /**
  * Makes the card faceUp value true
  */
  public void turn(){
    faceUp = !faceUp;
  }

  /**
  * String representation of Card.
  * return String;
  */
  public String toString(){
    return rankToString() + " of " + suit + ", ";
  }

  /**
  * String representation of Cards rank.
  * return String;
  */
  private String rankToString(){
    if(rank == 1)
      return "Ace";
    else if (rank == 11)
      return "Jack";
    else if (rank == 12)
      return "Queen";
    else if (rank == 13)
      return "King";
    else
      return "" + rank;
  }
}