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
		int posY = (int)(Math.random() * 3);
		int posX = (int)(Math.random() * 3);
		
		while (player.getBoard().getBoard()[posY][posX] == 'X' || player.getBoard().getBoard()[posY][posX] == 'O')
		{
			posY = (int)(Math.random() * 3);
			posX = (int)(Math.random() * 3);
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