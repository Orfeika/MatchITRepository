package memory;

public class MemoryGame {
	public static void main(String[] args) {
		String[] frontFileNames = {"can.jpg", "flopsy_mopsy_cottontail.jpg",
				"friends.jpg", "mother_ladybird.jpg", "mr_mcgregor.jpg",
				"mrs_rabbit.jpg", "mrs_tittlemouse.jpg", "radishes.jpg" };
		// Fyll i egen kod här
		MemoryBoard mb  = new MemoryBoard(4, "back.jpg", frontFileNames);
		MemoryWindow mw = new MemoryWindow(mb);
		for (int i = 0; i <mb.getSize(); i++) {
			for(int j = 0; j<mb.getSize(); j++) {
				mw.drawCard(i, j);
			}
		}
		while(!mb.hasWon()) {
			mw.waitForMouseClick();
			int row = mw.getMouseCol();
			int col  = mw.getMouseCol();
			mb.turnCard(row, col);
			mw.drawCard(row, col);
			

		}

	}
}
