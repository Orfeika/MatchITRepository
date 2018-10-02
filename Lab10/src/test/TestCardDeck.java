package test;

import java.util.ArrayList;

import cards.Card;
import cards.CardWindow;
import cards.Deck;

public class TestCardDeck {
 	/** Metod för att testa metoderna i klassen CardDeck */
	public static void main(String[] args) {
		Deck deck = new Deck();	
		ArrayList<Card> list = new ArrayList<Card>();
		int[] suitVect = new int[4];   // Nbr clubs, diamonds etc
		int[] rankVect = new int[13];  // nbr ones, twos etc
		while (deck.moreCards()) {
			Card c = deck.getCard();
			suitVect[c.getSuit()]++; 
			rankVect[c.getRank()-1]++;
			list.add(c);
		}
		
		System.out.print("Number cards in the different suits: ");
		for (int i = 0; i <= 3; i++) {
			System.out.print(suitVect[i] + " ");
		}
		System.out.println();
		System.out.print("Number cards in the different ranks: ");
		for (int i = 0; i <= 12; i++) {
			System.out.print(rankVect[i] + " ");
		}
		System.out.println();
		
		CardWindow w = new CardWindow(4, 13, "Card deck");
		w.displayCards(list);
	}
}