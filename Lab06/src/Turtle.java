import se.lth.cs.pt.window.SimpleWindow;

public class Turtle {
	private int beta;
	private int x;
	private int y;
	private SimpleWindow w;
	private boolean penStatus ;

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
		double radianBeta = beta * Math.PI / 180;
		int newX =(int)Math.round( 10*(x + n * Math.cos(radianBeta)));
		System.out.println("x0: " + x + " \nx1:" + newX );
		int newY = (int)Math.round( 10*(y - n * Math.sin(radianBeta)));
		System.out.println("y0: " + y + " \ny1:" + newY);
		if (penStatus == true) {
			w.moveTo(x, y);
			w.moveTo(newX,newY);
		} else {
			w.moveTo(x, y);
			w.lineTo(newX,newY);
		}
		x = newX;
		y = newY;

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

	/** Tar reda på x-koordinaten för sköldpaddans aktuella position. */
	public int getX() {
		return this.x;
	}

	/** Tar reda på y-koordinaten för sköldpaddans aktuella position. */
	public int getY() {
		return this.y;
	}

	/** Tar reda på sköldpaddans riktning, i grader från den positiva X-axeln. */
	public int getDirection() {
		return beta;
	}
}