package mountain;

import fractal.Fractal;
import fractal.TurtleGraphics;

public class Mountain extends Fractal {
	private Point a;
	private Point b; 
	private Point c; 
	
	





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
		mountainTriangle(turtle,order, b, c, a);
	}
	
	
	private void mountainTriangle(TurtleGraphics turtle,int order, Point a, Point b, Point c ) {
		if(order == 0) {
			turtle.moveTo(b.getX(),b.getY());
			turtle.forwardTo(c.getX(), c.getY());
			turtle.forwardTo(a.getX(), a.getY());
			turtle.forwardTo(b.getX(), b.getY());	
		}else {
			Point mAB = middlePoint(a,b);
			Point mBC = middlePoint(b,c);
			Point mCA = middlePoint(c, a);
			mountainTriangle(turtle, order-1, mAB, b, mBC);
			mountainTriangle(turtle, order-1, mAB, a, mCA);
			mountainTriangle(turtle, order-1, mCA, mBC, mAB);
			mountainTriangle(turtle, order-1, mCA, c, mBC);
		
		}
	}
	
	
	private Point middlePoint(Point a, Point b) {
		
		int x = (a.getX() +b.getX())/2;
		int y = (a.getY()+b.getY())/2;
		System.out.println("X:" + x + "Y:" +y);
		return new Point(x,y);
		
	}
	
	
}