package cards;

import java.util.ArrayList;

public class Game21 {

	public static String displayTheGameResult(Hand h) {
		int result = h.rankSum(true);
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
		ArrayList<Card> cards = deck.getCardsInDeck();
		Hand hand = new Hand();
		hand.insert(cards.get(0));
		hand.insert(cards.get(1));
		hand.insert(cards.get(3));
		hand.display(w);
		w.displayText(displayTheGameResult(hand));
		w.waitForMouseClick();
		w.close();
		System.exit(0);

	}

}
