package polygon;

public class Point {
	private int x, y;

	/** Constructs and initializes a point at the specified (x,y) location. */
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Returns the x coordinate.
	 * @return the x coordinate
	 */
	public int getX() {
		return x;
	}

	/**
	 * Returns the y coordinate.
	 * @return the y coordinate
	 */
	public int getY() {
		return y;
	}

	/**
	 * Moves the point with dx along the x axis and dy along the y axis.
	 * @param dx
	 *            the distance to move this point along the X axis
	 * @param dy
	 *            the distance to move this point along the Y axis
	 */
	public void move(int dx, int dy) {
		x += dx;
		y += dy;
	}
	
	/** 
	 * Returns a string representation of the point. 
	 * @return a string representation of the point.
	 */
	public String toString() {
		return x + " " + y;
	}
}