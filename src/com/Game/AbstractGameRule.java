package com.Game;

public abstract class AbstractGameRule {
	// Constatnts
	public static final int EMPTY = 0;
	public static final int CROSS = 1;
	public static final int NOUGHT = 2;

	// Name-constants to represent the various states of the game
	public static final int PLAYING = 0;
	public static final int DRAW = 1;
	public static final int CROSS_WON = 2;
	public static final int NOUGHT_WON = 3;

	// The game board and the game status
	public static final int ROWS = 3, COLS = 3; // number of rows and columns
	public static int[][] board = new int[ROWS][COLS]; // game board in 2D array
														// containing (EMPTY,
														// CROSS, NOUGHT)
	public static int currentState; // the current state of the game
									// (PLAYING, DRAW, CROSS_WON, NOUGHT_WON)
	public static int currentPlayer; // the current player (CROSS or NOUGHT)
	public static int currntRow, currentCol; // current seed's row and column
	public Boolean validInput;

	public AbstractGameRule() {
		for (int row = 0; row < ROWS; ++row) {
			for (int col = 0; col < COLS; ++col) {
				board[row][col] = EMPTY; // all cells empty
			}
		}
		currentState = PLAYING; // ready to play
		currentPlayer = CROSS; // cross plays first
	}

	public Boolean isValidInput(int row, int col) {
		if (row >= 0 && row < ROWS && col >= 0 && col < COLS
				&& board[row][col] == EMPTY) {
			validInput = true; // input okay, exit loop
			return validInput;
		} else {
			validInput = false;
			return validInput;
		}
	}

	/**
	 * Return true if the player with "theSeed" has won after placing at
	 * (currentRow, currentCol)
	 */
	public static boolean hasWon(int theSeed, int currentRow, int currentCol) {
		return (board[currentRow][0] == theSeed // 3-in-the-row
				&& board[currentRow][1] == theSeed
				&& board[currentRow][2] == theSeed
				|| board[0][currentCol] == theSeed // 3-in-the-column
				&& board[1][currentCol] == theSeed
				&& board[2][currentCol] == theSeed
				|| currentRow == currentCol // 3-in-the-diagonal
				&& board[0][0] == theSeed
				&& board[1][1] == theSeed
				&& board[2][2] == theSeed || currentRow + currentCol == 2 // 3-in-the-opposite-diagonal
				&& board[0][2] == theSeed
				&& board[1][1] == theSeed
				&& board[2][0] == theSeed);
	}

	/** Return true if it is a draw (no more empty cell) */
	// TODO: Shall declare draw if no player can "possibly" win
	public static boolean isDraw() {
		for (int row = 0; row < ROWS; ++row) {
			for (int col = 0; col < COLS; ++col) {
				if (board[row][col] == EMPTY) {
					return false; // an empty cell found, not draw, exit
				}
			}
		}
		return true; // no empty cell, it's a draw
	}

	/** Print the game board */
	public static void printBoard() {
		for (int row = 0; row < ROWS; ++row) {
			for (int col = 0; col < COLS; ++col) {
				printCell(board[row][col]); // print each of the cells
				if (col != COLS - 1) {
					System.out.print("||"); // print vertical partition
				}
			}
			System.out.println();
			if (row != ROWS - 1) {
				System.out.println("============"); // print horizontal
													// partition
			}
		}
		System.out.println();
	}

	/**
	 * Update the "currentState" after the player with "theSeed" has placed on
	 * (currentRow, currentCol).
	 */
	public static void updateGame(int theSeed, int currentRow, int currentCol) {

		if (hasWon(theSeed, currentRow, currentCol)) { // check if winning move
			currentState = (theSeed == CROSS) ? CROSS_WON : NOUGHT_WON;
		} else if (isDraw()) { // check for draw
			currentState = DRAW;
		}
		// Otherwise, no change to currentState (still PLAYING).
	}

	/** Print a cell with the specified "content" */
	public static void printCell(int content) {
		switch (content) {
		case EMPTY:
			System.out.print("   ");
			break;
		case NOUGHT:
			System.out.print(" O ");
			break;
		case CROSS:
			System.out.print(" X ");
			break;
		}
	}

}
