package cards;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;

import se.lth.cs.pt.window.SimpleWindow;

public class CardWindow extends SimpleWindow {
	private static final int IMG_HEIGHT = 100;
	private static final int IMG_WIDTH = 75;
	private Card[][] cards; // contains the displaued cards (used at mouse click)
	private int rows;
	private int cols;

	/**
	 * Constructs a window with rows rows and cols columns which can
	 * display playing cards. The window has the title title.
	 */
	public CardWindow(int rows, int cols, String title) {
		super(cols * IMG_WIDTH, rows * IMG_HEIGHT + 20, title);
		this.rows = rows;
		this.cols = cols;
		cards = new Card[rows][cols];
	}

	/**
	 * Displays the cards in the list cardList.
	 * 
	 * @param cardList
	 *            a list containing cards
	 */
	public void displayCards(List<Card> cardList) {
		clear();
		int r = 0;
		int c = 0;
		for (Card aCard : cardList) {
			displayCard(aCard, r, c);
			c++;
			if (c == cols) {
				c = 0;
				r++;
				if (r == rows) {
					break; // Inga fler kort får plats i fönstret
				}
			}
		}
	}

	/**
	 * Displays the cards in the array cardArray.
	 * 
	 * @param cardArray
	 *            an array containing cards
	 */
	public void displayCards(Card[] cardArray) {
		ArrayList<Card> cardList = new ArrayList<Card>(Arrays.asList(cardArray));
		displayCards(cardList);
	}
	
	/**
	 * Displays the card aCard in line r, column c. Rows and columns are
	 * numbered from 0 and up.
	 * 
	 * @param aCard
	 *            the card to display
	 * @param r
	 *            the row in which card will be displayed
	 * @param c
	 *            the column in which card will be displayed
	 */
	public void displayCard(Card aCard, int r, int c) {
		displayImage(getImg(aCard), r, c);
		cards[r][c] = aCard;
	}


	/* Retrieves the image corresponding to the card. */
	private Image getImg(Card aCard) {
		File pathToFile = null;
		if (aCard == null) {
			pathToFile = new File("cardset-oxymoron/shade.gif");
		} else {
			String suits = "cdhs";
			char c = suits.charAt(aCard.getSuit());
			String fileName = String.format("%s/%02d%c.gif", "cardset-oxymoron", aCard.getRank(), c);
			pathToFile = new File(fileName);
		}
		Image img = null;
		try {
			img = ImageIO.read(pathToFile);
		} catch (IOException ex) {
			System.err.println("Failed to create image");
			ex.printStackTrace();
		}
		return img;
	}

	/* Displays the image img in row r, column c.  */
	private void displayImage(Image img, int r, int c) {
		int x = c * IMG_WIDTH + 1;
		int y = r * IMG_HEIGHT + 1;
		moveTo(x, y);
		drawImage(img);
	}

	/**
	 * Waits for mouseclick. Returns the card at the mouse click. If no card
	 * exist at the mouse click null is returned.
	 * 
	 * @return the card clicked on or null if the click is outside the cards.
	 */
	public Card getClickedCard() {
		waitForMouseClick();
		if (check(getMouseX(), getMouseY())) {
			return cards[getMouseRow()][getMouseCol()];
		}
		return null;
	}

	/**
	 * Waits for mouseclick. Deletes and returns the card at the mouse click. If
	 * no card exist on the mouse click null is returned.
	 * 
	 * @return the card clicked on or null if the click is outside the cards.
	 */
	public Card deleteCard() {
		waitForMouseClick();
		if (check(getMouseX(), getMouseY())) {
			Card c = cards[getMouseRow()][getMouseCol()];
			if (c != null) {
				erase(getMouseRow(), getMouseCol());
				return c;
			}
		}
		return null;
	}
	
	/* Checks if x, y is inside a card position. */
	private boolean check(int x, int y) {
		return y < rows * IMG_HEIGHT && x < cols * IMG_WIDTH;
	}

	/* Returns the row at the last mosue click. */
	private int getMouseRow() {
		return getMouseY() / IMG_HEIGHT;
	}

	/* Returns the column at the last mosue click. */
	private int getMouseCol() {
		return getMouseX() / IMG_WIDTH;
	}


	/* Deletes the image of the card in row r, column c. */
	private void erase(int r, int c) {
		cards[r][c] = null;
		Image img = null;
		try {
			File pathToFile = new File("cardset-oxymoron/shade.gif");
			img = ImageIO.read(pathToFile);
		} catch (IOException ex) {
			System.err.println("Failed to create image of " + "cardset-oxymoron/shade.gif");
			ex.printStackTrace();
		}
		displayImage(img, r, c);
	}

	/**
	 * Wait for a specified time.
	 * 
	 * @return the number of milliseconds to wait
	 */
	public static void delay(int ms) {
		SimpleWindow.delay(ms);
	}
	
	/**
	 * Displays the string s in the window.
	 * 
	 * @param s
	 *            the string to be displayed
	 */
	public void displayText(String s) {
		clear();
		for (int r = 0; r < cards.length; r++) {
			displayCards(cards[r]);
		}
		this.moveTo(5, this.getHeight() - 5);
		this.writeText(s);
	}
}
