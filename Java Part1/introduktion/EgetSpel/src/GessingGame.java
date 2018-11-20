import java.util.Scanner;
import java.util.Random;

public class GessingGame {

	public static void main(String[] args) {

		System.out.println("Welcome to the game: guess what is the number!");

		// generating a random number
		Random random = new Random();
		int gessedNumber = random.nextInt(100);

		int numberOfTries = 0;
		Scanner scan = new Scanner(System.in);
		int userGuess;
		boolean win = false;

		System.out.println("Kan you Geuss a number between 0 and 100");
		long startTime = System.nanoTime();
		while (win == false) {

			System.out.println("Please enter the number:");

//		measuring the time 

			userGuess = scan.nextInt();

			numberOfTries++;

			if (userGuess == gessedNumber) {
				win = true;
				long gessingTime = (System.nanoTime() - startTime) / 1000000000;

				System.out.println("You win and Your number is " + gessedNumber);

				System.out.println("It took you  " + numberOfTries + " tries " + " and " + gessingTime + " secondes "
						+ "to guess the number");
			}

			else if (userGuess < gessedNumber) {
				System.out.println("Your guess is too small");

			} else if (userGuess > gessedNumber) {

				System.out.println("Your guess is too big");

			}

		}

	}

}
