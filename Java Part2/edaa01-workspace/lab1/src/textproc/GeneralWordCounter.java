package textproc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class GeneralWordCounter implements TextProcessor {
	private Set<String> stopwords;
	private Map<String, Integer> wordCounter;


	

	public Set<Map.Entry<String, Integer>> getWords() {
		return wordCounter.entrySet();
	}

	public GeneralWordCounter(Set<String> stopwords) {
		this.stopwords = stopwords;
		wordCounter = new TreeMap<>();
	}

	@Override
	public void process(String w) {
		int value = 0;
		if (!stopwords.contains(w)) {
			value = wordCounter.get(w) == null ? 1 : wordCounter.get(w) + 1;
			wordCounter.put(w, value);

		}
	}

	@Override
	public void report() {
		Set<Map.Entry<String, Integer>> wordSet = wordCounter.entrySet();
		List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordSet);
		wordList.sort(Collections.reverseOrder(new WordCountValueComparator()));

		List<Map.Entry<String, Integer>> sortedList = new ArrayList<>();
		for (int i = 0; i < 15; i++) {
			sortedList.add(wordList.get(i));
		}

		for (Map.Entry<String, Integer> word : sortedList) {
			System.out.println(word.getKey() + ": " + word.getValue());
		}
	}

}
