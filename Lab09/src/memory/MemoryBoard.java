package memory;

import java.util.Arrays;
import java.util.Random;

public class MemoryBoard {
	private MemoryCardImage memoryCardsOnTheBoard[][];
	private MemoryCardImage memoryCards[];
	private int size;
	private boolean[][] booleanCardsOnTheboard;

	/**
	 * Skapar ett memorybräde med size * size kort. backFileName är filnamnet för
	 * filen med baksidesbilden. Vektorn frontFileNames innehåller filnamnen för
	 * frontbilderna.
	 */

	public MemoryBoard(int size, String backFileName, String[] frontFileNames) {
		this.size = size;
		memoryCardsOnTheBoard = new MemoryCardImage[size][size];
		booleanCardsOnTheboard = new boolean[size][size];
		MemoryCardImage[] mcList = this.createCards(backFileName, frontFileNames);

		for (int i = 0; i < size; i++) {
			int start = size * i;
			int end = size * i + size;
			memoryCardsOnTheBoard[i] = Arrays.copyOfRange(mcList, start, end);
		}
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				booleanCardsOnTheboard[i][j] = false;
			}
		}
	}

	/*
	 * Skapar size * size / 2 st memorykortbilder. Placerar ut varje kort på två
	 * slumpmässiga ställen på spelplanen.
	 */
	private MemoryCardImage[] createCards(String backFileName, String[] frontFileNames) {
		memoryCards = new MemoryCardImage[frontFileNames.length * 2];
		for (int i = 0; i < memoryCards.length; i++) {
			if (i >= frontFileNames.length) {
				memoryCards[i] = memoryCards[i - frontFileNames.length];
			} else {
				memoryCards[i] = new MemoryCardImage(frontFileNames[i], backFileName);
			}
		}
		shuffleArray(memoryCards);
		return memoryCards;
	}

	/** Tar reda på brädets storlek. */
	public int getSize() {
		return size;
	}

	/**
	 * Hämtar den tvåsidiga bilden av kortet på rad r, kolonn c. Raderna och
	 * kolonnerna numreras från 0 och uppåt.
	 */
	public MemoryCardImage getCard(int r, int c) {
		return memoryCardsOnTheBoard[r][c];
	}

	/** Vänder kortet på rad r, kolonn c. */
	public void turnCard(int r, int c) {
		booleanCardsOnTheboard[r][c] = !booleanCardsOnTheboard[r][c];

	}

	/** Returnerar true om kortet r, c har framsidan upp. */
	public boolean frontUp(int r, int c) {

		return booleanCardsOnTheboard[r][c];
	}

	/**
	 * Returnerar true om det är samma kort på rad r1, kolonn c2 som på rad r2,
	 * kolonn c2.
	 */
	public boolean same(int r1, int c1, int r2, int c2) {
		if (memoryCardsOnTheBoard[r1][c1].equals(memoryCardsOnTheBoard[r2][c2])) {
			return true;
		}
		return false;
	}

	/** Returnerar true om alla kort har framsidan upp. */
	public boolean hasWon() {

		for (int i = 0; i < booleanCardsOnTheboard.length; i++) {
			for (int j = 0; j < booleanCardsOnTheboard[i].length; j++) {
				if (!booleanCardsOnTheboard[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	static void shuffleArray(MemoryCardImage[] ar) {
		// Fisher–Yates shuffle
		Random rnd = new Random();
		for (int i = ar.length - 1; i > 0; i--) {
			int index = rnd.nextInt(i + 1);
			// Simple swap
			MemoryCardImage a = ar[index];
			ar[index] = ar[i];
			ar[i] = a;
		}
	}

}
