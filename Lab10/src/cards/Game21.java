package cards;

import java.util.ArrayList;

public class Game21 {

	private static ArrayList<Card> createShuffledDeck(Deck deck) {
		ArrayList<Card> list = new ArrayList<Card>();
		int[] suitVect = new int[4]; // Nbr clubs, diamonds etc
		int[] rankVect = new int[13]; // nbr ones, twos etc
		while (deck.moreCards()) {
			Card c = deck.getCard();
			suitVect[c.getSuit()]++;
			rankVect[c.getRank() - 1]++;
			list.add(c);
		}

		return list;

	}

	public static String displayTheGameResult(Hand h) {
		int result = h.rankSum(false);
		String gameStatus = "";
		if (result > 21) {
			gameStatus = "You lost the game. You got  ";
		} else {

			gameStatus = "You won the game. You got  ";

		}

		return gameStatus + result;
	}

	public static void main(String[] args) {
		CardWindow w = new CardWindow(1, 3, "Card deck");
		Deck deck = new Deck();
		ArrayList<Card> cards = createShuffledDeck(deck);
		Hand hand = new Hand();
		hand.insert(cards.get(0));
		hand.insert(cards.get(1));
		hand.insert(cards.get(3));
		hand.display(w);
		w.displayText(displayTheGameResult(hand));
		w.waitForMouseClick();
		w.close();

	}

}
