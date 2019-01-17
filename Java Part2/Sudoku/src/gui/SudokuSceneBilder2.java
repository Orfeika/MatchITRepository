package gui;


import java.util.Arrays;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sudoku.Sudoku2;

public class SudokuSceneBilder2 extends Application{
	Scene scene;
	final int SIZE = 40;
	final int AMOUNT_OF_FIELDS = 81;
	final int FIELD_LENGTH = 9;

	public static void main(String[] args) {

		Application.launch(args);
	}
	
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Sudoku");
		VBox root = new VBox();
		root.setId("root");
		TilePane tiles = new TilePane();
		tiles.setId("tiles");
		
		TextField[][] textFields = new OneNumberTextField[9][9];
		for (int i = 0; i < textFields.length; i++) {
			for (int j = 0; j < textFields[i].length; j++) {
				textFields[i][j] = new OneNumberTextField();
				

				if (((i / 3) * 3 + j / 3) % 2 == 0) {
					textFields[i][j].setStyle("-fx-background-color: #ffaf42;");
				}
				tiles.getChildren().add(textFields[i][j]);
			}
		}
		
		Button solveButton = new Button("Solve");
		solveButton.setOnAction((event) -> {
			Sudoku2 sudoku = new Sudoku2();
			for (int i = 0; i < FIELD_LENGTH; i++) {
				for (int j = 0; j < FIELD_LENGTH; j++) {
					int value = textFields[j][i].getText().equals("") ? 0
							: Integer.parseInt(textFields[j][i].getText());
					sudoku.setField(j,i,value);
				}
			}
			
			if (sudoku.resolve()) {
				for (int i = 0; i < FIELD_LENGTH; i++) {
					for (int j = 0; j < FIELD_LENGTH; j++) {
						textFields[j][i].setText(Integer.toString(sudoku.getField(j, i)));
					}
				}
			} else {
				Alert errorAlert = new Alert(AlertType.ERROR);
				errorAlert.setHeaderText("Unable to resolve sudoku");
				errorAlert.setContentText("This game doesn't have a solution.");
				errorAlert.showAndWait();
			}

		});

		Button clearButton = new Button("Clear all");
		clearButton.setOnAction((event) -> {
			for (int i = 0; i < AMOUNT_OF_FIELDS; i++) {
				((TextField) tiles.getChildren().get(i)).setText("");
			}
		});
		FlowPane flow = new FlowPane();
		flow.setId("flow");
		flow.getChildren().addAll(solveButton, clearButton);
		root.getChildren().add(tiles);
		root.getChildren().addAll(flow);
		scene = new Scene(root, 400, 450);
		scene.getStylesheets().add("/style/style.css");
		Image applicationIcon = new Image("/style/icon.png");
		stage.getIcons().add(applicationIcon);

		stage.setScene(scene);

		stage.setResizable(false);
		stage.show();

		
		
		
	}
}
