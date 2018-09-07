
public class ComputeFirstSpringDate {

	public static void main(String[] args) {
		double [] februaryTemp = {0.8, 0.3, 0.9, 2.4, 2.0, 0.8, -2.1, -2.6, -3.5, -0.6, 
				                  -0.4, -0.9, -2.9, -2.4, -0.6, 2.0, 3.6, 2.9, 4.5, 5.7,
				                  6.2, 5.7, 3.3, 0.4, -0.7, 5.3, 7.4, 5.5, 
				                  4.3, 3.1, 4.3, 3.8, 3.8, 1.2};
		System.out.println(firstSpringDate(februaryTemp));
	}

	/** Returnerar datumet för när våren startar.
	    Om inte våren startar under månaden returneras -1.
	    Vektorn a innehåller dygnsmedeltemperaturerna under månaden 
	    samt under de 6 första dygnen i nästkommande månad. */
	public static int firstSpringDate(double[] a) {
		int nbrDays = 0;
		for (int i = 14; i < a.length; i++) {
			if (a[i] > 0) {
				nbrDays++;
				if (nbrDays == 7) {
					return i - 6 + 1;
				} 
			} else {
				nbrDays = 0;
			}
		}
		return -1;
	}

}
