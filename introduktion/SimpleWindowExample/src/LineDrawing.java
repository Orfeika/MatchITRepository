import java.awt.Color;

import se.lth.cs.pt.maze.Maze;
import se.lth.cs.pt.square.Square;
import se.lth.cs.pt.window.SimpleWindow;

public class LineDrawing {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(500, 500, "LineDrawing");
		w.moveTo(0, 0);
		w.lineTo(150, 100);
		w.setLineWidth(6);
		w.setLineColor(Color.GREEN);
		w.writeText("Hello, Window!");
		Square sq = new Square(200,100,100);
		sq.draw(w);
		while (true) {
			w.waitForMouseClick();
			int x = w.getMouseX();
			int y = w.getMouseY();
			w.lineTo(x, y);
		}
	}
}
