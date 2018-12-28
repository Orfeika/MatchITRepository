package lab3;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import textproc.GeneralWordCounter;
import textproc.TextProcessor;
import textproc.WordCountKeyComparator;
import textproc.WordCountValueComparator;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class BookReaderController extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 500, 500);
		primaryStage.setTitle("BookReader");
		primaryStage.setScene(scene);
		primaryStage.show();

		///////////////////////////////////////////////
		Scanner scan = new Scanner(new File("undantagsord.txt"));
		Set<String> stopwords = new HashSet<>();
		while (scan.hasNext()) {
			String exaceptionWord = scan.next().toLowerCase();
			stopwords.add(exaceptionWord);
		}
		GeneralWordCounter counter = new GeneralWordCounter(stopwords);
		ArrayList<GeneralWordCounter> gWords = new ArrayList<>();
		gWords.add(counter);
		Scanner s = new Scanner(new File("nilsholg.txt"));
		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning

		while (s.hasNext()) {
			String word = s.next().toLowerCase();
			for (TextProcessor tp : gWords) {
				tp.process(word);
			}
		}

		s.close();
		scan.close();

		///////////////////////////////////////////////////////////////////////
		ObservableList<Map.Entry<String, Integer>> words = FXCollections.observableArrayList(counter.getWords());
		ListView<Map.Entry<String, Integer>> listView = new ListView<>(words);
		root.setCenter(listView);

		// Creating hbBox and buttons

		HBox hbox = new HBox(1);
		Button alphabetic = new Button("Alphabetic");
		alphabetic.setOnAction((e) -> words.sort(new WordCountKeyComparator()));
		Button frequency = new Button("Frequency");
		frequency.setOnAction((e) -> words.sort(new WordCountValueComparator()));
		TextField searchField = new TextField("Search");
		Button find = new Button("Find");
		find.setOnAction((action) -> {
			String input = searchField.getText();
			for (Entry<String, Integer> word : words) {
				if (word.getKey().equalsIgnoreCase(input)) {
					listView.scrollTo(word);
				}
			}
		}

		);
		
		// press enter
	    root.addEventHandler(KeyEvent.KEY_PRESSED, ev -> {
	        if (ev.getCode() == KeyCode.ENTER) {
	           find.fire();
	           ev.consume(); 
	        }
	    });
		hbox.getChildren().addAll(alphabetic, frequency, searchField, find);
		root.setBottom(hbox);

	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
