import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class ThrowTheDice {

	static int calcNbrOfPositiveThrows(int nbrOfThrows[], int positiveNbr) {
		int counter = 0;
		for (int i = 0; i < nbrOfThrows.length; i++) {

			if (nbrOfThrows[i] == positiveNbr) {
				counter++;
			}
		}
		return counter;
	}

	static int[] throwTheDice(int nbrOfThrows) {
		Random rm = new Random();
		int[] list = new int[nbrOfThrows];
		for (int i = 0; i < nbrOfThrows; i++) {
			list[i] = 1 + rm.nextInt(6);
		}

		System.out.println("\nNumber of throws:" + nbrOfThrows);
		return list;
	}
	
	public static void prntResultofThrows(int [ ] list){
		int resultList[] = new int[6];
		int counter;
		for(int i =1; i<=6; i++) {
			counter = 0; 
			for(int j = 0; j<list.length; j++) {
				if (i == list[j]) {
					counter++;
				}
			}
			resultList[i] = counter;
			System.out.println("We got " + i + "s:" +counter );
			
		}
	}
	
	
	public static void prntResultofThrowsH(int [ ] list) {
		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		hmap.put(1, calcNbrOfPositiveThrows(list, 1));
		hmap.put(2, calcNbrOfPositiveThrows(list, 2));
		hmap.put(3, calcNbrOfPositiveThrows(list, 3));
		hmap.put(4, calcNbrOfPositiveThrows(list, 4));
		hmap.put(5, calcNbrOfPositiveThrows(list, 5));
		hmap.put(6, calcNbrOfPositiveThrows(list, 6));

		Set set = hmap.entrySet();
		Iterator iterator = set.iterator();
		while (iterator.hasNext()) {
			Map.Entry mentry = (Map.Entry) iterator.next();
			System.out.print( "We got " + mentry.getKey() +"s:");
			System.out.println(mentry.getValue());
		}
	}

	public static void main(String[] args) {
		
		int[] list = throwTheDice(200);
		
		prntResultofThrows(list);
		prntResultofThrowsH(list);



	}

}
