package com.Game;

import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in); // the input Scanner
		GameEngine engObj;
		System.out.println("Do you want to play ? ");
		System.out.println("Press 1 -  For 2 Player game (Both Human)");
		System.out.println("Press 2 - For 1 Player game (One Human and Another Computer player)");
		int choice = in.nextInt();
		System.out.println("choice " + choice);
		HumanPlayer humPlayer = new HumanPlayer();
		if (choice == 1)
		{
			engObj = new GameEngine();
			engObj.startGame(humPlayer);
		}
		else if(choice == 2)
		{
			System.out.println("Press 1 -  For 'EASY' Level");
			System.out.println("Press 2 - For 'HARD' Level");
			int level = in.nextInt();
			ComputerPlayer compObj = new ComputerPlayer();
			compObj.level = level;
			engObj = new GameEngine();
			engObj.startGame(compObj);
		}
		/*else
			CompPlayer player2 = new CompPlayer('O')*/
		else
		{
			System.out.println("Invalid choice");
			System.exit(0);
		}
		
	}

}
