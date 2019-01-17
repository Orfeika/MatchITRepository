package sudoku;

/**
 * @author Orfeika
 *
 */

public class Sudoku {
	private int[][] data;
	private boolean[][] schema;

	public Sudoku() {
		data = new int[9][9];
		schema = new boolean[9][9];
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data.length; j++) {
				data[i][j] = 0;
				schema[i][j] = false;
			}
		}
	}

	/**
	 * @param boxID   index of the box
	 * @param postion index from 0 to 8 to insert in the box
	 * @param number  - from 1 to 9
	 */
	public void addNumber(int boxID, int postion, int number) {
		data[boxID][postion] = number;
		schema[boxID][postion] = number != 0;

	}

	/**
	 * @param number   value from 1 to 9 to check
	 * @param boxIndex index of the box
	 * @return true if number exist in the box
	 */
	public boolean isNumberExistInBox(int number, int boxIndex) {
		for (int i = 0; i < data[boxIndex].length; i++) {
			if (number == data[boxIndex][i]) {
				return true;
			}
		}

		return false;
	}

	/**
	 * @param number value from 1 to 9 to check
	 * @param boxId  index of the box
	 * @param row index of row where to check
	 * @return true if number exist in row
	 */
	public boolean isNumberExistInRow(int number, int boxId, int row) {
		int posRow = row / 3;
		int boxRow = boxId / 3;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (data[boxRow * 3 + i][j + posRow * 3] == number) {
					return true;
				}
			}

		}
		return false;
	}

	/**
	 * @param number value from 1 to 9 to check
	 * @param boxID index of the box
	 * @param column index of column where to check
	 * @return true if number exist in column
	 */
	public boolean isNumberExistInColumn(int number, int boxID, int column) {
		int posColumn = column % 3;
		int boxColumn = boxID % 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (data[i * 3 + boxColumn][j * 3 + posColumn] == number) {
					return true;
				}
			}

		}
		return false;
	}

	public boolean isSafe(int boxId, int position, int number) {

		return !isNumberExistInBox(number, boxId)
				&& !isNumberExistInColumn(number, boxId, position)
				&& !isNumberExistInRow(number, boxId, position);

	}

	public boolean resolve() {
		return solve(new Position(0, 0));

	}

	private boolean solve(Position currentPosition) {

		if (schema[currentPosition.boxID][currentPosition.position]) {
			Position next = currentPosition.next();
			if (next.boxID == 9) {
				return true;
			}
			return solve(next);
		}
		for (int i = 1; i <= 9; i++) {
			if (!isSafe(currentPosition.boxID, currentPosition.position, i)) {
				continue;
			}
			data[currentPosition.boxID][currentPosition.position] = i;
			Position next = currentPosition.next();
			if (next.boxID == data.length) {
				return true;
			}
			if (solve(next)) {
				return true;
			}

			data[currentPosition.boxID][currentPosition.position] = 0;
		}

		return false;
	}

	public int[][] getData() {
		return data;
	}

	public void setData(int[][] data) {
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				schema[i][j] = data[i][j] != 0;
			}
		}
		this.data = data;
	}

	private class Position {
		int boxID;
		int position;

		public Position(int boxID, int position) {
			this.boxID = boxID;
			this.position = position;
		}

		public Position next() {
			if (this.position == 8) {
				return new Position(boxID + 1, 0);
			}
			return new Position(boxID, position + 1);
		}

	}

}
