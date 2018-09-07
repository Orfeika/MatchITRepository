public class MainTemp {

	public static void main(String[] args) {
		double [] temp = {0.8, 0.3, 0.9, 2.4, 2.0, 0.8, -2.1, -2.6, -3.5, -0.6, 
				-0.4, -0.9, -2.9, -2.4, -0.6, 2.0, 3.6, 2.9, 4.5, 5.7,
				6.2, 5.7, 3.3, 0.4, -0.7, 5.3, 7.4, 5.5};
		System.out.println("Antal dygn: " + temp.length);
		System.out.println("Dygnstemperatur månadens första dygn: " + temp[0]);
		System.out.println("Dygnstemperatur månadens sista dygn: " + temp[temp.length - 1]);
		System.out.println("Medelvärde: " +  ArrayStatistics.avg(temp));
		System.out.println("Lägsta dygnsemperatur: " + ArrayStatistics.min(temp));
		System.out.println("Högsta dygnsemperatur: " + ArrayStatistics.max(temp));
		System.out.println("Datum för första dygnstemperatur under 0 grader: " + 
				(ArrayStatistics.indexfirstNegative(temp) + 1));
	}
	
}
