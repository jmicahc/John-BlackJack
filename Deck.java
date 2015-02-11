import java.util.*;

/**
 *  The Deck class is a new type that represents a deck
 *  of cards.  It should have methods that have anything
 *  to do with a deck of cards.  A constructor and a
 *  shuffle method are provided to get you started.
 *  Written by:  Alex Pang
 *  Edited by:   Tom Austin
 *       (replacing tio package with java.util.Scanner
 *        and some updates to formatting.)
 *  Date: Feb 21, 2011
 */


class Deck
{
    public Card[] deck;
    private int topCard = 0;

    /**
     * Constructs the deck of cards. Card Objects are created and 
     * added to the deck. 
     */
    public Deck()
    {
      deck = new Card[52];
	  int num = 0;
      for(int i=0; i<13;) {
    	  deck[i++] = new Card("Club", num+=1);
    	  deck[i+12] = new Card("Diamond", num);
    	  deck[i+25] = new Card("Heart", num);
    	  deck[i+38] = new Card("Spade", num);
    	  
      }
      
    }

    /**
     * Calls the to string method on each card and prints
     * the string to the console with a new line for each
     * card.
     */
    public void print()
    {
      for(int i=0; i<52; i++) System.out.println( deck[i] );
    }

    /**
     * Shuffles the Deck based on a user-given seed. The number
     * of cards swapped randomly is equal to the number of cards
     * in the deck.
     * 
     */
    public void shuffle()
    {
      int i, j;
	  Card tmp;
      int seed;
      Random r;
      Scanner scan = new Scanner(System.in);
      System.out.print( "Enter your lucky number: " );
      seed = scan.nextInt();
      r = new Random(seed); // initialize random # generator
      for(i=topCard; i<52; i++ )  // shuffle deck of cards
      {
        j = r.nextInt(52);  // randomly pick a card
        tmp = deck[j];      // swap with i-th card
        deck[j] = deck[i];
        deck[i] = tmp;
      }
      scan.close();
    }
    /**
     * Removes and returns the top card object in the deck.
     * 
     * Output: top card (Card)
     */
    public Card topCard() throws ArrayIndexOutOfBoundsException{
    	return deck[topCard++];
    
    }
}