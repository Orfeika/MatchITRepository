import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;

import cards.Card;
import cards.CardWindow;
import cards.Deck;

public class Game {

	private static boolean isCardSameAsCounter(Card card, int counter) {
		if (card.getRank() == counter) {

			System.out.println(card.getRank() + "  " + card.getSuit() + " counter= " + counter);
			return true;
		}
		return false;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int winsCounter = 0;
		Deck deck = new Deck();
		
		CardWindow w = new CardWindow(1, 1, "Card deck");
		int j = 1;
		ArrayList<Card> list = deck.getCardsInDeck();
		for (int i = 0; i <list.size() ; i++) {
			w.displayCard(list.get(i), 0, 0);
			j = j <= 3 ? j : 1;
			w.displayText(String.valueOf(j));
			w.delay(100);
			if (isCardSameAsCounter(list.get(i), j) ) {
				w.waitForMouseClick();
				w.close();
				break;
			}else {
				winsCounter++;

			}
			j++;
		}

	}

}
