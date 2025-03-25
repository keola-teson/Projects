import java.util.Scanner;

public class Player
{
	private Scanner scanner = new Scanner(System.in);;
	private Board board;
	
	public Player(Board board)
	{
		this.board = board;
	}
	
	private int chooseRow()
	{
		System.out.println("Choose a row (1 | 2 | 3):");
		int posY = 0;
		while (posY < 1 || posY > 3)
		{
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
	
	private int chooseColumn()
	{
		System.out.println("Choose a column (1 | 2 | 3):");
		int posX = 0;
		while (posX < 1 || posX > 3)
		{
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
	
	public Board getBoard()
	{
		return board;
	}
	
	public void chooseBox()
	{
		board.changeBoardValue(chooseRow() - 1, chooseColumn() - 1, 'X');
	}
	
	public void closeScanner()
	{
		scanner.close();
	}
}
