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
		int randNum = (int)(Math.random() * 10) + 1;
		if (randNum <= 8)
		{
			if (checkRows()) return; //leaves method if the check was successful and an O was placed
			
			if (checkColumns()) return; //ditto
			
			if (checkDiagonals()) return; //ditto
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
			posY = (int)(Math.random() * 3);
			posX = (int)(Math.random() * 3);
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
			if (amountX == 2 && amountO == 0)
			{
				placeORow(board);
				return true;
			}
		}
		return false;
	}

	
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

	@Override
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
			if (amountX == 2 && amountO == 0)
			{
				placeOColumn(board);
				return true;
			}
		}
		return false;
	}

	
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
				}
			}
		}
	}

	@Override
	protected boolean checkDiagonals()
	{
		char[][] board = player.getBoard().getBoard();
		
		//checks if player is about to win
		if (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] != 'O')
		{
			player.getBoard().changeBoardValue(2, 2, 'O');
			return true;
		}
		else if (board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] != 'O')
		{
			player.getBoard().changeBoardValue(2, 0, 'O');
			return true;
		}
		
		return false;
	}
}
