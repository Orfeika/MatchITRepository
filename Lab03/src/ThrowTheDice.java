import java.util.Random;

public class ThrowTheDice {
	
	static void throwTheDice(int nbrOfThrows) {
		Random rm = new Random();
		int[] listOfThrows = new int[6];
		for (int i = 0; i < nbrOfThrows; i++) {
			int randomNbr = rm.nextInt(6);
			listOfThrows[randomNbr]++;
		}
		for (int i = 0; i<listOfThrows.length; i++) {
			System.out.println("We got " + (i+1) + "s:" +(listOfThrows[i] +1));

		}
	}
	

	public static void main(String[] args) {
		throwTheDice(300);
		




	}

}
