package textproc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.List;

public class Holgersson {

	public static final String[] REGIONS = { "blekinge", "bohuslän", "dalarna", "dalsland", "gotland", "gästrikland",
			"halland", "hälsingland", "härjedalen", "jämtland", "lappland", "medelpad", "närke", "skåne", "småland",
			"södermanland", "uppland", "värmland", "västerbotten", "västergötland", "västmanland", "ångermanland",
			"öland", "östergötland" };

	public static void main(String[] args) throws FileNotFoundException {
		long t0 = System.nanoTime();
		TextProcessor p = new SingleWordCounter("nils");
		
		
		TextProcessor p2 = new SingleWordCounter("norge");
		List<TextProcessor> pList = new ArrayList();
		pList.add(p);
		pList.add(p2);
		TextProcessor rMap = new MultiWordCounter(REGIONS);
		
		
		Scanner scan = new Scanner(new File("undantagsord.txt"));
		Set<String> stopwords = new HashSet<>();
		while(scan.hasNext()) {
			String exaceptionWord =scan.next().toLowerCase();
			stopwords.add(exaceptionWord);
		}
		scan.close();
		GeneralWordCounter gwc = new GeneralWordCounter(stopwords);
		
		Scanner s = new Scanner(new File("nilsholg.txt"));
		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning

		while (s.hasNext()) {
			String word = s.next().toLowerCase();
			for (TextProcessor tp : pList) {
				tp.process(word);
			}
			rMap.process(word);
			gwc.process(word);
		}

		s.close();

		for (TextProcessor tp : pList) {
			tp.report();
		}
		
		rMap.report();
		gwc.report();
		long t1 = System.nanoTime();
		System.out.println("Time: "+ (t1-t0)/1000000 + " ms");
	}


}