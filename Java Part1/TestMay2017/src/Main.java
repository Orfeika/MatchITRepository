import java.util.Scanner;

public class Main {
	
	private static Polynomial readPolynomial(Scanner sc) {
		Polynomial p = new Polynomial();
		System.out.println("emter max exp: \t");
		int maxExp = sc.nextInt();
		for(int i = maxExp; i>= 0 ; i--) {
			int coeff = sc.nextInt();
			if(coeff!=0) {
				p.add(new Term(coeff, i) );
			}
		}
		return p;
		
	}

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Polynomial p1 = readPolynomial(scan);
		Polynomial p2 = readPolynomial(scan);
		Polynomial q = p1.times(p2);
		System.out.println(q.toString());

		
	}
}
