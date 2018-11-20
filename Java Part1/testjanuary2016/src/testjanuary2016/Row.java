package testjanuary2016;

public class Row {

	private String [] wordsList; 
	/** Skapar en rad med strängar från s. Radens strängar skapas genom att s
	* delas upp baserat på separatorn delimiter. Separatorn lagras ej. */
	Row(String s, String delimiter) {
		this.s = s; 
		this.delimeter = delimiter;
		wordsList = s.split(delimiter);
	}
	/** Returnerar strängen på plats col, räknat från 0 till size()-1.
	* Om col indexerar utanför gränserna returneras en tom sträng. */
	String get(int col) {
		if(col>0  && col<wordsList.length) {
			return wordsList[col];	
		} else {
			return "";
		}
		
	}
	/** Returnerar antalet strängar som denna rad innehåller. */
	int size() {
		return wordsList.length;
	}

}
