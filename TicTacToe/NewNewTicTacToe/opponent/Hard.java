package opponent;

import player.Player;

public class Hard extends Normal
{
	public Hard(Player player)
	{
		super(player);
	}

	@Override
	public void chooseBox()
	{
		//leaves method if the check was successful and an O was placed
		if (checkRows()) return;
		//ditto
		if (checkColumns()) return;
		//ditto
		if (checkDiagonals())
		{
			System.out.println(true);
			return;
		}
		
		playBestMoves();
	}
	
	private void playBestMoves()
	{
		char[][] board = player.getBoard().getBoard();
		
		// best move if the player put X in center (first move)
		if (board[1][1] == 'X' && board[0][0] == ' ')
		{
			player.getBoard().changeBoardValue(0, 0, 'O');
			return;
		}
		
		int posY = 0;
		int posX;
		
		// best move if the player puts X in corner (first move)
		while (posY <= 2)
		{
			posX = 0;
			while (posX <= 2)
			{
				if (board[posY][posX] == 'X' && board[1][1] == ' ')
				{
					player.getBoard().changeBoardValue(1, 1, 'O');
					return;
				}
				posX += 2;
			}
			posY += 2;
		}
		
		// best move if the player puts X on side (first move)
		if ((board[0][1] == 'X' || board[1][0] == 'X') && board[0][0] == ' ')
		{
			player.getBoard().changeBoardValue(0, 0, 'O');
			return;
		}
		else if (board[1][2] == 'X' && board[0][2] == ' ')
		{
			player.getBoard().changeBoardValue(0, 2, 'O');
			return;
		}
		else if (board[2][1] == 'X' && board[0][1] == ' ')
		{
			player.getBoard().changeBoardValue(0, 1, 'O');
			return;
		}
		
		if (lookForWins(board))
		{
			// best move if the player puts X in corner (second move)
			posY = 0;
			posX = 0;
			
			while (posY <= 2)
			{
				posX = 0;
				while (posX <= 2)
				{
					if (board[posY][posX] == 'X' && board[0][1] == ' ')
					{
						player.getBoard().changeBoardValue(0, 1, 'O');
						return;
					}
					posX += 2;
				}
				posY += 2;
			}
		}
	}
	
	/**
	 * looks for wins from not obvious positions
	 * @param board
	 */
	private boolean lookForWins(char[][] board)
	{
		/**
		 * ROW
		 * looks for wins in the rows
		 */
		for (int i = 0; i < board.length; i++)
		{
			if (board[i][0] == 'O' && board[i][1] == ' ' && board[i][2] == ' ')
			{
				player.getBoard().changeBoardValue(i, 2, 'O');
				return false;
			}
		}
		
		/**
		 * COLUMN
		 * looks for wins in the columns
		 */
		for (int i = 0; i < board[0].length; i++)
		{
			if (board[0][i] == 'O' && board[1][i] == ' ' && board[2][i] == ' ')
			{
				player.getBoard().changeBoardValue(2, i, 'O');
				return false;
			}
		}
		
		return true;
	}
}
