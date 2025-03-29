package opponent;
import player.Player;

/**
 * ROBOT
 * hard mode
 * @author Keola Teson :)
 */
public class Hard extends Opponent
{
	/**
	 * CONSTRUCTOR
	 * @param player
	 */
	public Hard(Player player)
	{
		super(player);
	}
	
	/**
	 * chooses the position of the O based on stuff
	 */
	public void chooseBox()
	{
		//leaves method if the check was successful and an O was placed
		if (checkRows())
		{
			System.out.println("row");
			return;
		}
		
		//ditto
		if (checkColumns())
		{
			System.out.println("column");
			return;
		}
		
		//ditto
		if (checkDiagonals())
		{
			System.out.println("diagonal");
			return;
		}
		
		//does if check fails
		chooseRandomly();
	}
	
	/**
	 * picks a position on the board randomly
	 */
	private void chooseRandomly()
	{
		int posY = 0;
		int posX = 0;
		
		while (player.getBoard().getBoard()[posY][posX] == 'X' || player.getBoard().getBoard()[posY][posX] == 'O')
		{
			posY = (int)(Math.random() * 3);
			posX = (int)(Math.random() * 3);
		}
		player.getBoard().changeBoardValue(posY, posX, 'O');
	}
	
	/**
	 * CHECK ONE
	 * checks the row to see if the player is close to winning
	 * @return true if the an O was placed
	 */
	protected boolean checkRows()
	{
		char[][] board = player.getBoard().getBoard();
		
		/*
		 * moves through the rows and checks for an almost win
		 * check for the amount of Os in the row because the bot wouldn't move passed that spot every time
		 */
		int amountX;
		int amountO;
		for (int i = 0; i < board.length; i++)
		{
			amountX = 0;
			amountO = 0;
			for (int j = 0; j < board[i].length; j++)
			{
				if (board[i][j] == 'X')
				{
					amountX++;
				}
				if (board[i][j] == 'O')
				{
					amountO++;
				}
			}
			if (amountO == 2 && amountX == 0)
			{
				placeORow(board);
				return true;
			}
			else if (amountX == 2 && amountO == 0)
			{
				placeORow(board);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * STILL CHECK ONE
	 * called if the player is about to win
	 * seperated from check for organization duhhhhhhh
	 * @param board
	 */
	private void placeORow(char[][] board)
	{
		//places the O where the empty space is
		for (int i = 0; i < board.length; i++)
		{
			for (int j = 0; j < board[i].length; j++)
			{
				if (board[i][j] == ' ')
				{
					player.getBoard().changeBoardValue(i, j, 'O');
					return;
				}
			}
		}
	}
	
	/**
	 * CHECK TWO
	 * checks the columns to see if the player is close to winning
	 * @param posY
	 * @param posX
	 * @return true if an O was placed
	 */
	protected boolean checkColumns()
	{
		char[][] board = player.getBoard().getBoard();
		
		int amountX;
		int amountO;
		
		/*
		 * moves through the column and checks for an almost win
		 * check for the amount of Os in the row because the bot wouldn't move passed that spot every time
		 */
		for (int i = 0; i < board[0].length; i++)
		{
			amountX = 0;
			amountO = 0;
			for (int j = 0; j < board.length; j++)
			{
				if (board[j][i] == 'X')
				{
					amountX++;
				}
				if (board[j][i] =='O')
				{
					amountO++;
				}
			}
			if (amountO == 2 && amountX == 0)
			{
				placeOColumn(board);
				return true;
			}
			else if (amountX == 2 && amountO == 0)
			{
				placeOColumn(board);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * STILL CHECK TWO
	 * called if the player is about to win
	 * seperated from check for organization duhhhhhhh
	 * @param board
	 */
	private void placeOColumn(char[][] board)
	{
		//places the O where the empty space is
		for (int i = 0; i < board[0].length; i++)
		{
			for (int j = 0; j < board.length; j++)
			{
				if (board[j][i] == ' ')
				{
					player.getBoard().changeBoardValue(j, i, 'O');
					return;
				}
			}
		}
	}
	
	/**
	 * CHECK THREE
	 * checks diagonals for if the player is close to winning
	 * @param posY
	 * @param posX
	 * @return true if an O was placed
	 */
	protected boolean checkDiagonals()
	{
		char[][] board = player.getBoard().getBoard();
		
		int amountX = 0;
		int amountO = 0;
		
		//first check
		int posY = 0;
		int posX = 0;
		while (posY != 2 && posX != 2)
		{
			if (board[posY][posX] == 'X') amountX++;
			if (board[posY][posX] == 'O') amountO++;
			
			if (amountO == 2 && amountX == 0)
			{
				System.out.println("check 1 | o check");
				placeDiagonalOne(board);
				return true;
			}
			else if (amountX == 2 && amountO == 0)
			{
				System.out.println("check 1 | x check");
				placeDiagonalOne(board);
				return true;
			}
			
			posY++;
			posX++;
		}
		
		amountX = 0;
		amountO = 0;
		
		//second check
		posY = 0;
		posX = 2;
		while (posY != 2 && posX != 0)
		{
			if (board[posY][posX] == 'X') amountX++;
			if (board[posY][posX] == 'O') amountO++;
			
			if (amountO == 2 && amountX == 0)
			{
				System.out.println("check 2 | o check");
				placeDiagonalTwo(board);
				return true;
			}
			else if (amountX == 2 && amountO == 0)
			{
				System.out.println("check 2 | x check");
				placeDiagonalTwo(board);
				return true;
			}
			
			posY++;
			posX--;
		}
		
		return false;
	}
	
	private void placeDiagonalOne(char[][] board)
	{
		int posY = 0;
		int posX = 0;
		
		while (posY != 2 && posX != 2)
		{
			if (board[posY][posX] == ' ')
			{
				player.getBoard().changeBoardValue(posY, posX, 'O');
				return;
			}
		}
	}
	
	private void placeDiagonalTwo(char[][] board)
	{
		int posY = 0;
		int posX = 2;
		
		while (posY != 2 && posX != 0)
		{
			if (board[posY][posX] != ' ')
			{
				player.getBoard().changeBoardValue(posY, posX, 'O');
				return;
			}
			
			posY++;
			posX--;
		}
	}
}
