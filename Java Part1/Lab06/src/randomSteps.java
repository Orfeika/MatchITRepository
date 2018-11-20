import java.util.Random;

import se.lth.cs.pt.window.SimpleWindow;

public class randomSteps {
	
	public static boolean  isTurtlesTooClose(Turtle t1, Turtle t2) {
		
		double lenght = Math.sqrt(Math.pow(2, (Math.abs(t2.getX() - t1.getX())
				+Math.abs(t2.getY() - t1.getY()) )));
		if (lenght <50) {
			return true;
		}
		return false;
	}
	
	public static void randomWalk(Turtle t) {
		Random rn = new Random();
		int rnAngle = -180 + rn.nextInt(361);
		int rnStep = 1+ rn.nextInt(10);
		t.forward(rnStep);
		t.left(rnAngle);
	}

	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(1000, 1000, "TurtleTest");
		
		Turtle t1 = new Turtle(w, 100, 50);
		Turtle t2 = new Turtle(w, 200, 100);

		t1.penDown();
		t2.penDown();

		t1.jumpTo(w.getWidth()/2, w.getHeight()/2);
		t2.jumpTo(w.getWidth()/5,  w.getHeight()/5);

		for (int i = 0; i<1001; i++) {
			if(isTurtlesTooClose(t1,t2) == false) {
				randomWalk(t1);
				randomWalk(t2);
			}
			
			

		}

	}
}
