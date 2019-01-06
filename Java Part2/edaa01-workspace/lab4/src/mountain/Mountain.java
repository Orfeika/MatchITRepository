package mountain;

import java.util.HashMap;

import fractal.Fractal;
import fractal.TurtleGraphics;

public class Mountain extends Fractal {
	private Point a;
	private Point b;
	private Point c;
	private double dev;
	private HashMap<Side, Point> triangle;

	public Mountain(Point a, Point b, Point c, double dev) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
		this.dev = dev;
		triangle = new HashMap<Side, Point>();

	}

	public Mountain(Point a, Point b, Point c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public String getTitle() {
		return "Mountain triangel";
	}

	@Override
	public void draw(TurtleGraphics turtle) {


		// mountainTriangle(turtle,order, b, c, a);
		mointainShiftedTriangel(turtle, order, b, c, a);
	}

	private void mountainTriangle(TurtleGraphics turtle, int order, Point a, Point b, Point c) {
		if (order == 0) {
			turtle.moveTo(b.getX(), b.getY());
			turtle.forwardTo(c.getX(), c.getY());
			turtle.forwardTo(a.getX(), a.getY());
			turtle.forwardTo(b.getX(), b.getY());
		} else {
			Point mAB = middlePoint(a, b);
			Point mBC = middlePoint(b, c);
			Point mCA = middlePoint(c, a);
			mountainTriangle(turtle, order - 1, mAB, b, mBC);
			mountainTriangle(turtle, order - 1, mAB, a, mCA);
			mountainTriangle(turtle, order - 1, mCA, mBC, mAB);
			mountainTriangle(turtle, order - 1, mCA, c, mBC);

		}
	}

	private void mointainShiftedTriangel(TurtleGraphics turtle, int order, Point a, Point b, Point c) {
		if (order == 0) {
			turtle.moveTo(a.getX(),a.getY());
			turtle.forwardTo(b.getX(), b.getY());
			turtle.forwardTo(c.getX(), c.getY());
			turtle.forwardTo(a.getX(), a.getY());

		} else {
			Side ab = new Side(a,b);
			Side bc = new Side(b, c);
			Side ca = new Side(c, a);
			Point mAB = isMiddlePoinExist(ab);
			Point mBC = isMiddlePoinExist(bc);
			Point mCA = isMiddlePoinExist(ca);
			mointainShiftedTriangel(turtle, order - 1, b, mBC, mAB);
			mointainShiftedTriangel(turtle, order - 1, mAB, a, mCA);
			mointainShiftedTriangel(turtle, order - 1, mCA, c, mBC);
			mointainShiftedTriangel(turtle, order - 1, mCA, mAB, mBC);

		}

	}

	private Point middlePoint(Point a, Point b) {

		int x = (a.getX() + b.getX()) / 2;
		int y = (a.getY() + b.getY()) / 2;
		return new Point(x, y);

	}



	private Point isMiddlePoinExist(Side ab) {
		if(triangle.containsValue(ab.getStarPoint()) && triangle.containsValue(ab.getEndPoint())){
		triangle.put(ab, middlePoint(ab));
		}
		
		if (!triangle.containsKey(ab))
		{
			triangle.put(ab, shiftedMiddlePoint(ab));
		}
		


		return triangle.get(ab);
	}
	
	
	private Point shiftedMiddlePoint(Side side) {
		double y = side.getMidPoint().getY() + RandomUtilities.randFunc(dev);
		Point p = new Point(side.getMidPoint().getX(), (int) y);
		System.out.println("X:" + p.getX() + "Y:" + p.getY());

		return p;
	}
	
	
	private Point middlePoint(Side side) {
		Point p = new Point(side.getMidPoint().getX(), side.getMidPoint().getY() );

		return p;
	}

}
