
import se.lth.cs.pt.window.SimpleWindow;

public class RaceWindow extends SimpleWindow {
	public static final int X_START_POS = 100;
	public static final int X_END_POS = 700;
	public static final int Y_LINE_START = 100;
	public static final int Y_LINE_END = 280;
	
	public RaceWindow() {
		super(800, 400, "Race Window");
		setUp();
	}
	
	private void setUp(){
		moveTo(X_START_POS-10, Y_LINE_START+24);
		writeText("1");
		moveTo(X_START_POS-10, Y_LINE_START+44);
		writeText("2");
		moveTo(X_START_POS-10, Y_LINE_START+64);
		writeText("3");
		moveTo(X_START_POS-10, Y_LINE_START+84);
		writeText("4");
		moveTo(X_START_POS-10, Y_LINE_START+105);
		writeText("5");
		moveTo(X_START_POS-10, Y_LINE_START+124);
		writeText("6");
		moveTo(X_START_POS-10, Y_LINE_START+144);
		writeText("7");
		moveTo(X_START_POS-10, Y_LINE_START+164);
		writeText("8");
			
		super.moveTo(X_START_POS, Y_LINE_START);
		super.lineTo(X_START_POS, Y_LINE_END);
		
		super.moveTo(X_END_POS, Y_LINE_START);
		super.lineTo(X_END_POS, Y_LINE_END);
	}
	
	public static int getStartXPos(int startNbr){
		return X_START_POS;
	}

	public static int getStartYPos(int startNbr){
		return Y_LINE_START + startNbr*20;
	}
}

