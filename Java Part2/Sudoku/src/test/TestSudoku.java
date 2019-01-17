package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sudoku.Sudoku;

class TestSudoku {
	Sudoku sudoku;

	@BeforeEach
	void setUp() throws Exception {
		sudoku = new Sudoku();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testInsolubleSudoku() {
		sudoku.addNumber(0, 0, 1);
		sudoku.addNumber(0, 1, 2);
		sudoku.addNumber(0, 2, 3);
		sudoku.addNumber(0, 3, 4);
		sudoku.addNumber(0, 4, 5);
		sudoku.addNumber(0, 5, 6);
		sudoku.addNumber(1, 6, 7);
		assertFalse(sudoku.resolve());
	}

	@Test
	void testEmptySudoku() {

		assertTrue(sudoku.resolve());
	}

	@Test
	void testSudokuWithOneSolution() {
		
		int data [][] = {
				{0,0,8,0,0,0,1,0,2},
				{0,0,9,0,0,0,5,0,0},
				{0,6,2,0,0,5,0,0,0},
				{0,0,0,0,5,0,6,0,0},
				{2,1,0,0,0,0,0,0,0},
				{0,9,0,6,0,0,0,2,8},
				{4,1,0,8,6,0,0,0,0},
				{6,0,8,0,3,0,0,0,0},
				{0,0,0,1,0,0,4,0,0}};
		
		int expected [][] =  {
				{5,4,8,3,7,6,1,9,2},
				{1,7,9,8,2,4,5,6,3},
				{3,6,2,9,1,5,8,7,4},
				{7,8,4,2,5,9,6,3,1},
				{2,1,6,3,8,7,9,4,5},
				{5,9,3,6,4,1,7,2,8},
				{4,1,5,8,6,7,9,2,3},
				{6,9,8,4,3,2,7,5,1},
				{2,3,7,1,5,9,4,8,6}};
		
		sudoku.setData(data);
		sudoku.resolve();
		assertTrue(Arrays.deepEquals(expected,sudoku.getData()));
		
	}

}