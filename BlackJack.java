import java.util.Scanner;

/**
 * NOTE: professor Flanagan explicitly allowed the use of an extra class (Card) in
 * this assignment.
 * 
 * time spent: 7 hours
 * 
 * Program: 
 * Authors: John Collins (jmicahc@gmail.com)
 * 
 *
 * CMP 12A/L, Fall 2013
 * Programming Assignment #1
 * November 19, 2013
 *
 * This program simulates the role of dealer in a text-based
 * version of blackjack.
 * 
 * Rules: 
 * Play BlackJack!
 * 1. 
 *
 * Input:
 * (h)it --> adds one card to your hand
 * (n)new hand --> discards the old hand and adds a new one
 * (q)quit ---> quits the game immediately.
 *
 * Output:
 * 1. Players current hand.
 * 2. Total number of points in hand
 * ** responses to various win and loose conditions **
 *
 * Bugs and limitations:
 * Input cannot be blank (i.e. pressing "enter" without entering a character first)
 */

public class BlackJack {
	
	private static Hand hand = null;
	private static Deck deck = new Deck();
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		deck.shuffle();
		
		
		while (true) {
			
			System.out.println("Enter a (n)ew hand, (h)it, or (q)uit:");
			char rsp = scan.nextLine().charAt(0);
			switch(rsp) {
			
			case 'n': 
				
				/**********************************************************************
				 * The top two cards of the deck are given as constructor arguments
				 * for creating a new hand. If not enough cards are left in the deck,
				 * and IndexOutOfBounds error is caught and the program terminates.
				 **********************************************************************/
				try {
					hand = new Hand(deck.topCard(), deck.topCard());
					System.out.println("You have the following cards:\n" + hand);
					break;
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println(" -- NOT ENOUGH CARDS IN DECK -- \n\nBye");
					return;
				} 
			
			case 'h':
				
				/***********************************************************************
				 * One card from the top of the deck is added to the player's hand.  If 
				 * no more cards are left in the deck, an IndexOutOfBounds error is caught
				 * and the program terminates with a message indicating there's no more
				 * cards left in the deck.
				 * 
				 * If the player does not have a hand already, (s)he is prompted to get 
				 * a hand before continuing
				 ***********************************************************************/
				if (hand==null) {
					System.out.println(" -- GET A HAND FIRST -- ");
					break;
				}
				try {
					if (hand.size()<5) {
						hand.addCard(deck.topCard());
					} else
						System.out.println(" -- ALREADY 5 CARDS IN HAND --");
					System.out.println("You have the following cards:\n" +  hand);
					break;
					
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println(" -- NO CARDS LEFT ON DECK -- \n\nBye");
					return;
				}
				
					
			case 'q': 
				
				/**********************************************************************
				 * Terminates the program.
				 **********************************************************************/
				System.out.println("\nBye"); return;
				
			default: 
				
				System.out.println("Option does not exist. Try Again.");
				break;
			}
		update();
		}
		
	}
	/**
	 * Tests for win and loose conditions and updates accordingly.
	 * 
	 * Input: N/A
	 * Output: N/A
	 */
	public static void update() {
		if (hand!=null) {
			System.out.println("Value of your hand is: " + hand.getValue());
			if (hand.getValue() > 21) {
				System.out.println(" -- BUSTED! -- ");
				hand = null;
			} 
			else if (hand.size()==2 && hand.getValue()==21) {
				System.out.println(" === BLACK JACK! === ");
				hand = null;
			}
			else if (hand.getValue()==21) {
				System.out.println(" === HAND COMPLETE! === ");
				hand = null;
			}
		}
		System.out.println();
	}
}