package cards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class Deck {
	private ArrayList<Card> cardsInDeck ; 
	
	/** Skapar en blandad kortlek med 52 kort. */
	public Deck() {
		cardsInDeck = new ArrayList<>(52);
		for(int i = 0 ; i<4;i++) {
			for(int j=1; j<=13; j++) {
				Card card = new Card(i, j);
				cardsInDeck.add(card);
			}
		}
		Collections.shuffle(cardsInDeck);		
	}
	
	/** Drar det översta kortet i kortleken. */
	public Card getCard() {

		return cardsInDeck.remove(0);
		//cardsInDeck.size()-1
	}
	
	/** Undersöker om det finns fler kort i kortleken. */
	public boolean moreCards() {
		return !cardsInDeck.isEmpty();
	}

	@Override
	public String toString() {
		return "Deck [cardsInDeck=" + cardsInDeck + "]";
	}

	public ArrayList<Card> getCardsInDeck() {
		return cardsInDeck;
	}
	
	
		

}
