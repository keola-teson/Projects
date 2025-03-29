package opponent;

import player.Player;

/**
 * ROBOT
 * impossible mode
 * for the people like DANIEL who don't wanna follow instructions
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
		//replaces any X on the board with O
		for (int i = 0; i < player.getBoard().getBoard().length; i++)
		{
			for (int j = 0; j < player.getBoard().getBoard()[i].length; j++)
			{
				if (player.getBoard().getBoard()[i][j] == 'X')
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
