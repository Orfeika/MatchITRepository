package mountain;

public class Side {
	private Point starPoint;
	private Point endPoint;

	public Side(Point starPoint, Point endPoint) {
		super();
		this.starPoint = starPoint;
		this.endPoint = endPoint;
	}

	public Point getMidPoint() {

		int x = (starPoint.getX() + endPoint.getX()) / 2;
		int y = (starPoint.getY() + endPoint.getY()) / 2;
		System.out.println("X:" + x + "Y:" + y);
		return new Point(x, y);

	}
	

	public Point getStarPoint() {
		return starPoint;
	}

	public Point getEndPoint() {
		return endPoint;
	}

	@Override
	public int hashCode() {
		return starPoint.hashCode() + endPoint.hashCode();
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Side)) {
			return false;
		}

		Side otherSide = (Side) obj;
		return otherSide.endPoint.equals(this.endPoint) && 
				otherSide.starPoint.equals(this.starPoint);

	}

}
