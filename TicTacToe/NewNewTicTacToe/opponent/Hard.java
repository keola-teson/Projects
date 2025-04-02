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
	@Override
	public void chooseBox()
	{
		//leaves method if the check was successful and an O was placed
		if (checkRows()) return;
		//ditto
		if (checkColumns()) return;
		//ditto
		if (checkDiagonals()) return;
		
		//does if check fails
		chooseRandomly();
	}
	
	/**
	 * picks a position on the board randomly
	 */
	private void chooseRandomly()
	{
		int posY = (int)(Math.random() * player.getBoard().getBoard().length);
		int posX = (int)(Math.random() * player.getBoard().getBoard().length);
		
		while (player.getBoard().getBoard()[posY][posX] != ' ')
		{
			posY = (int)(Math.random() * player.getBoard().getBoard().length);
			posX = (int)(Math.random() * player.getBoard().getBoard().length);
		}
		player.getBoard().changeBoardValue(posY, posX, 'O');
	}
	
	/**
	 * CHECK ONE
	 * checks the row to see if the player is close to winning
	 * @return true if the an O was placed
	 */
	@Override
	protected boolean checkRows()
	{
		char[][] board = player.getBoard().getBoard();
		
		/*
		 * moves through the rows and checks for an almost win
		 * check for the amount of Os in the row because the bot wouldn't move passed that spot every time
		 */
		int amountX;
		int amountO;
		
		int posY;
		for (int i = 0; i < board.length; i++)
		{
			posY = i;
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
			if (amountO == board.length - 1 && amountX == 0)
			{
				placeORow(board, posY);
				return true;
			}
			else if (amountX == board.length - 1 && amountO == 0)
			{
				placeORow(board, posY);
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
	private void placeORow(char[][] board, int posY)
	{
		for (int j = 0; j < board[posY].length; j++)
		{
			if (board[posY][j] == ' ')
			{
				player.getBoard().changeBoardValue(posY, j, 'O');
				return;
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
	@Override
	protected boolean checkColumns()
	{
		char[][] board = player.getBoard().getBoard();
		
		int amountX;
		int amountO;
		
		int posX;
		/*
		 * moves through the column and checks for an almost win
		 * check for the amount of Os in the row because the bot wouldn't move passed that spot every time
		 */
		for (int i = 0; i < board[0].length; i++)
		{
			amountX = 0;
			amountO = 0;
			
			posX = i;
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
			if (amountO == board.length - 1 && amountX == 0)
			{
				placeOColumn(board, posX);
				return true;
			}
			else if (amountX == board.length - 1 && amountO == 0)
			{
				placeOColumn(board, posX);
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
	private void placeOColumn(char[][] board, int posX)
	{
		for (int j = 0; j < board[0].length; j++)
		{
			if (board[j][posX] == ' ')
			{
				player.getBoard().changeBoardValue(j, posX, 'O');
				return;
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
	@Override
	protected boolean checkDiagonals()
	{
		char[][] board = player.getBoard().getBoard();
		
		int amountX = 0;
		int amountO = 0;
		
		/*
		 * first check
		 * - starts at (0, 0) and checks for an X or O
		 * - checks if the amount of Xs or Os in a diagonal is 2 and either
		 *   - wins the game
		 *   - or stops the player from winning
		 * - incrememnts posY and posX to move to next diagonal
		 */
		int posY = 0;
		int posX = 0;
		while (posY < board.length)
		{
			if (board[posY][posX] == 'X') amountX++;
			if (board[posY][posX] == 'O') amountO++;
			
			if (amountO == board.length - 1 && amountX == 0)
			{
				placeDiagonalOne(board);
				return true;
			}
			else if (amountX == board.length - 1 && amountO == 0)
			{
				placeDiagonalOne(board);
				return true;
			}
			
			posY++;
			posX++;
		}
		
		amountX = 0;
		amountO = 0;
		
		/*
		 * second check
		 * ditto
		 */
		posY = 0;
		posX = board.length - 1;
		while (posY < board.length)
		{
			if (board[posY][posX] == 'X') amountX++;
			if (board[posY][posX] == 'O') amountO++;
			
			if (amountO == board.length && amountX == 0)
			{
				placeDiagonalTwo(board);
				return true;
			}
			else if (amountX == board.length && amountO == 0)
			{
				placeDiagonalTwo(board);
				return true;
			}
			
			posY++;
			posX--;
		}
		
		return false;
	}
	
	/**
	 * PLACE DIAGONAL
	 * places an O if called on a square [0][0], [1][1], or [2][2]
	 * @param board
	 */
	private void placeDiagonalOne(char[][] board)
	{
		int posY = 0;
		int posX = 0;
		
		while (posY < player.getBoard().getBoard().length)
		{
			if (board[posY][posX] == ' ')
			{
				player.getBoard().changeBoardValue(posY, posX, 'O');
				return;
			}
			
			posY++;
			posX++;
		}
	}
	
	/**
	 * PLACE DIAGONAL
	 * places an O if called on a square [0][2], [1][1], [2][0]
	 * @param board
	 */
	private void placeDiagonalTwo(char[][] board)
	{
		int posY = 0;
		int posX = 2;
		
		while (posY < player.getBoard().getBoard().length)
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
