
import java.util.ArrayList;
import java.util.Arrays;


public class Hand {
	
	private ArrayList<Card> hand;
	
	/**
	 * Constructs hand initiated with two 2 card objects in the hand.
	 */
	public Hand(Card card1, Card card2) {
		hand = new ArrayList<Card>(Arrays.asList(card1,card2));
	}
	/**
	 * Adds a card to the array of cards
	 * 
	 * Input: card
	 */
	public void addCard(Card card) {
		hand.add(card);
		//Collections.sort(hand);
	}
	/**
	 * Returns the sum of the values of all the cards in the hand, 
	 * based on the rules of BlackJack.
	 * 
	 * Output: hand's total value 
	 */
	public int getValue() {
		int value = 0;
		for (Card card : hand) {
			value += card.getValue();
		}
		return value;
		
	}
	public String toString() {
		String s = "";
		for (Card card : hand) {
			s += card.toString() + "\n";
		}
		return s.substring(0,s.length()-1);
		
	}
	public int size() {
		return hand.size();
	}
}