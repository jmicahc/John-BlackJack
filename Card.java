
public class Card {
	private String suit;
	private int number;
	
	public Card(String suit, int number) {
		this.suit = suit;
		this.number = number;
	}
	/**
	 * Returns the value of the hand according to the rules of BlackJack
	 * Ace = 11
	 * face card = 10
	 * number cards have a point value equal to there number
	 * 
	 * Output: hand's value (int)
	 */
	public int getValue() {
		if (number==1) {
			return 11;
		} else if (number<10) {
			return number;
		}else
			return 10;
	}
	/**
	 * Returns a String representation of the card's suit
	 * 
	 * Output: suit (String)
	 */
	public String getSuit() {
		return suit;
	}
	/**
	 * returns the card number according to the following mapping:
	 *  1   2 3 4 5 6 7 8 9 10  11    12    13
	 * Ace  2 3 4 5 6 7 8 9 10 Jack queen  King
	 * 
	 * return: card number
	 */
	public int getNum() {
		return number;
	}
	/**
	 * Returns a String representation of the card in the form of
	 * suit + value, where the value is either the card's number or
	 * its face-card name (jack, queen, king, ace).
	 * 
	 * Return: String representation of card.
	 */
	public String toString() {
		switch(number) {
		case (11): return (suit + " Jack");
		case (12): return (suit + " Queen");
		case (13): return (suit + " King");
		case (1): return (suit + " Ace");
		default: return (suit + " " + number);
		}
	}
}