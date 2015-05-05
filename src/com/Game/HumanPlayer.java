package com.Game;

import java.util.Scanner;

public class HumanPlayer extends AbstractGameRule implements Player{
	char sign ;
	public HumanPlayer()
	{
		
	}
			   
	@Override
	public void markBox(int curr)
	{
		Scanner in = new Scanner(System.in);
		boolean validInput = false;  // for input validation
      do {
         if (curr == 1) {
            System.out.print("Player 'X', enter your move (row[1-3] SPACE column[1-3]): ");
         } else {
            System.out.print("Player 'O', enter your move (row[1-3] SPACE column[1-3]): ");
         }
         int row = in.nextInt() - 1;  // array index starts at 0 instead of 1
         int col = in.nextInt() - 1;
         validInput = isValidInput(row, col);
         if (validInput == true) {
            currntRow = row;
            currentCol = col;
            board[currntRow][currentCol] = curr;  // update game-board content
            validInput = true;  // input okay, exit loop
         } else {
            System.out.println("This move at (" + (row + 1) + "," + (col + 1)
                  + ") is not valid. Try again...");
         }
      } while (!validInput);  // repeat until input is valid

	}
	

}
