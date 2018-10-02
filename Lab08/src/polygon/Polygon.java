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
		for (int i = 0; i < polygonCoordinates.length; i++) {
			polygonCoordinates[i] = new Point(0, 0);

		}
	}

	public Polygon() {
		this(14);
	}
	
	

	public Point[] getPolygonCoordinates() {
		return polygonCoordinates;
	}

	public void setPolygonCoordinates(Point[] polygonCoordinates) {
		this.polygonCoordinates = polygonCoordinates;
	}
	

	public int getVertexCounter() {
		return vertexCounter;
	}

	public void setVertexCounter(int vertexCounter) {
		this.vertexCounter = vertexCounter;
	}

	public void addVertex(int x, int y) {
		Point vertexPoint = new Point(x, y);
		polygonCoordinates[vertexCounter] = vertexPoint;
		vertexCounter++;
	}

	public void draw(SimpleWindow w) {
		w.moveTo(polygonCoordinates[0].getX(), polygonCoordinates[0].getY());
		for (int i = 1; i < polygonCoordinates.length; i++) {
			w.lineTo(polygonCoordinates[i].getX(), polygonCoordinates[i].getY());
		}
		w.lineTo(polygonCoordinates[0].getX(), polygonCoordinates[0].getY());

	}

}
