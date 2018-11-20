package general;
import java.util.Arrays;
import java.util.Random;

public class test {

	public static void loop(int n) {
		int i = n;
		int counter=0;
		while (i > 1) {

			System.out.printf("%4d",n);
			System.out.printf("%4d",i);
			
			System.out.printf("%4d", counter);

			counter++;

			if (i % 2 == 0) {
				i = i / 2;
			} else {
				i = i + 1;
			}

			
		}
	}

	public static void main(String[] args) {
			loop(800);

	}
}
