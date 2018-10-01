package squareroot;

import java.util.Scanner;

public class SquareRoot {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			double d = scanner.nextDouble();
			System.out.println(Math.sqrt(d));
		}
	}
}
