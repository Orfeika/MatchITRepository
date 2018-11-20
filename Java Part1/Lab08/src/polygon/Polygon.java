package polygon;

import java.util.ArrayList;
import java.util.List;

import se.lth.cs.pt.window.SimpleWindow;

public class Polygon {
	private Point[] polygonCoordinates;
	private int vertexCounter = 0;

	public Polygon(Point[] polygonCoordinates) {
		this.polygonCoordinates = polygonCoordinates;
	}

	public Polygon(int vertexNumber) {
		polygonCoordinates = new Point[vertexNumber];
	}

	public Polygon() {
		this(10);
	}
	
	public void addVertex(int x, int y) {
		Point vertexPoint = new Point(x, y);
		polygonCoordinates[vertexCounter] = vertexPoint;
		vertexCounter++;
	}

	public void draw(SimpleWindow w) {
		w.moveTo(polygonCoordinates[0].getX(), polygonCoordinates[0].getY());
		for (int i = 1; i < vertexCounter; i++) {
			w.lineTo(polygonCoordinates[i].getX(), polygonCoordinates[i].getY());
		}
		w.lineTo(polygonCoordinates[0].getX(), polygonCoordinates[0].getY());

	}

}
