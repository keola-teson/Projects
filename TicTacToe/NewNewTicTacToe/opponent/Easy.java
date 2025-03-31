package opponent;

import player.Player;

/**
 * ROBOT
 * easy mode
 * @author Keola Teson :)
 */
public class Easy extends Opponent
{
	public Easy(Player player)
	{
		super(player);
	}
	
	@Override
	public void chooseBox()
	{
		//randomly chooses a position on the board
		int posY = (int)(Math.random() * player.getBoard().getBoard().length);
		int posX = (int)(Math.random() * player.getBoard().getBoard().length);
		
		while (player.getBoard().getBoard()[posY][posX] == 'X' || player.getBoard().getBoard()[posY][posX] == 'O')
		{
			posY = (int)(Math.random() * player.getBoard().getBoard().length);
			posX = (int)(Math.random() * player.getBoard().getBoard().length);
		}
		
		player.getBoard().changeBoardValue(posY, posX, 'O');
	}

	/*
	 * UNUSED METHODS
	 * ------------------------------------------------------
	 */
	@Override
	protected boolean checkRows() { return false; }

	@Override
	protected boolean checkColumns() { return false; }

	@Override
	protected boolean checkDiagonals() { return false; }
	
}