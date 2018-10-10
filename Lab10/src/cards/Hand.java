package cards;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Hand {
	private ArrayList<Card> hand;

	/**
	 * Skapar ett objekt som kan hålla reda på en spelares kort på hand. Från början
	 * är handen tom.
	 */
	Hand() {
		hand = new ArrayList<>();
	}

	public ArrayList<Card> getHand() {
		return hand;
	}

	/** Sätter in kortet c. Korten sorteras in efter stigande valör. */
	void insert(Card c) {
		hand.add(c);
		sortHand();

	}

	/**
	 * Tar bort och returnerar kortet på posititon pos från handen. Korten numreras
	 * från 0 och uppåt.
	 */
	Card remove(int pos) {
		return hand.remove(pos);

	}

	/** Returnerar antalet kort. */
	int nbrCards() {
		return hand.size();

	}

	/**
	 * Beräknar summan av kortens valörer. Om ace14 har värdet true ska ess räknas
	 * som 14, annars som 1.
	 */
	int rankSum(boolean ace14) {
		int sum = 0;
		int ace = ace14 ? 14 : 1;
		for (int i = 0; i < hand.size(); i++) {
			if (hand.get(i).getRank() == 1) {
				sum += ace;

			} else {
				sum += hand.get(i).getRank();
			}

		}

		return sum;
	}

	/** Visar korten i fönstret w. */
	void display(CardWindow w) {
		w.displayCards(hand);
	}

	public void sortHand() {
		Collections.sort(hand, (a, b) -> a.getRank() < b.getRank() ? -1 : a.getRank() == b.getRank() ? 0 : 1);
	}

}
