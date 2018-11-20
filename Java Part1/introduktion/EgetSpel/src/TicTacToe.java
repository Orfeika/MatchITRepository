import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	static Scanner scanner = new Scanner(System.in);
	static char[][] board = new char[3][3];
	static String player1, player2;
	static int counter = 0;  

	public static void createBoard() {
		for (int i = 0; i < 3; i++)
			for (int k = 0; k < 3; k++)
				board[i][k] = ' ';
	}

	public static boolean checkCoordinate(int x, int y) {
		if (board[x][y] != ' ') {
			return false;
		} else {
			return true;

		}

	}

	public static boolean gameOver() {
		for (int i = 0; i < 3; i++) {
			if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
				printWinner(board[i][0]);
				return true;
			}

			if (board[0][i] != ' ' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
				printWinner(board[0][i]);
				return true;
			}

		}
		if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]
				|| board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
			printWinner(board[1][1]);
			return true;
		}
		
		if(counter == 9) {
			System.out.println("Game over");
		}
		
		return false;

	}

	public static void computerMove() {
		Random random = new Random();
		int row = random.nextInt(3);
		int col = random.nextInt(3);
		while (checkCoordinate(row, col) == false) {
			row = random.nextInt(3);
			col = random.nextInt(3);
		}
		board[row][col] = 'O';
		System.out.println("Computer move is " + col + ":" + row);
	}

	public static void makeMove() {
		System.out.println("Enter a row and a column: ");
		int col = scanner.nextInt();
		int row = scanner.nextInt();
		while (checkCoordinate(row, col) == false) {
			System.out.println("\nCoordinates already in use. Please try again: ");
			col = scanner.nextInt();
			row = scanner.nextInt();
		}

		board[row][col] = 'X';
	}

	public static void printBoard() {
		System.out.println("\n");
		System.out.println("+ 0 + 1 + 2 +");
		System.out.println("+---+---+---+ +");
		System.out.println("| " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " | 0");
		System.out.println("+---+---+---+ +");
		System.out.println("| " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " | 1");
		System.out.println("+---+---+---+ +");
		System.out.println("| " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " | 2");
		System.out.println("+---+---+---+ +");
	}

	public static void createPlayer() {
		System.out.println("Enter name of a  player:");
		player1 = scanner.next();
		player2 = "computer";
		System.out.println(player1 + " X " + " vs " + player2 + " O ");
	}

	public static void printWinner(char winner) {
		if (winner == 'X') {
			System.out.println("You win!");
		} else if (winner == 'O') {
			System.out.println("Computer win");
		}

	}

	public static boolean firstMove() {
		return Math.random() < 0.5;
	}

	public static void main(String[] args) {
		createPlayer();
		createBoard();
		printBoard();

		boolean isPCturn = firstMove();
		while (gameOver() == false) {
			if (isPCturn) {
				computerMove();
			} else {
				makeMove();
			}
			isPCturn = !isPCturn;
			printBoard();
			counter++;

		}

	}

}