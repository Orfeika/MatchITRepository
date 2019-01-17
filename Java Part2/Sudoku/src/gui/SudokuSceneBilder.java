package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sudoku.Sudoku;

public class SudokuSceneBilder extends Application {
	private static final int BOARD_SIZE = 9;
	Scene scene;
	final int SIZE = 40;

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
				int row = (i / 3) * 3 + j / 3;

				if (row % 2 == 0) {
					textFields[i][j].setStyle("-fx-background-color: #ffaf42;");
				}
				tiles.getChildren().add(textFields[i][j]);
			}
		}

		Button solveButton = new Button("Solve");
		solveButton.setOnAction((event) -> {
			int[][] sudokuData = new int[9][9];

			for (int i = 0; i < textFields.length; i++) {
				for (int j = 0; j < textFields[i].length; j++) {
					int value = textFields[i][j].getText().equals("") ? 0
							: Integer.parseInt(textFields[i][j].getText());

					sudokuData[(i / 3) * 3 + j / 3][j % 3 + (i % 3) * 3] = value;
				}
			}

			Sudoku sudoku = new Sudoku();
			sudoku.setData(sudokuData);
			if (sudoku.resolve()) {
				for (int i = 0; i < textFields.length; i++) {
					for (int j = 0; j < textFields[i].length; j++) {
						textFields[(i / 3) * 3 + j / 3][j % 3 + (i % 3) * 3]
								.setText(Integer.toString(sudokuData[i][j]));
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
			for (int i = 0; i < BOARD_SIZE * BOARD_SIZE; i++) {
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
