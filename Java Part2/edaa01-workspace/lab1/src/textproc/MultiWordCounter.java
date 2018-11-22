package textproc;

import java.util.Map;
import java.util.TreeMap;

public class MultiWordCounter implements TextProcessor {
	private Map<String, Integer> wordsMap;

	public MultiWordCounter(String[] wordsList) {
		wordsMap = new TreeMap<>();
		for (String word : wordsList) {
			wordsMap.put(word, 0);
		}

	}

	@Override
	public void process(String w) {
		if (wordsMap.containsKey(w)) {
			int n = wordsMap.get(w);
			n++;
			wordsMap.put(w, n);

		}
	}

	@Override
	public void report() {
		for (String tp : wordsMap.keySet()) {
			String key = tp.toString();
			String value = wordsMap.get(tp).toString();
			System.out.println(key + ": " + value);
		}

	}

}
