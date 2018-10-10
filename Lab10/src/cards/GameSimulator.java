package cards;

import java.util.ArrayList;

public class GameSimulator {
	private static final int NBR_ITERATIONS = 10000;
	private static boolean isCardSameAsCounter(Card card, int counter) {
		if (card.getRank() == counter) {

			// System.out.println(card.getRank() + " " + card.getSuit() + " counter= " +
			// counter);
			return true;
		}
		return false;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int winsCounter = 0;

		for (int k = 0; k <= NBR_ITERATIONS; k++) {

			Deck deck = new Deck();
			ArrayList<Card> list = new ArrayList<Card>();
			int[] suitVect = new int[4]; // Nbr clubs, diamonds etc
			int[] rankVect = new int[13]; // nbr ones, twos etc
			while (deck.moreCards()) {

				Card c = deck.getCard();
				suitVect[c.getSuit()]++;
				rankVect[c.getRank() - 1]++;

				list.add(c);
			}

			// CardWindow w = new CardWindow(1, 1, "Card deck");
			int j = 1;
			for (int i = 0; i < list.size(); i++) {
				// w.displayCard(list.get(i), 0, 0);
				j = j <= 3 ? j : 1;
				// w.displayText(String.valueOf(j));
				// w.delay(100);
				if (isCardSameAsCounter(list.get(i), j)) {
					// w.close();
					break;
				} else if (i ==list.size() - 1) {
					winsCounter++;
				}
				j++;
			}
		}

		System.out.println(winsCounter/10000.d);
	}

}
