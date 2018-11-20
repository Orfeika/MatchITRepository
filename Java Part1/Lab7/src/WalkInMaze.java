import se.lth.cs.pt.maze.Maze;
import se.lth.cs.pt.window.SimpleWindow;

public class WalkInMaze {

	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(400, 400, "");
		Turtle turtle = new Turtle(w, 0, 0);
		turtle.penDown();
		Maze maze = new Maze(3);
		Maze maze2 = new Maze("img/maze7.png", 88, 280);
		
		maze.draw(w);
		MazeWalker mazeWalker = new MazeWalker(turtle);
		mazeWalker.walk(maze);
		System.out.println(System.getProperty("user.dir"));

	}

}