import java.util.Random;

public class test {
	

public static int[] randomArray(int size) {
    Random random = new Random();
    int[] a = new int[size];
    for (int i = 0; i < a.length; i++) {
        a[i] = random.nextInt(100);
    }
    return a;
}

	public static int inRange(int[] a, int low, int high) {
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] >= low && a[i] < high) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] scores = randomArray(30);

		int[] counts = new int[100];
		for (int i = 0; i < counts.length; i++) {
			counts[i] = inRange(scores, i, i + 1);
			System.out.println("counts["+i +"]"+counts[i]);
		}
		
		for (int i = 0; i < scores.length; i++) {
		    int index = scores[i];
		    counts[index]++;
		    System.out.println("indexcounts["+index +"]" +counts[index]);
		}
	}

}
