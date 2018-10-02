package cards;

public class Card {
	public static final int CLUBS = 0;
	public static final int DIAMONDS = 1;
	public static final int HEARTS = 2;
	public static final int SPADES = 3;
	
	private int rank;
	private int suit;
	
	/**
	 * Constructs a card with the suit (CLUBS, DIAMOND, HEARTS, SPADES) and
	 * rank (1-13).
	 */
	public Card(int suit, int rank) {
		this.suit = suit;
		this.rank = rank;
	}

	/** 
	 * Returns the suit. 
	 * @returns the suit
	 */
	public int getSuit() {
		return suit;
	}

	/** 
	 * Returns the rank. 
	 * * @returns the rank
	 */
	public int getRank() {
		return rank;
	}

	/**
	 * Returns a string representation of the card consisting of rank and suit
	 * with a space between.
	 * @returns a string representation of the card
	 */
	public String toString() {
		String suitString = "";		
		switch(suit) {
			case Card.SPADES: suitString = "spader"; break;
			case Card.HEARTS: suitString = "hjärter"; break;
			case Card.DIAMONDS: suitString = "ruter"; break;
			case Card.CLUBS: suitString = "klöver"; break;
		}
		String rankString = "";
		switch(rank) {
			case 1: rankString = "ess"; break;
			case 11: rankString = "knekt"; break;
			case 12: rankString = "dam"; break;
			case 13: rankString = "kung"; break;
			default: rankString = String.valueOf(rank);
		}
		return suitString + " " + rankString;
	}
	
}