package testjanuary2016;

import java.util.ArrayList;
import java.util.List;

public class Table {
	private ArrayList<Row> rowList; 
	private int maxWidht = 0 ; 

	Table() { rowList = new ArrayList<>();	}
	
	
	/** Skapar en tabell med data utifrån rader i lines. Värdena på varje rad
	* avgränsas med separatorn delimiter */
	Table(ArrayList<String> lines, String delimiter) {
	 rowList = new ArrayList<>();
	 for(int i = 0; i<lines.size(); i++){
		 Row r = new Row(lines.get(i), delimiter);
		 rowList.add(r);
		 if(r.size() > maxWidht) {
			 maxWidht = r.size();
		 }
		 
	 }
	}
	/** Returnerar maxbredden (det maximala antalet kolumner bland alla rader). */
	public int getMaxWidth() {
		return maxWidht;
	}
	/** Returnerar antalet rader i tabellen. */
	public int getNumberOfRows() {
		return rowList.size();
	}
	/** Returnerar strängen på rad row och kolumn col räknat från 0.
	* Om row eller col indexerar utanför gränserna returneras en tom sträng. */
	public String get(int row, int col) {
		
		return rowList.get(row).get(col);
	}
	/** Lägger till raden r sist i tabellen. */
	public void append(Row r) {
		rowList.add(r);
	}
	/** Sätter in raden r på plats pos i tabellen (efterföljande rader flyttas). */
	public void insert(int pos, Row r) {
		rowList.add(pos, r);
	}
	/** Returnerar en ny tabell som enbart innehåller de rader som har värdet value
	* i kolumnen col. */
	public Table filter(int col, String value) {
		Table result = new Table(); 
		for(Row r : rowList) {
			if (r.get(col).equals(value)){
				result.append(r);
			}
		}
		return result;
	}

}
