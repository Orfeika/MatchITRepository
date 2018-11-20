package testjanuary2016;

public class Survey {
	private Table data; 
	/** Skapar en ny enkät utifrån tabellen data. */
	public Survey(Table data) {
		this.data = data; 
	}
	/** Registrerar förekomst av värdena values i kolumnen col.
	* Returnerar en heltalsvektor där sista elementet innehåller antalet
	* övriga värden som inte förekommer i values. */
	int[] register(int col, String[] values) {
	int n = values.length;
	int answer [] = new int [n +1];
	for (int row = 0 ; row<data.getNumberOfRows(); row++) {
		boolean registred = false; 
		for(int v  = 0 ; v<n; v++ ) {
			if(data.get(row, col).equals(values[n])) {
				answer[v]++;
				registred = true;
			}

		}
		if(!registred) {
		answer[n]++;
		}
	}
		return answer ;
	}
	/** Skriver ut statistik över förekomsten av värdena i values i kolumnen col.
	* För varje värde i values och för övriga värden skrivs en rad med värdet,
	* frekvensen och procentandelen. Se utskriftsexempel på sid. 3. */
	void printRegistration(int col, String[] values) {
		int [] reg = register(col, values);
		int total = 0; 
		for(int  sum : reg) {
			total +=sum;
		}
		
		
	}

}
