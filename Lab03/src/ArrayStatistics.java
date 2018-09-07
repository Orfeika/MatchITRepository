
public class ArrayStatistics {
	
	/** Returnerar index för det första negativa värdet i vektorn a
	    om inget negativt värde finns returneras -1. */
	public static int indexfirstNegative(double[] a) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] < 0) {
				return i;
			} 
		}
		return -1;
	}
	
	/** Returnerar det minsta värdet i vektorn a. */
	public static double min(double[] a) {
		double minVal = Double.MAX_VALUE;
		for (int i = 0; i < a.length; i++) { 
			if (a[i] < minVal) {
				minVal = a[i];
			}
		}
		return minVal;
	}
	
	/** Returnerar det största värdet i vektorn a. */
	public static double max(double[] a) {
		double maxVal = -Double.MAX_VALUE;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > maxVal) {
				maxVal = a[i];
			}
		}
		return maxVal;
	}
	
	/** Beräknar medelvärdet av talen i vektorn a. */
	public static double avg(double[] a) {
		double sum = 0;
		for (int i = 1; i < a.length; i++) {
			sum += a[i];
		}
		return sum / a.length;
	}

}
