import java.util.Scanner;

public class Calculator {
	public static void main(String[] args) {

		System.out.println("Type in two numbers");
		Scanner scan = new Scanner(System.in);
		double nbr1 = scan.nextDouble();
		double nbr2 = scan.nextDouble();
		double sum = nbr1 + nbr2;
		double res = nbr1 - nbr2;
		double mult = nbr1*nbr2;
		double div = nbr1 /nbr2;
		System.out.println("Sum of two numbers is equal " + sum);
		System.out.println("Residual of two numbers "
				+ "is equal " + res);
		System.out.println("Multiplication of "
				+ "two numbers is equal " + mult);
		System.out.println("Division of two numbers"
				+ " is equal " + div);
	}
}
