import java.util.Scanner;

/**
 * PLAYER CLASS
 * controls player logic and allows player to input what they want
 * @author Keola Teson :)
 */
public class Player
{
	/*
	 * ATTRIBUTES
	 * - Scanner (to type)
	 * - Board (to access the board methods duhhhhhhhh)
	 */
	private Scanner scanner = new Scanner(System.in);;
	private Board board;
	
	/**
	 * CONSTRUCTOR
	 * @param board
	 */
	public Player(Board board)
	{
		this.board = board;
	}
	
	/**
	 * allows player to choose a row
	 * @return what row they chose (posY)
	 */
	private int chooseRow()
	{
		/*
		 * loops until the player inputted a number wanted
		 */
		int posY = 0;
		while (posY < 1 || posY > 3)
		{
			System.out.println("Choose a row (1 | 2 | 3):");
			try
			{
				posY = scanner.nextInt();
			}
			catch (Exception e)
			{
				System.out.println("That is not a number. Try again.");
			}
		}
		return posY;
	}
	
	/**
	 * allows player to choose a column
	 * @return what column they chose (posX)
	 */
	private int chooseColumn()
	{
		/*
		 * loops until the player inputted a number wanted
		 */
		int posX = 0;
		while (posX < 1 || posX > 3)
		{
			System.out.println("Choose a column (1 | 2 | 3):");
			try
			{
				posX = scanner.nextInt();
			}
			catch (Exception e)
			{
				System.out.println("That is not a number. Try again.");
			}
		}
		return posX;
	}
	
	/**
	 * uses the two choose methods to change values on the board
	 */
	public void chooseBox()
	{
		board.changeBoardValue(chooseRow() - 1, chooseColumn() - 1, 'X');
	}
	
	/**
	 * GETTER
	 * allows other classes to access the board
	 * called BoardRef because getBoard().getBoard() looks confusing asl
	 */
	public Board getBoardRef()
	{
		return board;
	}
	
	public Scanner getScanner()
	{
		return scanner;
	}
	/**
	 * allows the scanner to be actually closed
	 * (idk if i actually need it but i have it just in case)
	 */
	public void closeScanner()
	{
		scanner.close();
	}
}
