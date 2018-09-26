import se.lth.cs.pt.window.SimpleWindow;

public class myTEst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleWindow w = new SimpleWindow(650, 300, "TurtleTest");
		w.moveTo(430, 30);
		w.writeText("Nedan ska finnas en cirkel");

		Turtle t = new Turtle(w, 570, 120);
		t.penDown();
		for (int i = 0; i < 360; i++) {
			t.forward(1);
			t.left(1);
			System.out.println(t.getX()+ " "  + t.getY());
			
		}
		int x = t.getX();
		int y = t.getY();
		System.out.println(x == 570 && y == 120);

	}

}
