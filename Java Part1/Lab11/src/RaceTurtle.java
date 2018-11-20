import java.util.Random;

import se.lth.cs.pt.window.SimpleWindow;

public class RaceTurtle extends Turtle {
	private int nbr;
	private RaceWindow w; 
	
	/**
	* Skapar en sköldpadda som ska springa i fönstret w och som har start-
	* nummer nbr. Sköldpaddan startar med pennan nere och vänd åt höger.
	*/
	
	public RaceTurtle(RaceWindow w, int nbr) {
		super(w, w.getStartXPos(nbr), w.getStartYPos(nbr));
		this.nbr = nbr;
		this.w = w;
		this.left(-90);
		this.penDown();
	}

	/**
	* Låter sköldpaddan gå framåt ett steg. Stegets längd ges av ett
	* slumptal (heltal) mellan 1 och 6.
	*/
	public void raceStep() {
		Random rn= new Random();
		int step = 1+ rn.nextInt(6);
		this.forward(step);
	}
	
	@Override
	public String toString() {
		return "Number " + nbr;
	}
	
}
