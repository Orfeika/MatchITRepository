import se.lth.cs.pt.maze.Maze;
import se.lth.cs.pt.window.SimpleWindow;

public class MazeWalker {
	private Turtle turtle;

	public MazeWalker(Turtle turtle) {
		this.turtle = turtle;
	}

	public void walk(Maze maze) {
		turtle.jumpTo(maze.getXEntry(), maze.getYEntry());
		int steps = 0;
		int directionChanged = 0;
		int stepLenght = 1;
		while (!maze.atExit(turtle.getX(), turtle.getY())) {
			boolean isWallinFront = maze.wallInFront(turtle.getDirection(), turtle.getX(), turtle.getY());
			boolean isWallatLeft = maze.wallAtLeft(turtle.getDirection(), turtle.getX(), turtle.getY());

			if (isWallinFront == false && isWallatLeft == true) {
				turtle.forward(stepLenght);
			} else if (isWallinFront == true && isWallatLeft == false) {
				turtle.left(90);
				turtle.forward(stepLenght);
				directionChanged++;

			} else if (isWallinFront == true && isWallatLeft == true) {
				turtle.left(-90);
				turtle.forward(stepLenght);
				directionChanged++;

			} else {
				turtle.left(90);
				turtle.forward(stepLenght);
				directionChanged++;

			}
			steps++;

		}
		System.out
				.println(steps + " steps were performed" + " and direction was changed " + directionChanged + " times");

	}

}