import se.lth.cs.pt.square.Square;
import se.lth.cs.pt.window.SimpleWindow;

public class DrawClickSquare {

	public static void drawSquare(int x, int y, Square sq, SimpleWindow w) {
		sq.erase(w);
		int oldX1 = sq.getX();
		int oldY1 = sq.getY();
		sq.move(x - oldX1, y - oldY1);
		sq.draw(w);
	}

	public static void drawRowOfSquares(int x, int y, Square sq, SimpleWindow w) {

		int oldX = sq.getX();
		int oldY = sq.getY();
		int dX = x - oldX;
		int dY = y - oldY;
		int stepX = dX / 10;
		int stepY = dY / 10;
		for(int i = 0; i<10;i++) {
			oldX = oldX + stepX;
			oldY = oldY + stepY;
			drawSquare(oldX, oldY, sq, w);
			w.delay(10);

		}
	}

	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "PrintClickSquare");

		Square sq = new Square(0, 0, 90);
		sq.draw(w);
		while (true) {
			w.waitForMouseClick();
			int x = w.getMouseX();
			int y = w.getMouseY();
			drawRowOfSquares(x, y, sq, w);
		}
	}

}
