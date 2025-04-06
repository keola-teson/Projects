package player;

import opponent.Opponent;
import java.util.Scanner;

/**
 * OPPONENT CLASS
 * allows a second player to play
 * 
 * reason for extending opponent: bc it makes the logic in main work
 * @author Keola Teson :)
 */
public class PlayerTwo extends Opponent
{
	private Scanner scanner = player.getScanner();
	
	/**
	 * CONSTRUCTOR
	 * @param board
	 */
	public PlayerTwo(Player player)
	{
		super(player);
	}
	
	/**
	 * allows player 2 to choose a row
	 * @return what row they chose (posY)
	 */
	private int chooseRow()
	{
		System.out.println("Choose a column (1 | 2 | 3):");
		/*
		 * loops until the player inputted a number wanted
		 */
		int posY = player.checkInput(scanner.nextLine());
		while (posY < 1 || posY > 3)
		{
			System.out.println("That's not a valid position. Try again.\n");
			System.out.println("Choose a row (1 | 2 | 3):");
			posY = player.checkInput(scanner.nextLine());
		}
		return posY;
	}
	
	/**
	 * allows player 2 to choose a column
	 * @return what column they chose (posX)
	 */
	private int chooseColumn()
	{
		System.out.println("Choose a row (1 | 2 | 3):");
		/*
		 * loops until the player inputted a number wanted
		 */
		int posX = player.checkInput(scanner.nextLine());
		while (posX < 1 || posX > 3)
		{
			System.out.println("That's not a valid position. Try again.\n");
			System.out.println("Choose a row (1 | 2 | 3):");
			posX = player.checkInput(scanner.nextLine());
		}
		return posX;
	}
	
	/**
	 * uses the two choose methods to change values on the board
	 */
	public void chooseBox()
	{
		int posY = chooseRow() - 1;
		int posX = chooseColumn() - 1;
		
		while (player.getBoard().getBoard()[posY][posX] != ' ')
		{
			System.out.println("That position is taken. Please choose another position.");
			posY = chooseRow() - 1;
			posX = chooseColumn() - 1;
		}
		
		player.getBoard().changeBoardValue(posY, posX, 'O');
	}

	/*
	 * UNUSED METHODS
	 * ----------------------------------------------
	 */
	@Override
	protected boolean checkRows()
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean checkColumns()
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean checkDiagonals()
	{
		// TODO Auto-generated method stub
		return false;
	}
}
