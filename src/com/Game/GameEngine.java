package com.Game;

public class GameEngine extends AbstractGameRule{

	public GameEngine()
	{
		
	}
	/* This method starts the game and it gets executed till the end(result gets out)
	 * */
	public void startGame(Player player)
	{					
		      // Play the game once
		      do {
		    	  
		         player.markBox(currentPlayer); // update currentRow and currentCol
		         updateGame(currentPlayer, currntRow, currentCol); // update currentState
		         printBoard();
		         // Print message if game-over
		         if (currentState == CROSS_WON) {
		            System.out.println("'X' won! Bye!");
		         } else if (currentState == NOUGHT_WON) {
		            System.out.println("'O' won! Bye!");
		         } else if (currentState == DRAW) {
		            System.out.println("It's a Draw! Bye!");
		         }
		         // Switch player
		         currentPlayer = (currentPlayer == CROSS) ? NOUGHT : CROSS;
		      } while (currentState == PLAYING); // repeat if not game-over
		   }
	
}
