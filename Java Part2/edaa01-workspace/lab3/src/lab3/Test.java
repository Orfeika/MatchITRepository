package lab3;

public class Test {
	private int order;
	private double length;
	private double alpha;

	

	public Test() {

	}

	public  void fractalLine(int order, double length, double alpha) {
		this.order = order;
		this.length = length;
		this.alpha = alpha;
			if (order == 0) {
			//"draw a line with length lenght and
			//angle alpha"
			} else {
			System.out.println(+ order+ " " + length + " "+ alpha);
			fractalLine(order-1, length/3, alpha);

			fractalLine(order-1, length/3, alpha-60);

			fractalLine(order-1, length/3,alpha+60);
			fractalLine(order-1, length/3, alpha);

			}
			}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 Test t  = new Test();
 t.fractalLine(4,810,0);
		
	}

}
