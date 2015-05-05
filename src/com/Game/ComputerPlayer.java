package com.Game;

import java.util.Scanner;

public class ComputerPlayer extends AbstractGameRule implements Player{
	int level;
	
	
	/* Here Markbox method has different functionality - It Marks box for HUMAN player as well as Computer Player
	 */ 
	@Override
	public void markBox(int curr)
	{
		Scanner in = new Scanner(System.in);
		boolean validInput = false;  // for input validation
		String str ="";
		boolean userFlag = false;
		int row=0, col = 0;
      do {
         if (curr == 1) {
            System.out.print("Player 'X', enter your move (row[1-3] SPACE column[1-3]): ");
         } else {
            System.out.println("This is Computer Turn ");
        	 userFlag = true;
        	 if (this.level == 1)
        		 str = getEasyBox();
        	 else
        		 str = getHardBox();
         }
         if(userFlag == false)
         {
        	 row = in.nextInt() - 1;  // array index starts at 0 instead of 1
        	 col = in.nextInt() - 1;
         }
         
         if(str != "" && userFlag == true)
         {
        	 String[] strRowCol = str.split(",");
        	 row = Integer.parseInt(strRowCol[0]);
        	 col = Integer.parseInt(strRowCol[1]);
         }
        // int row = in.nextInt() - 1;  // array index starts at 0 instead of 1
         //int col = in.nextInt() - 1;
         
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
	/*This method will travese through the 2D array and return the first EMPTY Box index
	 * 
	 */
	public String getEasyBox()
	{
		
		String indStr="";
		 for (int row = 0; row < ROWS; ++row) {
	         for (int col = 0; col < COLS; ++col) {
	            if(board[row][col] == EMPTY)
	            	indStr = String.valueOf(row) + "," + String.valueOf(col);
	         }
	      }
		 return indStr;
	}
	/*
	 * This method will return the index of the box after doing some analysis
	 * It will first check if there are any consecutive pair of 'X' for all the 3 cases
	 * 1 - Horizontally 2 - Vertically 3 - Diagonally 
	 */
	public String getHardBox()
	{
		String indStr ="";
		//Check Horizontally
		for (int row = 0; row < ROWS; ++row) {
	         for (int col = 0; col < COLS -2; ++col) {
	            if(board[row][col] == board[row][col+1] && board[row][col+2] == EMPTY)
	            {
	            	int emptyCol = col+2;
	            	indStr = String.valueOf(row) + "," + String.valueOf(emptyCol);
	            	return indStr;
	            }
	         }
	      }
		//Check Vertically
		if(indStr != "")
		{
			for (int col = 0; col < COLS; ++col) {
		         for (int row = 0; row < ROWS -2; ++row) {
		            if(board[col][row] == board[col][row+1] && board[col][row+2] == EMPTY)
		            {
		            	int emptyCol = col+2;
		            	indStr = String.valueOf(row) + "," + String.valueOf(emptyCol);
		            	return indStr;
		            }
		         }
		      }
		}
		//Check Diagonally
		if(indStr != "")
		{
			if(board[0][0] == board[1][1] && board[2][2] == EMPTY){ indStr = String.valueOf(2) + "," + String.valueOf(2); return indStr;}
			if(board[0][2] == board[1][1] && board[2][0] == EMPTY){ indStr = String.valueOf(2) + "," + String.valueOf(0); return indStr;}
			
			if(board[2][0] == board[1][1] && board[0][2] == EMPTY){ indStr = String.valueOf(0) + "," + String.valueOf(2); return indStr;}
			if(board[2][2] == board[1][1] && board[0][0] == EMPTY){ indStr = String.valueOf(0) + "," + String.valueOf(0); return indStr;}
		}
		if(indStr != "")
		{
			 for (int row = 0; row < ROWS; ++row) {
		         for (int col = 0; col < COLS; ++col) {
		            if(board[row][col] == EMPTY)
		            	indStr = String.valueOf(row) + "," + String.valueOf(col);
		         }
		      }
		}
		
		return indStr;
	}
}
