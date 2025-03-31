package opponent;

import player.Player;

/**
 * ROBOT
 * impossible mode
 * for the people like DANIEL and ELLA who don't wanna follow instructions
 * 
 * @author Keola Teson :)
 */
public class Impossible extends Opponent
{
	public Impossible(Player player)
	{
		super(player);
	}
	
	@Override
	public void chooseBox()
	{
		char[][] board = player.getBoard().getBoard();
		
		//replaces any X on the board with O
		for (int i = 0; i < board.length; i++)
		{
			for (int j = 0; j < board[i].length; j++)
			{
				if (board[i][j] == 'X')
				{
					player.getBoard().changeBoardValue(i, j, 'O');
				}
			}
		}
	}

	@Override
	protected boolean checkRows()
	{
		return false;
	}

	@Override
	protected boolean checkColumns()
	{
		return false;
	}

	@Override
	protected boolean checkDiagonals()
	{
		return false;
	}

}
