package sudoku;

public class Sudoku2 {
	public static final int MAX_VALUE = 9;
	public static final int FIELD_SIZE = 9;
	public static final int BOX_SIZE = 3;

	private int[][] sudokuField;

	public Sudoku2() {
		sudokuField = new int[FIELD_SIZE][FIELD_SIZE];

	}


	private boolean isNumberExistInRow(int number, int x) {
		for (int i = 0; i < FIELD_SIZE; i++) {
			if (number == sudokuField[x][i]) {
				return true;
			}

		}
		return false;
	}

	private boolean isNumberExistinColumn(int number, int y) {
		for (int i = 0; i < FIELD_SIZE; i++) {
			if (number == sudokuField[i][y]) {
				return true;
			}
		}

		return false;
	}

	private boolean isNumberExistInBox(int number, int x, int y) {

		for (int i = 0; i < BOX_SIZE; i++) {
			for (int j = 0; j < BOX_SIZE; j++) {
				if (sudokuField[j + (x/3) * 3][i + (y/ 3) * 3] == number) {
					return true;
				}
			}
		}

		return false;
	}

	private boolean isSafe(int x, int y, int number) {

		return !isNumberExistInRow(number, x) && !isNumberExistinColumn(number, y)
				&& !isNumberExistInBox(number, x, y);
	}
	
	private boolean isSolvable() {
		for (int i = 0; i < FIELD_SIZE; i++) {
			for (int j = 0; j < FIELD_SIZE; j++) {
				if(sudokuField[i][j]== 0) {
					continue;
				}
				int temp = sudokuField[i][j];
				sudokuField[i][j] =0;
				if(!isSafe(i, j, temp)) {
					sudokuField[i][j] =temp;
					return false;
				}
				sudokuField[i][j] =temp;
			}
		}
		return true;
	}

	public boolean resolve() {
		if(!isSolvable()) {
			return false;
		}
		return solve(new Point(0, 0));

	}
	
	

	private boolean solve(Point currentPoint) {
		if (currentPoint.y == FIELD_SIZE) {
			return true;
		}
		Point next = currentPoint.next();

		if (sudokuField[currentPoint.x][currentPoint.y] != 0) {
			return solve(next);
		}

		for (int i = 1; i <= MAX_VALUE; i++) {

			if (!isSafe(currentPoint.x, currentPoint.y, i)) {
				continue;
			}
			
			sudokuField[currentPoint.x][currentPoint.y] = i;
			next = currentPoint.next(); 
			
			if (solve(next)) {
				return true;
			}

			sudokuField[currentPoint.x][currentPoint.y] = 0;
		}

		return false;

	}

	public int getField(int x, int y) {
		return sudokuField[x][y];
	}
	
	public void setField(int x, int y, int number) {
		 sudokuField[x][y] = number;
	}
	private class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public Point next() {
			if (this.x == 8) {
				return new Point(0, y+1);

			}

			return new Point(x+1, y);
		}
		


	}

}
