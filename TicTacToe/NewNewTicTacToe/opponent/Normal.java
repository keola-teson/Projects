package opponent;
import player.Player;

/**
 * ROBOT
 * normal mode
 * @author Keola Teson :)
 */
public class Normal extends Opponent
{
	public Normal(Player player)
	{
		super(player);
	}

	@Override
	public void chooseBox()
	{
		int chance = (int)(Math.random() * 10) + 1; // 80% chance of playing smart, 20% not
		if (chance <= 8)
		{
			if (checkRows()) return; // leaves method if the check was successful and an O was placed
			
			if (checkColumns()) return; // ditto
			
			if (checkDiagonals()) return; // ditto
		}
		
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
			posY = (int)(Math.random() * player.getBoard().getBoard().length);
			posX = (int)(Math.random() * player.getBoard().getBoard().length);
		}
		player.getBoard().changeBoardValue(posY, posX, 'O');
	}

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
			amountX = 0;
			amountO = 0;
			
			posY = i;
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
			if (amountX == player.getBoard().getBoard().length - 1 && amountO == 0)
			{
				placeORow(board, posY);
				return true;
			}
		}
		return false;
	}

	
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
			if (amountX == board.length - 1 && amountO == 0)
			{
				placeOColumn(board, posX);
				return true;
			}
		}
		return false;
	}

	
	private void placeOColumn(char[][] board, int posX)
	{
		for (int j = 0; j < board.length; j++)
		{
			if (board[j][posX] == ' ')
			{
				player.getBoard().changeBoardValue(j, posX, 'O');
			}
		}
	}

	/**
	 * FOR DOCUMENTATION LOOK AT {@link opponent.Hard#checkDiagonals()} CLASS
	 */
	@Override
	protected boolean checkDiagonals()
	{
		char[][] board = player.getBoard().getBoard();
		
		int amountX = 0;
		int amountO = 0;
		
		//first check
		int posY = 0;
		int posX = 0;
		while (posY < board.length)
		{
			if (board[posY][posX] == 'X') amountX++;
			if (board[posY][posX] == 'O') amountO++;
			
			if (amountX == board.length && amountO == 0)
			{
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
		posX = board.length - 1;
		while (posY < board.length)
		{
			if (board[posY][posX] == 'X') amountX++;
			if (board[posY][posX] == 'O') amountO++;
			
			if (amountX == board.length && amountO == 0)
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
		int posX = player.getBoard().getBoard().length - 1;
		
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
