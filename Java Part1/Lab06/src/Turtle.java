import java.awt.Color;

import se.lth.cs.pt.window.SimpleWindow;

public class Turtle {
	private int beta;
	private double x;
	private double y;
	private SimpleWindow w;
	private boolean penStatus;
	/**
	 * Skapar en sköldpadda som ritar i ritfönstret w. Från början befinner sig
	 * sköldpaddan i punkten x, y med pennan lyft och huvudet pekande rakt uppåt i
	 * fönstret (i negativ y-riktning).
	 */
	public Turtle(SimpleWindow w, int x, int y) {
		this.beta = 90;
		this.x = x;
		this.y = y;
		this.w = w;
		this.penStatus = true;
		w.moveTo(x, y);

	}

	/** Sänker pennan. */
	public void penDown() {
		this.penStatus = false;
	}

	/** Lyfter pennan. */
	public void penUp() {
		this.penStatus = true;

	}

	/** Går rakt framåt n pixlar i den riktning huvudet pekar. */
	public void forward(int n) {
		w.moveTo((int)x, (int)y);
		x = x + n * Math.cos(Math.toRadians(beta));
		y = y - n * Math.sin(Math.toRadians(beta));
		///System.out.println("xold: " + x + " yold " + y + " x " + x + " y " + y + " beta " + beta);
		if (penStatus == true) {
			w.moveTo((int)x, (int)y);
		} else {
			w.lineTo((int)x, (int)y);
		}

	}

	/** Vrider beta grader åt vänster runt pennan. */
	public void left(int beta) {

		this.beta += beta;

	}

	/**
	 * Går till punkten newX, newY utan att rita. Pennans läge (sänkt eller lyft)
	 * och huvudets riktning påverkas inte.
	 */
	public void jumpTo(int newX, int newY) {
		w.moveTo(newX, newY);
		this.x = newX;
		this.y = newY;
	}

	/** Återställer huvudriktningen till den ursprungliga. */
	public void turnNorth() {
		this.beta = 90;
	}
	
	public void setColor(Color color) {
		w.setLineColor(color);
	}



	/** Tar reda på x-koordinaten för sköldpaddans aktuella position. */
	public int getX() {
		return (int) this.x;
	}

	/** Tar reda på y-koordinaten för sköldpaddans aktuella position. */
	public int getY() {
		return (int) this.y;
	}

	/** Tar reda på sköldpaddans riktning, i grader från den positiva X-axeln. */
	public int getDirection() {
		return beta;
	}
	
	
}