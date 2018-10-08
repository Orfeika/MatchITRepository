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
			int rowCardOne = mw.getMouseRow();
			int colCardOne  = mw.getMouseCol();
			while(mb.frontUp(rowCardOne, colCardOne)) {
				mw.waitForMouseClick();
				rowCardOne = mw.getMouseRow();
				colCardOne  = mw.getMouseCol();
			}
			mb.turnCard(rowCardOne, colCardOne);
			mw.drawCard(rowCardOne, colCardOne);
			mw.waitForMouseClick();
			int rowCardTwo = mw.getMouseRow();
			int colCardTwo  = mw.getMouseCol();
			while(mb.frontUp(rowCardTwo, colCardTwo)) {
				mw.waitForMouseClick();
				rowCardTwo = mw.getMouseRow();
				colCardTwo  = mw.getMouseCol();
			}
			mb.turnCard(rowCardTwo, colCardTwo);
			mw.drawCard(rowCardTwo, colCardTwo);


			if(!(mb.getCard(rowCardOne, colCardOne) 
					== mb.getCard(rowCardTwo, colCardTwo))){
				mb.turnCard(rowCardOne, colCardOne);
				mb.turnCard(rowCardTwo, colCardTwo);
				mw.waitForMouseClick();
				mw.drawCard(rowCardOne, colCardOne);
				mw.drawCard(rowCardTwo, colCardTwo);
				
			}



		}
		mw.close();
	}
}
